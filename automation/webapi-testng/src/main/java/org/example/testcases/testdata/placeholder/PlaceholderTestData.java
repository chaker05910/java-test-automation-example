package org.example.testcases.testdata.placeholder;

/**
 * Utility class for accessing various test data generators.
 * This class provides static methods to get instances of test data generator classes.
 */
public class PlaceholderTestData {

  /**
   * Private constructor to prevent instantiation of this class.
   */
  private PlaceholderTestData(){}

  /**
   * Provides a static method to access the UserTestData generator.
   * This method creates and returns a new instance of UserTestData.
   *
   * @return An instance of UserTestData.
   */
  public static UserTestData userTestData() {
    return new UserTestData();
  }

}
