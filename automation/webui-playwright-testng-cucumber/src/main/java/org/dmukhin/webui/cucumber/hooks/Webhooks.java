package org.dmukhin.webui.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.dmukhin.webui.cucumber.testcases.webdriver.WebDriverManager;

/**
 * Class managing WebDriver configurations and session operations.
 */
public class Webhooks {

  /**
   * Close WebDriver session after all tests.
   */
  @AfterAll
  public static void globalTearDown() {
    WebDriverManager.closeWebDriver();
  }

  /**
   * Cleans up WebDriver session after each test.
   */
  @After
  public void tearDown(Scenario scenario) {
    WebDriverManager.closeWebDriver();
  }
}
