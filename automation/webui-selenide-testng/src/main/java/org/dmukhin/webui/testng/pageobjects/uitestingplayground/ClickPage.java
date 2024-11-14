package org.dmukhin.webui.testng.pageobjects.uitestingplayground;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.dmukhin.webui.testng.pageobjects.general.IElements;
import org.openqa.selenium.By;

/**
 * Page object representing the Click Page in the UI Testing Playground section. Provides methods
 * for interacting with elements on the Click Page.
 */
public class ClickPage extends BaseUITestingPlaygroundPage {

    private final Elements elements = new Elements();

    /**
     * Clicks the 'Bad Button' on the Click Page.
     *
     * @return The current instance of ClickPage for method chaining.
     */
    @Step("Click the 'Bad Button' on Click Page")
    public ClickPage clickBadButton() {
        elements.badButton.click();
        return this;
    }

    /**
     * Retrieves the elements on the Click Page.
     *
     * @return An instance of Elements containing elements on the Click Page.
     */
    @Override
    public Elements elements() {
        return elements;
    }

    /**
     * Inner class representing elements on the Click Page.
     */
    public static class Elements implements IElements {

        /**
         * SelenideElement representing the 'Bad Button' on the Click Page.
         */
        public final SelenideElement badButton = $(By.id("badButton"));

        private Elements() {
        }
    }
}
