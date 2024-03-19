package org.dmukhin.webui.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import org.dmukhin.webui.cucumber.testcases.webdriver.WebDriverManager;
import org.example.environment.EnvironmentProvider;

public class BaseStepDefinition {

  private final EnvironmentProvider environmentProvider = EnvironmentProvider.provideEnvironment();

  @Given("I'm on {string} homepage")
  public void imOnUITestingPlayground(String settingName) {
    String webUrl = environmentProvider.getSettings(settingName).getWebUrl();
    WebDriverManager.createWebDriverSession(webUrl, true);
  }
}
