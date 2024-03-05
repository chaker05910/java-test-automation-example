package org.example.verifications.uitestingplayground;

import org.example.pageobjects.uitestingplayground.ClickPage;
import org.example.pageobjects.uitestingplayground.TextInputPage;
import org.example.pageobjects.uitestingplayground.VisibilityPage;

/**
 * Factory class for creating assertion objects related to UITestingPlayground pages.
 */
public class UITestingPlaygroundAsserts {

    private UITestingPlaygroundAsserts() {
        // Private constructor to prevent instantiation from outside the class
    }

    /**
     * Creates a new instance of UITestingPlaygroundAsserts.
     *
     * @return A new UITestingPlaygroundAsserts instance.
     */
    public static UITestingPlaygroundAsserts uiTestingPlaygroundVerifications() {
        return new UITestingPlaygroundAsserts();
    }

    /**
     * Creates a ClickPageAsserts instance for verifying assertions related to ClickPage.
     *
     * @param clickPage The ClickPage object to be verified.
     * @return A ClickPageAsserts instance.
     */
    public ClickPageAsserts clickPageAsserts(ClickPage clickPage) {
        return new ClickPageAsserts(clickPage);
    }

    /**
     * Creates a TextInputPageAsserts instance for verifying assertions related to TextInputPage.
     *
     * @param textInputPage The TextInputPage object to be verified.
     * @return A TextInputPageAsserts instance.
     */
    public TextInputPageAsserts textInputPageAsserts(TextInputPage textInputPage) {
        return new TextInputPageAsserts(textInputPage);
    }

    /**
     * Creates a VisibilityPageAsserts instance for verifying assertions related to VisibilityPage.
     *
     * @param visibilityPage The VisibilityPage object to be verified.
     * @return A VisibilityPageAsserts instance.
     */
    public VisibilityPageAsserts visibilityPageAsserts(VisibilityPage visibilityPage) {
        return new VisibilityPageAsserts(visibilityPage);
    }
}
