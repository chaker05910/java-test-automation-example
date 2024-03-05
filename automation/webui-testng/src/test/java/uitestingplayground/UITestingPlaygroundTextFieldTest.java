package uitestingplayground;

import static org.example.verifications.uitestingplayground.UITestingPlaygroundAsserts.uiTestingPlaygroundVerifications;

import io.qameta.allure.*;
import org.example.pageobjects.uitestingplayground.TextInputPage;
import org.example.testcases.enums.TestGroups;
import org.example.testcases.general.uitestingplayground.BaseUITestingPlaygroundTest;
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
