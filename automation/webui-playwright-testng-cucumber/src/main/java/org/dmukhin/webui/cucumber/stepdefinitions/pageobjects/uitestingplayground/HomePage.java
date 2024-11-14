package org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.When;

/**
 * Page object representing the Home Page in the UI Testing Playground section. Provides methods for
 * interacting with elements on the Home Page.
 */
public class HomePage extends BaseUITestingPlaygroundPage {

  public final Locator clickButton = page.locator("xpath=//a[@href='/click']");
  public final Locator textInputButton = page.locator("xpath=//a[@href='/textinput']");
  public final Locator visibilityButton = page.locator("xpath=//a[@href='/visibility']");

  /**
   * Clicks the 'Click' button on the Home Page.
   */
  @When("Click the click button on home page")
  public void clickClickButton() {
    clickButton.click();
  }

  /**
   * Clicks the 'Text Input' button on the Home Page.
   */
  @When("Click the text input button on home page")
  public void clickTextInputButton() {
    textInputButton.click();
  }

  /**
   * Clicks the 'Visibility' button on the Home Page.
   */
  @When("Click the visibility button on home page")
  public void clickVisibilityButton() {
    visibilityButton.click();
  }
}
