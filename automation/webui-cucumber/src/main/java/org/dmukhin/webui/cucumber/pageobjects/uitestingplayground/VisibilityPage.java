package org.dmukhin.webui.cucumber.pageobjects.uitestingplayground;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import org.dmukhin.webui.cucumber.pageobjects.IElements;
import org.openqa.selenium.By;

/**
 * Page object representing the Visibility Page in the UI Testing Playground section. Provides
 * methods for interacting with elements on the Visibility Page.
 */
public class VisibilityPage extends BaseUITestingPlaygroundPage {

  private final Elements elements = new Elements();

  /**
   * Clicks the 'Hide Button' on the Visibility Page.
   *
   * @return The current instance of VisibilityPage for method chaining.
   */
  @And("Click hide button on visibility page")
  public VisibilityPage clickHideButton() {
    elements.hideButton.click();
    return this;
  }

  /**
   * Retrieves the elements on the Visibility Page.
   *
   * @return An instance of Elements containing elements on the Visibility Page.
   */
  @Override
  public Elements elements() {
    return elements;
  }

  /**
   * Inner class representing elements on the Visibility Page.
   */
  public static class Elements implements IElements {

    public final SelenideElement hideButton = $(By.id("hideButton"));
    public final SelenideElement removedButton = $(By.id("removedButton"));

    private Elements() {
    }
  }
}
