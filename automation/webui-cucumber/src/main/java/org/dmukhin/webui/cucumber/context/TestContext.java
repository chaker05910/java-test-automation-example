package org.dmukhin.webui.cucumber.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to manage test context data. Test context allows sharing data across different test
 * steps or methods.
 */
public class TestContext {

  // Map to store context data
  private final Map<String, Object> contextData;

  /**
   * Constructs a new TestContext with an empty data map.
   */
  public TestContext() {
    contextData = new HashMap<>();
  }

  /**
   * Sets a value in the test context for the specified key.
   *
   * @param key   The key for the context data.
   * @param value The value to be stored.
   */
  public void set(String key, Object value) {
    contextData.put(key, value);
  }

  /**
   * Retrieves a value from the test context for the specified key. The value is casted to the
   * specified class type.
   *
   * @param key   The key for the context data.
   * @param clazz The class type to cast the value to.
   * @param <T>   The type of the value to be retrieved.
   * @return The value associated with the key, casted to the specified class type.
   */
  public <T> T get(String key, Class<T> clazz) {
    return clazz.cast(contextData.get(key));
  }
}