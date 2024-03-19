package org.dmukhin.general.config.environment;

import com.fasterxml.jackson.core.type.TypeReference;
import io.qameta.allure.Step;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmukhin.general.config.environment.models.EnvironmentConfigDto;
import org.dmukhin.general.config.maven.MavenProperties;
import org.dmukhin.general.objectmapper.DtoConverter;

/**
 * The EnvironmentProvider class is a utility class used to load and provide configuration settings
 * for different environments (such as development, staging, production) in a web service context.
 * It follows a singleton pattern using ThreadLocal for thread safety.
 */
public class EnvironmentProvider {

  private static final Logger LOGGER = LogManager.getLogger();
  private static final String ENVIRONMENT_TEMPLATE = "/environments/%s/%s";
  private static final String ENVIRONMENTS_FILE = "environment_config.json";
  private static final ThreadLocal<EnvironmentProvider> LOADER = new ThreadLocal<>();
  private Map<String, EnvironmentConfigDto> serviceSetting;

  /**
   * Private constructor to prevent external instantiation.
   */
  private EnvironmentProvider() {
    // default private constructor
  }

  /**
   * Provides a singleton instance of EnvironmentProvider. Initializes the instance if not already
   * created and loads the environment properties.
   *
   * @return EnvironmentProvider instance for the current thread.
   */
  public static EnvironmentProvider provideEnvironment() {
    if (LOADER.get() == null) {
      EnvironmentProvider loader = new EnvironmentProvider();
      loader.loadEnvironmentProperties();
      LOADER.set(loader);
    }
    return LOADER.get();
  }

  /**
   * Retrieves the configuration settings for a given environment name.
   *
   * @param settingName The name of the setting to retrieve.
   * @return EnvironmentConfigDto containing the configuration settings for the specified
   * environment.
   */
  @Step("Retrieves the configuration settings for [{settingName}] environment name")
  public EnvironmentConfigDto getSettings(String settingName) {
    return serviceSetting.get(settingName);
  }

  /**
   * Loads environment properties from a JSON file, converting it into a map of EnvironmentConfigDto
   * objects. Determines the current environment and logs this information. Uses DtoConverter for
   * JSON to DTO conversion. The JSON file should match the structure of EnvironmentConfigDto
   */
  private void loadEnvironmentProperties() {
    String environment = MavenProperties.getCurrentEnvironment();
    if (StringUtils.isEmpty(environment)) {
      environment = "dev";
    }
    String envName = environment.toUpperCase();
    LOGGER.info("Automation tests run on Environment: [{}]", envName);

    final String environmentFile = String.format(ENVIRONMENT_TEMPLATE, environment,
        ENVIRONMENTS_FILE);
    LOGGER.debug("Read environments file from resources: [{}]", environmentFile);
    serviceSetting = DtoConverter.jsonFileToDto(environmentFile,
        new TypeReference<Map<String, EnvironmentConfigDto>>() {
        });
    Objects.requireNonNull(serviceSetting);
  }

  /**
   * Removes the thread-local instance of the class loader.
   * This method is typically called when the class loader is no longer needed, to clean up resources
   * and prevent memory leaks.
   */
  public void unload() {
    LOADER.remove();
  }
}
