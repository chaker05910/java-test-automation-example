package org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;

/**
 * Page object representing the Click Page in the UI Testing Playground section. Provides methods
 * for interacting with elements on the Click Page.
 */
public class ClickPage extends BaseUITestingPlaygroundPage {

  public final Locator badButton = page.locator("#badButton");

  /**
   * Clicks the 'Bad Button' on the Click Page.
   */
  @And("Click the bad button on click page")
  public void clickBadButton() {
    badButton.click();
  }
}
