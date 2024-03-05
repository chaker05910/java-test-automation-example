package org.example.service.general;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.example.environment.EnvironmentProvider;
import org.example.environment.models.EnvironmentConfigDto;

/**
 * Abstract base class for web services. Provides common functionalities for web service classes,
 * including API configuration loading and default request specification setup.
 */
public abstract class AbstractWebService {

  protected String apiSetting;
  protected EnvironmentConfigDto apiConfig;

  /**
   * Constructor for the abstract web service class.
   *
   * @param apiSetting The API setting name to load specific configuration.
   */
  protected AbstractWebService(String apiSetting) {
    this.apiSetting = apiSetting;
    loadApiConfig();
  }

  /**
   * Abstract method to initialize request specification. This method needs to be implemented in
   * derived classes to set up specific request configurations.
   */
  protected abstract void initRequestSpecification();

  /**
   * Loads API configuration based on the provided API setting. The configuration is loaded from the
   * environment settings.
   */
  private void loadApiConfig() {
    apiConfig = EnvironmentProvider
        .provideEnvironment().getSettings(apiSetting);
  }

  /**
   * Creates and returns a default RequestSpecification for API requests. The specification includes
   * content type, base URI, port, and optional base path. Also adds logging filters for response,
   * request, and errors.
   *
   * @return The default RequestSpecification.
   */
  protected RequestSpecification getDefaultSpecification() {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder()
        .setContentType(ContentType.JSON)
        .setBaseUri(apiConfig.getApiUrl())
        .setPort(apiConfig.getApiPort());
    if (!StringUtils.isEmpty(apiConfig.getApiBasePath())) {
      specBuilder.setBasePath(apiConfig.getApiBasePath());
    }
    specBuilder
        .addFilter(new ResponseLoggingFilter())
        .addFilter(new RequestLoggingFilter())
        .addFilter(new AllureRestAssured())
        .addFilter(new ErrorLoggingFilter());

    return specBuilder.build();
  }
}
