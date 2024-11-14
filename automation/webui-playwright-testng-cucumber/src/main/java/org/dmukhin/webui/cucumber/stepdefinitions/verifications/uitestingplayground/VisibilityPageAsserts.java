package org.dmukhin.webui.cucumber.stepdefinitions.verifications.uitestingplayground;

import io.cucumber.java.en.And;
import org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground.VisibilityPage;

/**
 * Verification assertions class for VisibilityPage in UITestingPlayground.
 */
public class VisibilityPageAsserts extends
    BaseUITestingPlaygroundAsserts {

  private final VisibilityPage visibilityPage;

  /**
   * Constructs a VisibilityPageAsserts instance with the provided VisibilityPage.
   */
  public VisibilityPageAsserts() {
    this.visibilityPage = new VisibilityPage();
    LOGGER.info("Validating visibility page");
  }

  /**
   * Verifies that the remove button is not visible.
   *
   * @return The current VisibilityPageAsserts instance.
   */
  @And("Verify remove button not visible on visibility page")
  public VisibilityPageAsserts isRemoveButtonNotVisible() {
    verifyElementNotVisible(visibilityPage.removedButton);
    return this;
  }
}
