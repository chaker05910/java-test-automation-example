package org.example.verifications.placeholder;

import io.qameta.allure.Step;
import org.example.service.placeholder.models.comment.CommentDto;
import org.example.verifications.BaseAsserts;

/**
 * Contains assertion methods for verifying properties of CommentDto objects.
 */
public class CommentAsserts extends BaseAsserts {

  private final CommentDto commentDto;

  /**
   * Constructs a CommentAsserts object with the provided CommentDto object.
   *
   * @param commentDto The CommentDto object to be verified.
   */
  CommentAsserts(CommentDto commentDto) {
    this.commentDto = commentDto;
    LOGGER.info("Validating comment endpoint");
  }

  /**
   * Verifies that the response containing a CommentDto object is valid.
   *
   * @return The current instance of CommentAsserts for method chaining.
   */
  @Step("Verify that the comment response is valid")
  public CommentAsserts isResponseValid() {
    hasNoNullFieldsAndUnknownProperties(commentDto);
    return this;
  }

  /**
   * Verifies the equality of the actual CommentDto object with an expected CommentDto object,
   * ignoring specified fields if provided.
   *
   * @param expectedDto    The expected CommentDto object.
   * @param ignoringFields Optional fields to ignore during comparison.
   * @return The current instance of CommentAsserts for method chaining.
   */
  @Step("Verify the equality of the comment response")
  public CommentAsserts isResponseEqualTo(CommentDto expectedDto, String... ignoringFields) {
    verifyDTOEquality(commentDto, expectedDto, CommentDto.class, ignoringFields);
    return this;
  }

  /**
   * Verifies the equality of specific fields of the actual CommentDto object with an expected
   * CommentDto object, only comparing specified fields.
   *
   * @param expectedDto     The expected CommentDto object.
   * @param comparingFields The fields to compare.
   * @return The current instance of CommentAsserts for method chaining.
   */
  @Step("Verify specific fields of the comment response")
  public CommentAsserts isResponseFieldsEqualTo(CommentDto expectedDto, String... comparingFields) {
    verifyDTOEqualitySpecialFields(commentDto, expectedDto, CommentDto.class, comparingFields);
    return this;
  }
}
