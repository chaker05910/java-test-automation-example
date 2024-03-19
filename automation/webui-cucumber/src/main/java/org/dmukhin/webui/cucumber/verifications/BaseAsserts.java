package org.dmukhin.webui.cucumber.verifications;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

/**
 * Base class for performing assertions in UI tests.
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
   * Verifies that the class name of a Selenide element matches the expected class name.
   */
  @Step("Verify that the class name of the element")
  protected void verifyElementClassName(SelenideElement element, String expectedClass) {
    LOGGER.debug("Verify selenide element class is expected: {}", expectedClass);
    element.shouldHave(attribute("class", expectedClass));
  }

  /**
   * Verifies that the text of a Selenide element matches the expected text.
   */
  @Step("Verify that the text of the element")
  protected void verifyElementText(SelenideElement element, String expectedText) {
    LOGGER.debug("Verify selenide element text is expected: {}", expectedText);
    element.shouldHave(text(expectedText));
  }

  /**
   * Verifies that a Selenide element is visible.
   */
  @Step("Verify that the element is visible")
  protected void verifyElementVisible(SelenideElement element) {
    LOGGER.debug("Verify selenide element should be visible");
    element.shouldBe(visible);
  }

  /**
   * Verifies that a Selenide element is not visible.
   */
  @Step("Verify that the element is not visible")
  protected void verifyElementNotVisible(SelenideElement element) {
    LOGGER.debug("Verify selenide element should not be visible");
    element.shouldNotBe(visible);
  }
}
