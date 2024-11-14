package org.dmukhin.webui.cucumber.stepdefinitions.verifications.uitestingplayground;

import io.cucumber.java.en.And;
import org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground.ClickPage;

/**
 * Verification assertions class for ClickPage in UITestingPlayground.
 */
public class ClickPageAsserts extends
    BaseUITestingPlaygroundAsserts {

  private final ClickPage clickPage;

  /**
   * Constructs a ClickPageAsserts instance with the provided ClickPage.
   */
  public ClickPageAsserts() {
    this.clickPage = new ClickPage();
    LOGGER.info("Validating click page");
  }

  /**
   * Verifies that the class name of the bad button matches the expected class name.
   *
   * @param expectedClassName The expected class name of the bad button.
   * @return The current ClickPageAsserts instance.
   */
  @And("Verify bad button {string} class name on click page")
  public ClickPageAsserts isBadButtonClassNameValid(String expectedClassName) {
    verifyElementClassName(clickPage.badButton, expectedClassName);
    return this;
  }
}
