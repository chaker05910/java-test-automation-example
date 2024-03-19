package org.dmukhin.webapi.testng.testcases.groups;

/**
 * Defines constants for various test groups. This class provides a centralized location for
 * defining group names used in test categorization.
 */
public class TestGroups {

  /**
   * Test group name for regression tests.
   */
  public static final String REG = "regression";
  /**
   * Test group name for API tests.
   */
  public static final String API = "api";
  /**
   * Test group name for component tests.
   */
  public static final String COMP = "component";

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private TestGroups() {
    // default constructor
  }
}
