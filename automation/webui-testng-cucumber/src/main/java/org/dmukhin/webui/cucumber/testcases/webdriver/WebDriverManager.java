package org.dmukhin.webui.cucumber.testcases.webdriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import java.util.Optional;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmukhin.general.config.maven.MavenProperties;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Class managing WebDriver configurations and session operations.
 */
public class WebDriverManager {

  private static final Logger LOGGER = LogManager.getLogger(WebDriverManager.class);

  private WebDriverManager() {
  }

  /**
   * Sets up Allure listener for capturing screenshots, page sources, and browser logs.
   */
  @Step("Setup Allure Listener")
  public static void setupAllureSelenideListener() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
        .screenshots(true)
        .savePageSource(true)
        .includeSelenideSteps(true)
        .enableLogs(LogType.BROWSER, Level.ALL));
  }

  /**
   * Opens a new WebDriver session with the specified URL and optionally maximizes the browser
   * window.
   *
   * @param url        The URL to open in the browser.
   * @param isMaximize A boolean flag indicating whether to maximize the browser window.
   */
  @Step("Create WebDriver Session")
  public static void createWebDriverSession(String url, boolean isMaximize) {
    if (Boolean.TRUE.equals(MavenProperties.getRemotePipeline())) {
      setDriverPathIfLinux();
    }
    if (Boolean.TRUE.equals(MavenProperties.getSelenideDebug())) {
      configureEdgeDriver();
    }
    Selenide.open(url);
    if (isMaximize) {
      WebDriverRunner.getWebDriver().manage().window().maximize();
    }
  }

  /**
   * Reset the current WebDriver session.
   */
  @Step("Close WebDriver Session")
  public static void closeWebDriver() {
    Selenide.closeWebDriver();
  }


  private static void setDriverPathIfLinux() {
    boolean isLinux = System.getProperty("os.name").toLowerCase().startsWith("linux");

    if (isLinux) {
      System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");
    } else {
      System.setProperty("webdriver.edge.driver", "C:\\edgedriver_win64\\msedgedriver.exe");
    }
  }

  private static void configureEdgeDriver() {
    EdgeOptions options = new EdgeOptions();
    if (Configuration.headless) {
      options.addArguments("--headless");
      options.addArguments("--disable-extensions");
      options.addArguments("--disable-gpu");
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");
      options.setAcceptInsecureCerts(true);
    }
    options.setCapability("ms:edgeOptions",
        "--remote-debugging-port=9222"); // Enable remote debugging

    EdgeDriver driver = new EdgeDriver(options);
    withDebugNetwork(driver);
    WebDriverRunner.setWebDriver(driver);
  }

  private static void withDebugNetwork(EdgeDriver driver) {
    // Initialize DevTools session
    DevTools devTools = driver.getDevTools();
    devTools.createSession();

    // Enable network logging
    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

    // Log network requests
    devTools.addListener(Network.requestWillBeSent(), request -> {
      String requestUrl = request.getRequest().getUrl();
      if (requestUrl.contains("favicon.ico")) {
        LOGGER.info("Blocking request: {}", requestUrl);
        devTools.send(Network.setBlockedURLs(java.util.List.of("*.ico")));
      }
    });

    // Log network responses
    devTools.addListener(Network.responseReceived(), response -> {
      Response res = response.getResponse();
      LOGGER.info("Response URL: {}", res.getUrl());
      LOGGER.info("Response status: {}", res.getStatus());
    });
  }
}
