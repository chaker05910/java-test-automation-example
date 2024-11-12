package org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.uitestingplayground;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import org.dmukhin.webui.cucumber.stepdefinitions.pageobjects.IElements;
import org.openqa.selenium.By;

/**
 * Page object representing the Text Input Page in the UI Testing Playground section. Provides
 * methods for interacting with elements on the Text Input Page.
 */
public class TextInputPage extends BaseUITestingPlaygroundPage {

  private final Elements elements = new Elements();

  /**
   * Enters text into the 'New Button Name' input field on the Text Input Page.
   *
   * @param text The text to enter into the input field.
   * @return The current instance of TextInputPage for method chaining.
   */
  @And("Enter text {string} into new button name input field on text input page")
  public TextInputPage enterNewButtonNameText(String text) {
    elements.newButtonName.setValue(text);
    return this;
  }

  /**
   * Clicks the 'Updating Button' on the Text Input Page.
   *
   * @return The current instance of TextInputPage for method chaining.
   */
  @And("Click updating button on text input page")
  public TextInputPage clickUpdatingButton() {
    elements.updatingButton.click();
    return this;
  }

  /**
   * Retrieves the elements on the Text Input Page.
   *
   * @return An instance of Elements containing elements on the Text Input Page.
   */
  @Override
  public Elements elements() {
    return elements;
  }

  /**
   * Inner class representing elements on the Text Input Page.
   */
  public static class Elements implements IElements {

    public final SelenideElement newButtonName = $(By.id("newButtonName"));
    public final SelenideElement updatingButton = $(By.id("updatingButton"));

    private Elements() {
    }
  }
}
