package org.dmukhin.webui.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebugStepDefinitions {

  private static final Logger LOGGER = LogManager.getLogger(DebugStepDefinitions.class);

  @Given("Debug")
  public void debug() {
    LOGGER.debug("Put your debug point here!");
  }
}
