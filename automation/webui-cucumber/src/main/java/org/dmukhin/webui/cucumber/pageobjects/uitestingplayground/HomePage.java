package org.dmukhin.webui.cucumber.pageobjects.uitestingplayground;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;
import org.dmukhin.webui.cucumber.pageobjects.IElements;
import org.openqa.selenium.By;

/**
 * Page object representing the Home Page in the UI Testing Playground section. Provides methods for
 * interacting with elements on the Home Page.
 */
public class HomePage extends BaseUITestingPlaygroundPage {

  private final Elements elements = new Elements();

  /**
   * Clicks the 'Click' button on the Home Page.
   *
   * @return A new instance of ClickPage.
   */
  @When("Click the click button on home page")
  public ClickPage clickClickButton() {
    elements().clickButton.click();
    return new ClickPage();
  }

  /**
   * Clicks the 'Text Input' button on the Home Page.
   *
   * @return A new instance of TextInputPage.
   */
  @When("Click the text input button on home page")
  public TextInputPage clickTextInputButton() {
    elements().textInputButton.click();
    return new TextInputPage();
  }

  /**
   * Clicks the 'Visibility' button on the Home Page.
   *
   * @return A new instance of VisibilityPage.
   */
  @When("Click the visibility button on home page")
  public VisibilityPage clickVisibilityButton() {
    elements().visibilityButton.click();
    return new VisibilityPage();
  }

  /**
   * Retrieves the elements on the Home Page.
   *
   * @return An instance of Elements containing elements on the Home Page.
   */
  @Override
  public Elements elements() {
    return elements;
  }

  /**
   * Inner class representing elements on the Home Page.
   */
  public static class Elements implements IElements {

    /**
     * SelenideElement representing the 'Click' button on the Home Page.
     */
    public final SelenideElement clickButton = $(By.linkText("Click"));
    /**
     * SelenideElement representing the 'Text Input' button on the Home Page.
     */
    public final SelenideElement textInputButton = $(By.linkText("Text Input"));
    /**
     * SelenideElement representing the 'Visibility' button on the Home Page.
     */
    public final SelenideElement visibilityButton = $(By.linkText("Visibility"));

    private Elements() {
    }
  }
}
