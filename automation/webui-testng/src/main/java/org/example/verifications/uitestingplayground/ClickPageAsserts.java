package org.example.verifications.uitestingplayground;

import io.qameta.allure.Step;
import org.example.pageobjects.uitestingplayground.ClickPage;
import org.example.verifications.BaseAsserts;

/**
 * Verification assertions class for ClickPage in UITestingPlayground.
 */
public class ClickPageAsserts extends BaseAsserts {

    private final ClickPage.Elements clickPageElements;

    /**
     * Constructs a ClickPageAsserts instance with the provided ClickPage.
     *
     * @param clickPage The ClickPage instance to verify.
     */
    ClickPageAsserts(ClickPage clickPage) {
        this.clickPageElements = clickPage.elements();
        LOGGER.info("Validating click page");
    }

    /**
     * Verifies that the class name of the bad button matches the expected class name.
     *
     * @param expectedClassName The expected class name of the bad button.
     * @return The current ClickPageAsserts instance.
     */
    @Step("Verify Bad Button Class Name on Click Page")
    public ClickPageAsserts isBadButtonClassNameValid(String expectedClassName) {
        verifyElementClassName(clickPageElements.badButton, expectedClassName);
        return this;
    }
}
