package org.dmukhin.webui.testng.listeners;

import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Custom implementation of Selenide LogEventListener. Logs the start and completion of Selenide
 * actions.
 */
public class CustomLogEventListener implements LogEventListener {

  private static final Logger LOGGER = LogManager.getLogger(CustomLogEventListener.class);

  /**
   * Logs the start of a Selenide action.
   *
   * @param selenideLog The log event representing the Selenide action.
   */
  @Override
  public void beforeEvent(LogEvent selenideLog) {
    LOGGER.info(String.format("Starting action: %s", selenideLog));
  }

  /**
   * Logs the completion of a Selenide action.
   *
   * @param selenideLog The log event representing the completed Selenide action.
   */
  @Override
  public void afterEvent(LogEvent selenideLog) {
    LOGGER.info(String.format("Completed action: %s", selenideLog));
  }
}
