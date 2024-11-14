package org.dmukhin.webui.cucumber.stepdefinitions.verifications.uitestingplayground;

import io.cucumber.java.en.And;
import org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground.TextInputPage;

/**
 * Verification assertions class for TextInputPage in UITestingPlayground.
 */
public class TextInputPageAsserts extends
    BaseUITestingPlaygroundAsserts {

  private final TextInputPage.Elements textInputPageElements;

  /**
   * Constructs a TextInputPageAsserts instance with the provided TextInputPage.
   */
  public TextInputPageAsserts() {
    this.textInputPageElements = new TextInputPage().elements();
    LOGGER.info("Validating text input page");
  }

  /**
   * Verifies that the text of the updating button matches the expected text.
   *
   * @param expectedText The expected text of the updating button.
   * @return The current TextInputPageAsserts instance.
   */
  @And("Verify updating button {string} text on text input page")
  public TextInputPageAsserts isUpdatingButtonTextValid(String expectedText) {
    verifyElementText(textInputPageElements.updatingButton, expectedText);
    return this;
  }
}
