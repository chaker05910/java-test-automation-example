package org.dmukhin.microservices.placeholder.endpoints;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmukhin.microservices.general.AbstractWebEndpoint;
import org.dmukhin.microservices.general.enums.HttpStatus;
import org.dmukhin.microservices.placeholder.models.comment.CommentDto;

/**
 * Endpoint class for handling Comment-related API operations. Extends AbstractWebEndpoint to
 * provide methods for interacting with the Comment endpoints of the JSONPlaceholder API.
 */
public class CommentEndpoint extends AbstractWebEndpoint {

  private static final Logger LOGGER = LogManager.getLogger();
  private static final String COMMENTS_END = "/comments";
  private static final String COMMENTS_RESOURCE_END = "/comments/{commentID}";

  /**
   * Constructor for CommentEndpoint.
   *
   * @param specification The RequestSpecification for API requests.
   */
  public CommentEndpoint(RequestSpecification specification) {
    super(specification);
  }

  /**
   * Creates a new comment and returns the created comment data.
   *
   * @param commentDto The CommentDto object representing the comment to create.
   * @return The created CommentDto.
   */
  @Step("Create comment")
  public CommentDto create(CommentDto commentDto) {
    return create(commentDto, HttpStatus.CREATED)
        .extract().as(CommentDto.class);
  }

  /**
   * Creates a new comment and returns the response with the expected status.
   *
   * @param commentDto The CommentDto to create.
   * @param status     The expected HTTP status of the response.
   * @return The response of the create request.
   */
  @Step("Create comment with expected status: {status}")
  public ValidatableResponse create(CommentDto commentDto, HttpStatus status) {
    LOGGER.info("Create new Comment");
    return post(this.specification, COMMENTS_END, commentDto).statusCode(status.getCode());
  }

  /**
   * Updates an existing comment by ID and returns the updated comment data.
   *
   * @param id         The ID of the comment to update.
   * @param commentDto The CommentDto containing the update data.
   * @return The updated CommentDto.
   */
  @Step("Update comment")
  public CommentDto update(int id, CommentDto commentDto) {
    return update(commentDto, id, HttpStatus.OK).extract().as(CommentDto.class);
  }

  /**
   * Updates an existing comment and returns the response with the expected status.
   *
   * @param commentDto The CommentDto containing the update data.
   * @param id         The ID of the comment to update.
   * @param status     The expected HTTP status of the response.
   * @return The response of the update request.
   */
  @Step("Update comment with expected status: {status}")
  public ValidatableResponse update(CommentDto commentDto, int id, HttpStatus status) {
    LOGGER.info("Update Comment by id [{}]", id);
    return put(this.specification, COMMENTS_RESOURCE_END, commentDto, id).statusCode(
        status.getCode());
  }

  /**
   * Retrieves a comment by ID and returns the comment data.
   *
   * @param id The ID of the comment to retrieve.
   * @return The retrieved CommentDto.
   */
  @Step("Retrieve comment by id {id}")
  public CommentDto getById(int id) {
    return getById(id, HttpStatus.OK).extract().as(CommentDto.class);
  }

  /**
   * Retrieves a comment by ID and returns the response with the expected status.
   *
   * @param id     The ID of the comment to retrieve.
   * @param status The expected HTTP status of the response.
   * @return The response of the get request.
   */
  @Step("Retrieve comment by id {id} with expected response {status}")
  public ValidatableResponse getById(int id, HttpStatus status) {
    LOGGER.info("Get Comment by id [{}]", id);
    return get(this.specification, COMMENTS_RESOURCE_END, String.valueOf(id)).statusCode(
        status.getCode());
  }

  /**
   * Retrieves all comments and returns them as a list.
   *
   * @return A list of CommentDto.
   */
  @Step("Retrieve all comments")
  public List<CommentDto> getAll() {
    return List.of(getAll(HttpStatus.OK).extract().as(CommentDto[].class));
  }

  /**
   * Retrieves all comments and returns the response with the expected status.
   *
   * @param status The expected HTTP status for retrieving all comments.
   * @return The response of the get request for all comments.
   */
  @Step("Retrieve all comments with expected response {status}")
  public ValidatableResponse getAll(HttpStatus status) {
    LOGGER.info("Get all Comments");
    ValidatableResponse response = get(this.specification, COMMENTS_END);
    response.statusCode(status.getCode());
    return response;
  }
}
