package org.dmukhin.webapi.testng.placeholder;

import static org.dmukhin.microservices.placeholder.PlaceholderApi.placeholderApi;
import static org.dmukhin.webapi.testng.verifications.placeholder.PlaceholderAsserts.placeholderAsserts;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import java.util.Arrays;
import java.util.List;
import org.dmukhin.microservices.placeholder.models.user.UserDto;
import org.dmukhin.webapi.testng.testcases.general.placeholder.BasePlaceholderTest;
import org.dmukhin.webapi.testng.testcases.groups.TestGroups;
import org.dmukhin.webapi.testng.testcases.testdata.placeholder.PlaceholderTestData;
import org.testng.annotations.Test;

/**
 * Test class for performing CRUD operations on users in the JSONPlaceholder API. Extends
 * BaseTestNgTests, indicating it uses TestNG as the testing framework.
 */
@Epic("Placeholder Service")
@Feature("User Endpoint")
public class PlaceholderUserCrudTest extends BasePlaceholderTest {

  /**
   * Test for verifying the ability to create a new user. This test creates a user using the
   * JSONPlaceholder API and verifies that the created user matches the data sent in the request.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("POST: Verify ability to create new user")
  public void testCreatingNewUser() {
    UserDto userDto = PlaceholderTestData.userTestData().randomUser();
    UserDto createdUserResponse = placeholderApi().user().create(userDto);

    placeholderAsserts().userAsserts(createdUserResponse)
        .isResponseValid()
        .isResponseEqualTo(userDto, "id");
  }

  /**
   * Test for verifying the ability to update an existing user. This test updates a user and
   * verifies that the updated user matches the new data.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("PUT: Verify ability to update user")
  public void testUpdateUser() {
    UserDto userDto = PlaceholderTestData.userTestData().randomUser();
    UserDto updateResponse = placeholderApi().user().update(9, userDto);

    placeholderAsserts().userAsserts(updateResponse)
        .isResponseValid()
        .isResponseEqualTo(userDto, "id");
  }

  /**
   * Test for verifying the ability to retrieve a specific user by ID. This test retrieves a user
   * and verifies certain fields of the retrieved user data.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("GET: Verify ability to retrieve user by Id")
  public void testRetrieveUserById() {
    String userId = "10";
    UserDto expectedUser = new UserDto()
        .setName("Clementina DuBuque")
        .setUsername("Moriah.Stanton");
    UserDto user = placeholderApi().user().getById(userId);

    placeholderAsserts().userAsserts(user)
        .isResponseValid()
        .isResponseFieldsEqualTo(expectedUser, "name", "username");
  }

  /**
   * Test for verifying the ability to retrieve a list of all users. This test fetches all users and
   * performs assertions on the size of the list and certain user names.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("GET: Verify ability to retrieve users list")
  public void testRetrieveAllUsers() {
    List<UserDto> users = placeholderApi().user().getAll();
    List<String> usernames = Arrays.asList("Clementina DuBuque", "Glenna Reichert",
        "Nicholas Runolfsdottir V");

    placeholderAsserts().userListAsserts(users)
        .isResponseValid()
        .isUserListHasSize(10)
        .verifyUserNamesInList(usernames);
  }
}
