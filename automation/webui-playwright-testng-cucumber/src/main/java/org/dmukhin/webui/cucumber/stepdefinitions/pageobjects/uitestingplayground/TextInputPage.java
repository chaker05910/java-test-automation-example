package org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;

/**
 * Page object representing the Text Input Page in the UI Testing Playground section. Provides
 * methods for interacting with elements on the Text Input Page.
 */
public class TextInputPage extends BaseUITestingPlaygroundPage {

  public final Locator newButtonNameInput = page.locator("#newButtonName");
  public final Locator updatingButton = page.locator("#updatingButton");

  /**
   * Enters text into the 'New Button Name' input field on the Text Input Page.
   *
   * @param text The text to enter into the input field.
   */
  @And("Enter text {string} into new button name input field on text input page")
  public void enterNewButtonNameText(String text) {
    newButtonNameInput.fill(text);
  }

  /**
   * Clicks the 'Updating Button' on the Text Input Page.
   */
  @And("Click updating button on text input page")
  public void clickUpdatingButton() {
    updatingButton.click();
  }
}
