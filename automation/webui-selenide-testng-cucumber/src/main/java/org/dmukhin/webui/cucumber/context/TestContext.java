package org.dmukhin.webui.cucumber.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to manage test context data. Test context allows sharing data across different test
 * steps or methods.
 */
public class TestContext {

  private static final ThreadLocal<Map<String, Object>> contextData = ThreadLocal.withInitial(
      HashMap::new);

  private TestContext() {
  }

  /**
   * Stores an object in the context with the given key.
   *
   * @param key   the key to store the object under
   * @param value the object to store in the context
   */
  public static void setContext(String key, Object value) {
    contextData.get().put(key, value);
  }

  /**
   * Retrieves an object from the context using the given key.
   *
   * @param key the key to retrieve the object
   * @return the object stored in the context, or null if not found
   */
  public static Object getContext(String key) {
    return contextData.get().get(key);
  }
}