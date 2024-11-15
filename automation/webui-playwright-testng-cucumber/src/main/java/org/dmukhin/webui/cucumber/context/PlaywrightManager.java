package org.dmukhin.webui.cucumber.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightManager {

  private static final ThreadLocal<Playwright> playwrightThreadLocal = ThreadLocal.withInitial(
      Playwright::create);
  private static final ThreadLocal<Browser> browserThreadLocal = ThreadLocal.withInitial(() ->
      playwrightThreadLocal.get().chromium()
          .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false))
  );
  private static final ThreadLocal<Page> pageThreadLocal = ThreadLocal.withInitial(
      () -> browserThreadLocal.get().newPage());

  // Private constructor to prevent instantiation
  private PlaywrightManager() {
  }

  // Method to get the Page object for the current thread
  public static Page getPage() {
    return pageThreadLocal.get();
  }

  // Method to close resources for the current thread
  public static void close() {
    Page page = pageThreadLocal.get();
    if (page != null) {
      page.close();
      pageThreadLocal.remove();
    }
    Browser browser = browserThreadLocal.get();
    if (browser != null) {
      browser.close();
      browserThreadLocal.remove();
    }
    Playwright playwright = playwrightThreadLocal.get();
    if (playwright != null) {
      playwright.close();
      playwrightThreadLocal.remove();
    }
  }
}

