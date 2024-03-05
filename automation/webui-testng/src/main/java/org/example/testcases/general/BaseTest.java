package org.example.testcases.general;

import org.example.environment.EnvironmentProvider;
import org.example.testcases.webdriver.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Abstract base test class providing setup and teardown methods for test cases.
 */
public abstract class BaseTest {

    protected EnvironmentProvider environmentProvider = EnvironmentProvider.provideEnvironment();

    /**
     * Sets up WebDriver configurations before running the test class.
     */
    @BeforeClass
    public void setupDriverConfigurations() {
        WebDriverManager.setupAllureListener();
        WebDriverManager.setupLog4JListener();
    }

    /**
     * Navigates to the homepage before each test method.
     */
    @BeforeMethod
    public void goToHomepage() {
        WebDriverManager.createWebdriverSession(getWebUrl(), true);
    }

    /**
     * Cleans up WebDriver session after each test method.
     */
    @AfterMethod
    public void cleanUp() {
        WebDriverManager.resetWebdriverSession();
    }

    /**
     * Abstract method to retrieve the web URL for the test environment.
     *
     * @return The web URL for the test environment.
     */
    protected abstract String getWebUrl();
}
