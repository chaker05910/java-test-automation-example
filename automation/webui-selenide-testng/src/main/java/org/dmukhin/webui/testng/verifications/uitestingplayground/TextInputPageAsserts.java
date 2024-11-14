package org.dmukhin.webui.testng.verifications.uitestingplayground;

import io.qameta.allure.Step;
import org.dmukhin.webui.testng.pageobjects.uitestingplayground.TextInputPage;
import org.dmukhin.webui.testng.pageobjects.uitestingplayground.TextInputPage.Elements;
import org.dmukhin.webui.testng.verifications.BaseAsserts;

/**
 * Verification assertions class for TextInputPage in UITestingPlayground.
 */
public class TextInputPageAsserts extends BaseAsserts {

  private final Elements textInputPageElements;

    /**
     * Constructs a TextInputPageAsserts instance with the provided TextInputPage.
     *
     * @param textInputPage The TextInputPage instance to verify.
     */
    TextInputPageAsserts(TextInputPage textInputPage) {
        this.textInputPageElements = textInputPage.elements();
        LOGGER.info("Validating text input page");
    }

    /**
     * Verifies that the text of the updating button matches the expected text.
     *
     * @param expectedText The expected text of the updating button.
     * @return The current TextInputPageAsserts instance.
     */
    @Step("Verify Updating Button Text on Text Input Page")
    public TextInputPageAsserts isUpdatingButtonTextValid(String expectedText) {
        verifyElementText(textInputPageElements.updatingButton, expectedText);
        return this;
    }
}
