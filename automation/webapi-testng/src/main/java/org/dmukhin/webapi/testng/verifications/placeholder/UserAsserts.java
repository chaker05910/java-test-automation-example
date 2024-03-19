package org.dmukhin.webapi.testng.verifications.placeholder;

import io.qameta.allure.Step;
import org.dmukhin.microservices.placeholder.models.user.UserDto;
import org.dmukhin.webapi.testng.verifications.BaseAsserts;

/**
 * Contains assertion methods for verifying properties of UserDto objects.
 */
public class UserAsserts extends BaseAsserts {

  private final UserDto userDto;

  /**
   * Constructs a UserAsserts object with the provided UserDto object.
   *
   * @param userDto The UserDto object to be verified.
   */
  UserAsserts(UserDto userDto) {
    this.userDto = userDto;
    LOGGER.info("Validating user endpoint");
  }

  /**
   * Verifies that the response containing a UserDto object is valid.
   *
   * @return The current instance of UserAsserts for method chaining.
   */
  @Step("Verify that the user response is valid")
  public UserAsserts isResponseValid() {
    hasNoNullFieldsAndUnknownProperties(userDto);
    return this;
  }

  /**
   * Verifies if the response User DTO is equal to the expected DTO, ignoring specified fields. This
   * is used for assertions in tests where only certain fields are relevant for comparison.
   *
   * @param expectedDto    The expected User DTO object for comparison.
   * @param ignoringFields Array of field names to be ignored during the comparison.
   * @return UserAsserts    Returns this object to enable method chaining in assertions.
   */
  @Step("Verify that the response User DTO is equal to the expected DTO, ignoring specified fields")
  public UserAsserts isResponseEqualTo(UserDto expectedDto, String... ignoringFields) {
    verifyDTOEquality(userDto, expectedDto, UserDto.class, ignoringFields);
    return this;
  }

  /**
   * Verifies if the response User DTO's specific fields are equal to those of the expected DTO.
   * This is useful for cases where the comparison should be limited to specified fields only.
   *
   * @param expectedDto     The expected User DTO object for comparison.
   * @param comparingFields Array of field names to be specifically compared during the comparison.
   * @return UserAsserts    Returns this object to enable method chaining in assertions.
   */
  @Step("Verify that specific fields of the response User DTO are equal to those of the expected DTO")
  public UserAsserts isResponseFieldsEqualTo(UserDto expectedDto, String... comparingFields) {
    verifyDTOEqualitySpecialFields(userDto, expectedDto, UserDto.class, comparingFields);
    return this;
  }

}
