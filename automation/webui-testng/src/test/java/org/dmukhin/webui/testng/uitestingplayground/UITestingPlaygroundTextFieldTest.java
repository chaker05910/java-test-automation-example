package org.dmukhin.webui.testng.uitestingplayground;

import static org.dmukhin.webui.testng.verifications.uitestingplayground.UITestingPlaygroundAsserts.uiTestingPlaygroundVerifications;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.dmukhin.webui.testng.pageobjects.uitestingplayground.TextInputPage;
import org.dmukhin.webui.testng.testcases.enums.TestGroups;
import org.dmukhin.webui.testng.testcases.general.uitestingplayground.BaseUITestingPlaygroundTest;
import org.testng.annotations.Test;

/**
 * Test class for verifying text input functionality on UITestingPlayground.
 */
@Epic("UITestingPlayground")
@Feature("Text Filed")
public class UITestingPlaygroundTextFieldTest extends BaseUITestingPlaygroundTest {

  /**
   * Test case to verify text input page button editing functionality.
   */
  @Test(groups = {TestGroups.REG, TestGroups.UI, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("Verify text input page button editing")
  public void testDataEntry() {
    TextInputPage textInputPage = homePage.clickTextInputButton()
        .enterNewButtonNameText("New Name")
        .clickUpdatingButton();
    uiTestingPlaygroundVerifications().textInputPageAsserts(textInputPage)
        .isUpdatingButtonTextValid("New Name");
  }
}
