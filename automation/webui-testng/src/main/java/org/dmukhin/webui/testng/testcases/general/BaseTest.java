package org.dmukhin.webui.testng.testcases.general;

import org.dmukhin.general.config.environment.EnvironmentProvider;
import org.dmukhin.webui.testng.testcases.webdriver.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
        WebDriverManager.setupAllureSelenideListener();
        WebDriverManager.setupLog4JListener();
    }

    /**
     * Navigates to the homepage before each test method.
     */
    @BeforeClass
    public void goToHomepage() {
        WebDriverManager.createWebDriverSession(getWebUrl(), true);
    }

    /**
     * Cleans up WebDriver session after each test method.
     */
    @AfterClass
    public void cleanUp() {
        WebDriverManager.closeWebDriver();
    }

    /**
     * Abstract method to retrieve the web URL for the test environment.
     *
     * @return The web URL for the test environment.
     */
    protected abstract String getWebUrl();
}
