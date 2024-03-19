package org.dmukhin.webui.testng.testcases.webdriver;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import java.util.logging.Level;
import org.dmukhin.webui.testng.listeners.CustomLogEventListener;

/**
 * Class managing WebDriver configurations and session operations.
 */
public class WebDriverManager {

    private WebDriverManager() {
    }

    /**
     * Sets up Allure listener for capturing screenshots, page sources, and browser logs.
     */
    @Step("Setup Allure Listener")
    public static void setupAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
    }

    /**
     * Sets up Log4J listener for logging browser events.
     */
    @Step("Setup Log4J Listener")
    public static void setupLog4JListener() {
        SelenideLogger.addListener("Log4J", new CustomLogEventListener());
    }

    /**
     * Opens a new WebDriver session with the specified URL and optionally maximizes the browser
     * window.
     *
     * @param url        The URL to open in the browser.
     * @param isMaximize A boolean flag indicating whether to maximize the browser window.
     */
    @Step("Create WebDriver Session")
    public static void createWebdriverSession(String url, boolean isMaximize) {
        Selenide.open(url);
        if (isMaximize) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }

    /**
     * Closes the current WebDriver session.
     */
    @Step("Close WebDriver Session")
    public static void closeWebdriverSession() {
        Selenide.closeWebDriver();
    }

    /**
     * Resets the current WebDriver session by clearing cookies, local storage, and session storage.
     */
    @Step("Reset WebDriver Session")
    public static void resetWebdriverSession() {
        Selenide.clearBrowserCookies();
        Selenide.executeJavaScript("window.localStorage.clear();");
        Selenide.executeJavaScript("window.sessionStorage.clear();");
    }
}
