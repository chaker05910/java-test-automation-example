package org.dmukhin.general.config.environment.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Data Transfer Object for environment configuration settings. This class is used to store and
 * manage configuration settings such as API URL, port, and base path. It extends BaseDto and
 * supports JSON serialization/deserialization.
 */
@JsonIgnoreProperties(ignoreUnknown = false)
public class EnvironmentConfigDto {

  @JsonProperty(value = "apiUrl", access = JsonProperty.Access.READ_WRITE)
  private String apiUrl;

  @JsonProperty(value = "webUrl", access = JsonProperty.Access.READ_WRITE)
  private String webUrl;

  @JsonProperty(value = "apiPort", access = JsonProperty.Access.READ_WRITE)
  private Integer apiPort;

  @JsonProperty(value = "apiBasePath", access = JsonProperty.Access.READ_WRITE)
  private String apiBasePath;

  /**
   * Retrieves the API URL.
   *
   * @return The API URL.
   */
  public String getApiUrl() {
    return apiUrl;
  }

  /**
   * Sets the API URL.
   *
   * @param apiUrl The API URL to set.
   * @return The current instance of EnvironmentConfigDto for method chaining.
   */
  public EnvironmentConfigDto setApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
    return this;
  }

  /**
   * Retrieves the API Port.
   *
   * @return The API Port.
   */
  public Integer getApiPort() {
    return apiPort;
  }

  /**
   * Sets the API Port.
   *
   * @param apiPort The API port to set.
   * @return The current instance of EnvironmentConfigDto for method chaining.
   */
  public EnvironmentConfigDto setApiPort(Integer apiPort) {
    this.apiPort = apiPort;
    return this;
  }

  /**
   * Retrieves the API Base Path.
   *
   * @return The API Base Path.
   */
  public String getApiBasePath() {
    return apiBasePath;
  }

  /**
   * Sets the API Base Path.
   *
   * @param apiBasePath The API base path to set.
   * @return The current instance of EnvironmentConfigDto for method chaining.
   */
  public EnvironmentConfigDto setApiBasePath(String apiBasePath) {
    this.apiBasePath = apiBasePath;
    return this;
  }


  public String getWebUrl() {
    return webUrl;
  }

  public void setWebUrl(String webUrl) {
    this.webUrl = webUrl;
  }

  /**
   * Compares this configuration DTO to another object for equality. The result is {@code true} if
   * and only if the argument is not {@code null} and is an EnvironmentConfigDto object that has the
   * same values for apiUrl, apiPort, and apiBasePath properties.
   *
   * @param o The object to compare this EnvironmentConfigDto against.
   * @return true if the given object represents an EnvironmentConfigDto equivalent to this config,
   * false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    EnvironmentConfigDto that = (EnvironmentConfigDto) o;

    return new EqualsBuilder().append(apiUrl, that.apiUrl)
        .append(webUrl, that.webUrl)
        .append(apiPort, that.apiPort)
        .append(apiBasePath, that.apiBasePath)
        .isEquals();
  }

  /**
   * Returns a hash code value for the configuration. This method is supported for the benefit of
   * hash tables such as those provided by {@link java.util.HashMap}. The hash code is computed
   * using the hash codes of the apiUrl, apiPort, and apiBasePath properties.
   *
   * @return a hash code value for this configuration.
   */
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(apiUrl)
        .append(webUrl)
        .append(apiPort)
        .append(apiBasePath)
        .toHashCode();
  }
}
