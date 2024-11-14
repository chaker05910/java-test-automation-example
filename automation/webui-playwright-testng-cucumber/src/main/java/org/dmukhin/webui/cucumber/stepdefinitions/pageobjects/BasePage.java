package org.dmukhin.webui.cucumber.stepdefinitions.pageobjects;

import com.microsoft.playwright.Page;
import org.dmukhin.webui.cucumber.context.PlaywrightManager;

/**
 * Abstract base class representing a generic page in the application. Provides an abstract method
 * to retrieve elements on the page.
 */
public abstract class BasePage {

  protected Page page = PlaywrightManager.getPage();
}
