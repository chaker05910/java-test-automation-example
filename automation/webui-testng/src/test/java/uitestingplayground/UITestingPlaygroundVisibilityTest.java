package uitestingplayground;

import static org.example.verifications.uitestingplayground.UITestingPlaygroundAsserts.uiTestingPlaygroundVerifications;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.example.pageobjects.uitestingplayground.VisibilityPage;
import org.example.testcases.enums.TestGroups;
import org.example.testcases.general.uitestingplayground.BaseUITestingPlaygroundTest;
import org.testng.annotations.Test;

/**
 * Test class for verifying visibility of elements on UITestingPlayground pages.
 */
@Epic("UITestingPlayground")
@Feature("Visibility")
public class UITestingPlaygroundVisibilityTest extends BaseUITestingPlaygroundTest {

    /**
     * Test case to verify if the removed button is not visible after clicking the hide button.
     */
    @Test(groups = {TestGroups.REG, TestGroups.UI, TestGroups.COMP})
    @TmsLink("TMS-123")
    @Story("Verify removed button is not visible after clicking hide button")
    public void testRemoveButtonVisibility() {
        VisibilityPage visibilityPage = homePage.clickVisibilityButton()
            .clickHideButton();
        uiTestingPlaygroundVerifications().visibilityPageAsserts(visibilityPage)
            .isRemoveButtonNotVisible();
    }
}
