package org.dmukhin.general.config.maven;

import io.qameta.allure.Step;
import java.util.Properties;
import org.dmukhin.general.utils.FileUtil;

/**
 * The MavenProperties class is designed to manage and provide access to Maven properties specified
 * in a properties file. It follows the singleton design pattern to ensure that only one instance of
 * the properties is loaded and used throughout the application.
 */
public class MavenProperties {

  private static final String MAVEN_PROPERTIES = "/maven.properties";
  private static final String ENVIRONMENT_PROPERTY = "execution.environment";
  private final Properties properties;

  /**
   * Private constructor to load Maven properties from the specified file.
   */
  private MavenProperties() {
    properties = FileUtil.readFileAsProperties(MAVEN_PROPERTIES);
  }

  /**
   * Provides access to the loaded Maven properties.
   *
   * @return Properties object containing Maven properties.
   */

  public static Properties getMavenProperties() {
    return SingletonHolder.INSTANCE.properties;
  }

  /**
   * Retrieves the current execution environment's name from the Maven properties.
   *
   * @return The value of the 'execution.environment' property, representing the current
   * environment.
   */
  @Step("Retrieves the current execution environment's name from the Maven properties")
  public static String getCurrentEnvironment() {
    return getMavenProperties().getProperty(ENVIRONMENT_PROPERTY);
  }

  /**
   * SingletonHolder is a static nested class holding the singleton instance of MavenProperties. It
   * ensures lazy initialization and thread safety for the MavenProperties instance.
   */
  private static class SingletonHolder {

    static final MavenProperties INSTANCE = new MavenProperties();

    private SingletonHolder() {
      //empty
    }
  }
}
