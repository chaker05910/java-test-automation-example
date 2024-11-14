package org.dmukhin.webui.cucumber.stepdefinitions.verifications;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

/**
 * Base class for performing assertions in UI tests using Playwright.
 */
public abstract class BaseAsserts {

  protected static final Logger LOGGER = LogManager.getLogger();

  protected BaseAsserts() {
  }

  /**
   * Verifies that two objects are not equal.
   *
   * @param expected      The expected object.
   * @param actual        The actual object.
   * @param verifiedField The name of the field to help with logging.
   */
  @Step("Verify that two objects are not equal")
  protected void verifyObjectNotEqual(Object expected, Object actual, String verifiedField) {
    LOGGER.debug("Verify data <{}> not equaling expected: [{}], actual: [{}]", verifiedField,
        expected, actual);
    Assertions.assertThat(expected).as(verifiedField).isNotEqualTo(actual);
  }

  /**
   * Verifies that two lists of objects are equal.
   *
   * @param expected      The expected list of objects.
   * @param actual        The actual list of objects.
   * @param verifiedField The name of the field to help with logging.
   */
  @Step("Verify that two lists of objects are equal")
  protected void verifyObjects(List<Object> expected, List<Object> actual, String verifiedField) {
    LOGGER.debug("Verify data <{}> expected: [{}], actual: [{}]", verifiedField, expected,
        actual);
    Assertions.assertThat(expected).as(verifiedField).isEqualTo(actual);
  }

  /**
   * Verifies that a list of expected strings exactly matches a list of actual strings in any
   * order.
   *
   * @param expected      The expected list of strings.
   * @param actual        The actual list of strings.
   * @param verifiedField The field name used for logging the verification step.
   */
  @Step("Verify that a list of expected strings exactly matches a list of actual strings in any order")
  protected void verifyListOfStrings(List<String> expected, List<String> actual,
      String verifiedField) {
    LOGGER.debug("Verify List of Strings <{}> expected: [{}], actual: [{}]", verifiedField,
        expected, actual);
    Assertions.assertThat(expected).as(verifiedField)
        .containsExactlyInAnyOrderElementsOf(actual);
  }

  /**
   * Verifies that a list of actual strings contains all elements of an expected list of strings.
   *
   * @param expected      The expected list of strings.
   * @param actual        The actual list of strings.
   * @param verifiedField The field name used for logging the verification step.
   */
  @Step("Verify that a list of actual strings contains all elements of an expected list of strings")
  protected void verifyListOfStringsContains(List<String> expected, List<String> actual,
      String verifiedField) {
    LOGGER.debug("Verify List of Strings <{}> contains expected: [{}], actual: [{}]",
        verifiedField,
        expected, actual);
    Assertions.assertThat(actual).as(verifiedField).contains(expected.toArray(new String[0]));
  }

  /**
   * Verifies that the class name of a Playwright Locator matches the expected class name.
   */
  @Step("Verify that the class name of the element")
  protected void verifyElementClassName(Locator element, String expectedClass) {
    LOGGER.debug("Verify Playwright element class is expected: {}", expectedClass);
    Assertions.assertThat(element.getAttribute("class")).isEqualTo(expectedClass);
  }

  /**
   * Verifies that the text of a Playwright Locator matches the expected text.
   */
  @Step("Verify that the text of the element")
  protected void verifyElementText(Locator element, String expectedText) {
    LOGGER.debug("Verify Playwright element text is expected: {}", expectedText);
    Assertions.assertThat(element.textContent()).isEqualTo(expectedText);
  }

  /**
   * Verifies that a Playwright Locator is visible.
   */
  @Step("Verify that the element is visible")
  protected void verifyElementVisible(Locator element) {
    LOGGER.debug("Verify Playwright element should be visible");
    Assertions.assertThat(element.isVisible()).isTrue();
  }

  /**
   * Verifies that a Playwright Locator is not visible.
   */
  @Step("Verify that the element is not visible")
  protected void verifyElementNotVisible(Locator element) {
    LOGGER.debug("Verify Playwright element should not be visible");
    Assertions.assertThat(element.isVisible()).isFalse();
  }
}
