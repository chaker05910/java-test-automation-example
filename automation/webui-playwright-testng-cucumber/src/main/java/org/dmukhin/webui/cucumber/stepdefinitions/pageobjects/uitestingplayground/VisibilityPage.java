package org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;

/**
 * Page object representing the Visibility Page in the UI Testing Playground section. Provides
 * methods for interacting with elements on the Visibility Page.
 */
public class VisibilityPage extends BaseUITestingPlaygroundPage {

  public final Locator hideButton = page.locator("#hideButton");
  public final Locator removedButton = page.locator("#removedButton");

  /**
   * Clicks the 'Hide Button' on the Visibility Page.
   *
   * @return The current instance of VisibilityPage for method chaining.
   */
  @And("Click hide button on visibility page")
  public VisibilityPage clickHideButton() {
    hideButton.click();
    return this;
  }
}
