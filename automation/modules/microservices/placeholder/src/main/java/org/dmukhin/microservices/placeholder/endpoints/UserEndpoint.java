package org.dmukhin.microservices.placeholder.endpoints;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmukhin.microservices.general.AbstractWebEndpoint;
import org.dmukhin.microservices.general.enums.HttpStatus;
import org.dmukhin.microservices.placeholder.models.user.UserDto;

/**
 * Endpoint class for handling User-related API operations. Extends AbstractWebEndpoint to provide
 * methods for interacting with the User endpoints of the JSONPlaceholder API.
 */
public class UserEndpoint extends AbstractWebEndpoint {

  private static final Logger LOGGER = LogManager.getLogger();
  private static final String USERS_END = "/users";
  private static final String USERS_RESOURCE_END = "/users/{userID}";

  /**
   * Constructor for UserEndpoint.
   *
   * @param specification The RequestSpecification for API requests.
   */
  public UserEndpoint(RequestSpecification specification) {
    super(specification);
  }

  /**
   * Creates a new user and returns the created user data.
   *
   * @param userDto The UserDto object representing the user to create.
   * @return The created UserDto.
   */
  @Step("Create User")
  public UserDto create(UserDto userDto) {
    return create(userDto, HttpStatus.CREATED)
        .extract().as(UserDto.class);
  }

  /**
   * Creates a new user and returns the response with the expected status.
   *
   * @param userDto The UserDto to create.
   * @param status  The expected HTTP status of the response.
   * @return The response of the create request.
   */
  @Step("Create User with expected status: {status}")
  public ValidatableResponse create(UserDto userDto, HttpStatus status) {
    LOGGER.info("Create new User");
    return post(this.specification, USERS_END, userDto).statusCode(status.getCode());
  }

  /**
   * Updates an existing user by ID and returns the updated user data.
   *
   * @param id      The ID of the user to update.
   * @param userDto The UserDto containing the update data.
   * @return The updated UserDto.
   */
  @Step("Update User {id}")
  public UserDto update(int id, UserDto userDto) {
    return update(userDto, id, HttpStatus.OK)
        .extract().as(UserDto.class);
  }

  /**
   * Updates an existing user and returns the response with the expected status.
   *
   * @param userDto The UserDto containing the update data.
   * @param id      The ID of the user to update.
   * @param status  The expected HTTP status of the response.
   * @return The response of the update request.
   */
  @Step("Update User {id} with expected status: {status}")
  public ValidatableResponse update(UserDto userDto, int id, HttpStatus status) {
    LOGGER.info("Update User by id [{}]", id);
    return put(this.specification, USERS_RESOURCE_END, userDto, id).statusCode(status.getCode());
  }

  /**
   * Retrieves a user by ID and returns the user data.
   *
   * @param id The ID of the user to retrieve.
   * @return The retrieved UserDto.
   */
  @Step("Retrieve User by id {id}")
  public UserDto getById(String id) {
    return getById(id, HttpStatus.OK)
        .extract().as(UserDto.class);
  }

  /**
   * Retrieves a user by ID and returns the response with the expected status.
   *
   * @param id     The ID of the user to retrieve.
   * @param status The expected HTTP status of the response.
   * @return The response of the get request.
   */
  @Step("Retrieve User by id {id} with expected status: {status}")
  public ValidatableResponse getById(String id, HttpStatus status) {
    LOGGER.info("Get User by id [{}]", id);
    return get(this.specification, USERS_RESOURCE_END, id).statusCode(status.getCode());
  }

  /**
   * Retrieves all users and returns them as a list.
   *
   * @return A list of UserDto.
   */
  @Step("Retrieve all Users")
  public List<UserDto> getAll() {
    return List.of(getAll(HttpStatus.OK).extract().as(UserDto[].class));
  }

  /**
   * Retrieves all users and returns the response with the expected status.
   *
   * @param status The expected HTTP status for retrieving all users.
   * @return The response of the get request for all users.
   */
  @Step("Retrieve all Users with expected status: {status}")
  public ValidatableResponse getAll(HttpStatus status) {
    LOGGER.info("Get all Users");
    ValidatableResponse response = get(this.specification, USERS_END);
    response.statusCode(status.getCode());
    return response;
  }
}
