package org.dmukhin.webapi.testng.verifications.placeholder;

import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import org.dmukhin.webapi.testng.verifications.BaseAsserts;
import org.example.service.placeholder.models.user.UserDto;

/**
 * Contains assertion methods for verifying properties of lists of UserDto objects.
 */
public class UserListAsserts extends BaseAsserts {

  private final List<UserDto> userDtoList;

  /**
   * Constructs a UserListAsserts object with the provided list of UserDto objects.
   *
   * @param userDtoList The list of UserDto objects to be verified.
   */
  UserListAsserts(List<UserDto> userDtoList) {
    this.userDtoList = userDtoList;
    LOGGER.info("Validating user endpoint");
  }

  /**
   * Verifies that the response containing a list of UserDto objects is valid.
   *
   * @return The current instance of UserListAsserts for method chaining.
   */
  @Step("Verify that the user list response is valid")
  public UserListAsserts isResponseValid() {
    for (UserDto userDto : userDtoList) {
      hasNoNullFieldsAndUnknownProperties(userDto);
    }
    return this;
  }

  /**
   * Verifies that the list of UserDto objects contains expected user names.
   *
   * @param expectedUserNames The list of expected user names.
   * @return The current instance of UserListAsserts for method chaining.
   */
  @Step("Verify that the user list contains expected names")
  public UserListAsserts verifyUserNamesInList(List<String> expectedUserNames) {
    List<String> usernames = userDtoList.stream().map(UserDto::getName).toList();
    verifyListOfStringsContains(expectedUserNames, usernames, "User names");
    return this;
  }

  /**
   * Verifies that the list of UserDto objects has the specified size.
   *
   * @param size The expected size of the user list.
   * @return The current instance of UserListAsserts for method chaining.
   */
  @Step("Verify that the user list has a specified size")
  public UserListAsserts isUserListHasSize(int size) {
    verifyListHasSize(Arrays.asList(userDtoList.toArray()), size, "Users List");
    return this;
  }
}
