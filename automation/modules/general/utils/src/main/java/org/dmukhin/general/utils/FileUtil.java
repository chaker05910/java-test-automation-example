package org.dmukhin.general.utils;

import io.qameta.allure.Step;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for file operations. Provides methods for reading files, such as properties files
 * and loading file contents.
 */
public class FileUtil {

  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * Private constructor to prevent instantiation of utility class.
   */
  private FileUtil() {
    // default constructor
  }

  /**
   * Reads a properties file from the given file path.
   *
   * @param filePath The file path relative to the resources directory.
   * @return The Properties loaded from the file.
   */
  @Step("Read Properties file by file path")
  public static Properties readFileAsProperties(String filePath) {
    Properties props = new Properties();
    try (InputStream myIs = FileUtil.class.getResourceAsStream(filePath)) {
      props.load(myIs);
    } catch (Exception e) {
      throw new RuntimeException("Failed to read properties file: " + filePath, e);
    }
    return props;
  }

  /**
   * Loads the contents of a file into a String.
   *
   * @param path The path to the file relative to the resources directory.
   * @return A String containing the contents of the file.
   */
  @Step("Load file content by file path from resources")
  public static String loadFileAsString(String path) {
    LOGGER.info("Load file as String from resources: {}", path);
    String fileContents = null;
    try (InputStream inputStream = FileUtil.class.getResourceAsStream(path)) {
      fileContents = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException e) {
      LOGGER.error("Failed to load file as string: %s".formatted(path), e);
    }
    return fileContents;
  }

  /**
   * Gets an InputStream from a file located at the specified filePath. If the file is not found in
   * the classpath, it tries to load it from the filesystem.
   *
   * @param filePath    The path to the file.
   * @param configClass The class whose classloader will be used to load the resource.
   * @return An InputStream representing the file.
   * @throws FileNotFoundException If the file cannot be found.
   */
  @Step("Gets an input stream from a file")
  public static InputStream getFileInputStream(String filePath, Class<?> configClass)
      throws FileNotFoundException {
    InputStream inputStream = configClass.getResourceAsStream(filePath);
    if (inputStream == null) {
      LOGGER.info("Loading file from filesystem: {}", filePath);
      inputStream = new FileInputStream(filePath);
    }
    return inputStream;
  }
}
