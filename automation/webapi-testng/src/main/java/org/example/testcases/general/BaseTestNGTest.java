package org.example.testcases.general;

import com.github.javafaker.Faker;

/**
 * Base class for TestNG test classes.
 * Provides common setup and utilities for TestNG tests.
 */
public class BaseTestNGTest {

  /**
   * Protected constructor to prevent instantiation from outside the class.
   */
  protected BaseTestNGTest() {
  }

  /**
   * Static instance of Faker for generating fake test data.
   * Faker is a Java library that generates fake data for testing purposes.
   */
  protected static final Faker faker = Faker.instance();

}
