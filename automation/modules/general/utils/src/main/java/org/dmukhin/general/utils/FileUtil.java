package org.dmukhin.general.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
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
  public static Properties readFileAsProperties(String filePath) {
    LOGGER.debug("Reads a properties file from the given file path: {}", filePath);
    Properties props = new Properties();
    try (InputStream myIs = FileUtil.class.getResourceAsStream(filePath)) {
      props.load(myIs);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to read properties file: %s".formatted(filePath), e);
    }
    return props;
  }

  /**
   * Checks if a file exists in the resources directory.
   *
   * @param filePath The file path relative to the resources directory.
   * @return True if the file exists, false otherwise.
   */
  public static boolean resourceExists(String filePath) {
    LOGGER.debug("Checking if resource exists at the given file path: {}", filePath);
    return FileUtil.class.getResourceAsStream(filePath) != null;
  }

  /**
   * Loads the contents of a file into a String.
   *
   * @param path The path to the file relative to the resources directory.
   * @return A String containing the contents of the file.
   */
  public static String loadFileAsString(String path) {
    LOGGER.debug("Load file as String from resources: {}", path);
    String fileContents = null;
    try (InputStream inputStream = FileUtil.class.getResourceAsStream(path)) {
      fileContents = new String(Objects.requireNonNull(inputStream).readAllBytes(),
          StandardCharsets.UTF_8);
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
  public static InputStream getFileInputStream(String filePath, Class<?> configClass)
      throws FileNotFoundException {
    LOGGER.debug(" Gets an InputStream from a file located at the specified filePath: {}",
        filePath);
    InputStream inputStream = configClass.getResourceAsStream(filePath);
    if (inputStream == null) {
      LOGGER.debug("Loading file from filesystem: {}", filePath);
      inputStream = new FileInputStream(filePath);
    }
    return inputStream;
  }
}