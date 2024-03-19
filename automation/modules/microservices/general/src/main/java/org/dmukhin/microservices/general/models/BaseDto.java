package org.dmukhin.microservices.general.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmukhin.general.objectmapper.DtoConverter;

/**
 * Abstract base class for Data Transfer Objects (DTOs). Provides common functionalities for DTOs,
 * including handling of unknown JSON fields and methods to convert DTOs to JSON strings.
 */
public abstract class BaseDto {

  protected static final Logger LOGGER = LogManager.getLogger();

  @JsonIgnore
  private final Map<Object, Object> unknownFields = new HashMap<>();

  /**
   * Retrieves any unknown fields that have been deserialized.
   *
   * @return A Map containing unknown field names and values.
   */
  @JsonAnyGetter
  public Map<Object, Object> any() {
    return unknownFields;
  }

  /**
   * Sets an unknown field during JSON deserialization.
   *
   * @param name  The name of the field.
   * @param value The value of the field.
   */
  @JsonAnySetter
  public void set(Object name, Object value) {
    unknownFields.put(name, value);
  }

  /**
   * Checks if there are any unknown fields present in the DTO.
   *
   * @return true if unknown fields are present, false otherwise.
   */
  public boolean hasUnknownProperties() {
    return !unknownFields.isEmpty();
  }

  /**
   * Converts the current DTO to a JSON string using DtoConverter.
   *
   * @return A JSON representation of the current DTO.
   */
  public String toJsonString() {
    return DtoConverter.dtoToJsonString(this);
  }

  /**
   * Converts the current DTO to a pretty formatted JSON string using DtoConverter. This format is
   * more readable but less compact compared to the standard JSON string.
   *
   * @return A pretty formatted JSON representation of the current DTO.
   */
  public String toPrettyJsonString() {
    return DtoConverter.dtoToPrettyJsonString(this);
  }

  /**
   * Overrides the toString method to provide a JSON representation of the DTO.
   *
   * @return A JSON string representation of the DTO.
   */
  @Override
  public String toString() {
    return toPrettyJsonString();
  }
}
