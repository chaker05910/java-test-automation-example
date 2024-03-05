package uitestingplayground;

import static org.example.verifications.uitestingplayground.UITestingPlaygroundAsserts.uiTestingPlaygroundVerifications;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.example.pageobjects.uitestingplayground.ClickPage;
import org.example.testcases.enums.TestGroups;
import org.example.testcases.general.uitestingplayground.BaseUITestingPlaygroundTest;
import org.testng.annotations.Test;

/**
 * Test class for verifying click functionality on UITestingPlayground.
 */
@Epic("UITestingPlayground")
@Feature("Click")
public class UITestingPlaygroundClickTest extends BaseUITestingPlaygroundTest {

    /**
     * Test case to verify the behavior of the bad button on the click page.
     */
    @Test(groups = {TestGroups.REG, TestGroups.UI, TestGroups.COMP})
    @TmsLink("TMS-123")
    @Story("Verify click page bad button class")
    public void testClick() {
        ClickPage clickPage = homePage.clickClickButton()
            .clickBadButton();
        uiTestingPlaygroundVerifications()
            .clickPageAsserts(clickPage)
            .isBadButtonClassNameValid("btn btn-success");
    }
}
