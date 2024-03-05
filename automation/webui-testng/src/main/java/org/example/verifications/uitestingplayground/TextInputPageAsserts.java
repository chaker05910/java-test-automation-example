package org.example.verifications.uitestingplayground;

import io.qameta.allure.Step;
import org.example.pageobjects.uitestingplayground.TextInputPage;
import org.example.verifications.BaseAsserts;

/**
 * Verification assertions class for TextInputPage in UITestingPlayground.
 */
public class TextInputPageAsserts extends BaseAsserts {

    private final TextInputPage.Elements textInputPageElements;

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
