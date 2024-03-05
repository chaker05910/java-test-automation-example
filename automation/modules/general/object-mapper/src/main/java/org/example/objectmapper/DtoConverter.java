package org.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.qameta.allure.Step;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.example.utils.FileUtil;

/**
 * Utility class for converting between DTOs (Data Transfer Objects) and JSON strings. This class
 * uses Jackson ObjectMapper for serialization and deserialization processes.
 */
public class DtoConverter {

  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * Default private constructor to prevent instantiation.
   */
  private DtoConverter() {
    // default private constructor, no object creation
  }

  /**
   * Converts a DTO object to a JSON string.
   *
   * @param dtoClass The DTO object to be converted to JSON.
   * @return JSON representation of the DTO as a String.
   */
  public static String dtoToJsonString(Object dtoClass) {
    ObjectMapper mapper = new ObjectMapper();
    return writeAsString(dtoClass, mapper, JsonInclude.Include.NON_NULL);
  }

  /**
   * Converts a DTO object to a pretty formatted JSON string.
   *
   * @param dtoClass The DTO object to be converted to a pretty JSON format.
   * @return Pretty formatted JSON representation of the DTO as a String.
   */
  public static String dtoToPrettyJsonString(Object dtoClass) {
    String result = Strings.EMPTY;
    ObjectMapper mapper = new ObjectMapper();
    try {
      result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dtoClass);
    } catch (JsonProcessingException e) {
      LOGGER.error(e.getMessage());
    }
    return result;
  }

  /**
   * Helper method to serialize a DTO object to a JSON string with the specified serialization
   * inclusion option.
   *
   * @param dtoClass The DTO object to be serialized.
   * @param mapper   The ObjectMapper to be used for serialization.
   * @param option   The serialization inclusion option.
   * @return JSON representation of the DTO as a String.
   */
  private static String writeAsString(Object dtoClass, ObjectMapper mapper,
      JsonInclude.Include option) {
    String result = Strings.EMPTY;
    try {
      mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
      mapper.setSerializationInclusion(option);
      result = mapper.writeValueAsString(dtoClass);
    } catch (JsonProcessingException e) {
      LOGGER.error(e.getMessage());
    }
    return result;
  }

  // Additional private method writeAsString description

  /**
   * Converts a string representation of JSON to a DTO object of the specified class.
   *
   * @param dtoClass The class of the DTO to which the JSON is to be converted.
   * @param content  The JSON string to be deserialized into a DTO.
   * @param <T>      The type of the DTO.
   * @return An instance of the DTO class with values populated from the JSON string.
   */
  @Step("Converts a string representation of JSON to a DTO object of the specified class")
  public static <T> T stringToDto(Class<T> dtoClass, String content) {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
      return objectMapper.readValue(content, dtoClass);
    } catch (IOException e) {
      LOGGER.error(e);
      return null;
    }
  }

  /**
   * Reads a JSON file from the specified path and deserializes it into a DTO of the specified
   * type.
   *
   * @param filePath      The path to the JSON file.
   * @param typeReference A TypeReference describing the type of DTO to be deserialized.
   * @param <T>           The type of the DTO.
   * @return An instance of the DTO with values populated from the JSON file.
   */
  @Step("Reads a JSON file from the specified path and deserializes it into a DTO of the specified type")
  public static <T> T jsonFileToDto(String filePath, TypeReference<T> typeReference) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try (InputStream inputStream = FileUtil.getFileInputStream(filePath, DtoConverter.class)) {
      return mapper.readValue(inputStream, typeReference);
    } catch (IOException e) {
      LOGGER.error(e);
    }
    return null;
  }

}
