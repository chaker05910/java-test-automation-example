package org.dmukhin.general.config.maven;

import java.util.Properties;
import org.dmukhin.general.utils.FileUtil;

/**
 * The MavenProperties class is designed to manage and provide access to Maven properties specified
 * in a properties file. It follows the singleton design pattern to ensure that only one instance of
 * the properties is loaded and used throughout the application.
 */
public class MavenProperties {

  private static final String MAVEN_PROPERTIES = "/maven.properties";
  private static final String MAVEN_LOCAL_PROPERTIES = "/maven.local.properties";
  private static final String ENVIRONMENT_PROPERTY = "execution.environment";
  private static final String REMOTE_PROPERTY = "remote.pipeline";
  private static final String SELENIDE_DEBUG = "selenide.debug";
  private final Properties properties;

  /**
   * Private constructor to load Maven properties from the specified file.
   */
  private MavenProperties() {

    if (FileUtil.resourceExists(MAVEN_LOCAL_PROPERTIES)) {
      properties = FileUtil.readFileAsProperties(MAVEN_LOCAL_PROPERTIES);
    } else {
      properties = FileUtil.readFileAsProperties(MAVEN_PROPERTIES);
    }

    overrideWithSystemAndEnvVariables(properties);
  }

  /**
   * Provides access to the loaded Maven properties.
   *
   * @return Properties object containing Maven properties.
   */
  public static Properties getMavenProperties() {
    return Holder.INSTANCE.properties;
  }

  /**
   * Retrieves the current execution environment's name from the Maven properties.
   *
   * @return The value of the 'execution.environment' property, representing the current
   * environment.
   */
  public static String getCurrentEnvironment() {
    return getProperty(ENVIRONMENT_PROPERTY);
  }

  /**
   * Retrieves the remote pipeline's name from the Maven properties.
   *
   * @return The value of the 'remote.pipeline' property, representing the remote pipeline.
   */
  public static Boolean getRemotePipeline() {
    return Boolean.valueOf(getProperty(REMOTE_PROPERTY));
  }

  /**
   * Set Debug mode for selenide to check driver and Network log functionality.
   *
   * @return The value of the 'selenide.debug' property, representing the test data cleanup flag.
   */
  public static Boolean getSelenideDebug() {
    return Boolean.valueOf(getProperty(SELENIDE_DEBUG));
  }

  /**
   * Retrieves a property value from the system properties, environment variables, or Maven
   * properties.
   *
   * @param propertyName The name of the property to retrieve.
   * @return The value of the property.
   */
  private static String getProperty(String propertyName) {
    return System.getProperty(propertyName,
        System.getenv().getOrDefault(propertyName,
            getMavenProperties().getProperty(propertyName)));
  }

  /**
   * Overrides properties with values from system properties and environment variables if they
   * exist.
   *
   * @param properties The properties object to be overridden.
   */
  private void overrideWithSystemAndEnvVariables(Properties properties) {
    // Override with environment variables
    System.getenv().forEach((key, value) -> {
      if (properties.containsKey(key)) {
        properties.setProperty(key, value);
      }
    });

    // Override with system properties
    System.getProperties().forEach((key, value) -> {
      if (properties.containsKey(key.toString())) {
        properties.setProperty(key.toString(), value.toString());
      }
    });
  }

  /**
   * SingletonHolder is a static nested class holding the singleton instance of MavenProperties. It
   * ensures lazy initialization and thread safety for the MavenProperties instance.
   */
  private static class Holder {

    private static final MavenProperties INSTANCE = new MavenProperties();
  }
}

