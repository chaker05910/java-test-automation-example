package org.dmukhin.webui.cucumber.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightManager {

  private static Playwright playwright;
  private static Browser browser;
  private static Page page;

  // Private constructor to prevent instantiation
  private PlaywrightManager() {
  }

  // Method to initialize Playwright, Browser, and Page as Singleton
  public static Page getPage() {
    if (page == null) {
      playwright = Playwright.create();
      browser = playwright.chromium()
          .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
      page = browser.newPage();
    }
    return page;
  }

  // Method to close resources
  public static void close() {
    if (page != null) {
      page.close();
      page = null;
    }
    if (browser != null) {
      browser.close();
      browser = null;
    }
    if (playwright != null) {
      playwright.close();
      playwright = null;
    }
  }
}
