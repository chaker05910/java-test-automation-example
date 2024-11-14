package org.dmukhin.webui.cucumber.testcases.webdriver;

import io.qameta.allure.Step;
import org.dmukhin.general.config.maven.MavenProperties;
import org.dmukhin.webui.cucumber.context.PlaywrightManager;

/**
 * Class managing WebDriver configurations and session operations.
 */
public class WebDriverManager {

  private WebDriverManager() {
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
    PlaywrightManager.getPage().navigate(url);
    if (isMaximize) {
      PlaywrightManager.getPage().setViewportSize(1920, 1080);
    }
  }

  /**
   * Reset the current WebDriver session.
   */
  @Step("Close WebDriver Session")
  public static void closeWebDriver() {
    PlaywrightManager.close();
  }


  private static void setDriverPathIfLinux() {
    boolean isLinux = System.getProperty("os.name").toLowerCase().startsWith("linux");

    if (isLinux) {
      System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");
    } else {
      System.setProperty("webdriver.edge.driver", "C:\\edgedriver_win64\\msedgedriver.exe");
    }
  }
}
