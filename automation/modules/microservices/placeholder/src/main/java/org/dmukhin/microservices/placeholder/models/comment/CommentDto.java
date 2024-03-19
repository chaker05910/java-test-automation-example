package org.dmukhin.microservices.placeholder.models.comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dmukhin.microservices.general.models.BaseDto;

/**
 * Data Transfer Object for a comment. Represents the data of a comment including its association
 * with a post, commenter's details, and the content of the comment.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto extends BaseDto {

  @JsonProperty(value = "postId", access = JsonProperty.Access.READ_WRITE)
  private Long postId;
  @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
  private Long id;
  @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
  private String name;
  @JsonProperty(value = "email", access = JsonProperty.Access.READ_WRITE)
  private String email;
  @JsonProperty(value = "body", access = JsonProperty.Access.READ_WRITE)
  private String body;

  /**
   * Gets the ID of the post to which this comment belongs.
   *
   * @return The post ID.
   */
  public Long getPostId() {
    return postId;
  }

  /**
   * Sets the ID of the post to which this comment belongs.
   *
   * @param postId The post ID to set.
   * @return The current instance of CommentDto for method chaining.
   */
  public CommentDto setPostId(Long postId) {
    this.postId = postId;
    return this;
  }

  /**
   * Gets the ID.
   *
   * @return The ID.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID to which this comment belongs.
   *
   * @param id The ID to set.
   * @return The current instance of CommentDto for method chaining.
   */
  public CommentDto setId(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Gets the name of the post to which this comment belongs.
   *
   * @return The post name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name to which this comment belongs.
   *
   * @param name The name to set.
   * @return The current instance of CommentDto for method chaining.
   */
  public CommentDto setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the email of the post to which this comment belongs.
   *
   * @return The post email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email to which this comment belongs.
   *
   * @param email The name to set.
   * @return The current instance of CommentDto for method chaining.
   */
  public CommentDto setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Gets the body of the post to which this comment belongs.
   *
   * @return The post body.
   */
  public String getBody() {
    return body;
  }

  /**
   * Sets the body to which this comment belongs.
   *
   * @param body The body to set.
   * @return The current instance of CommentDto for method chaining.
   */
  public CommentDto setBody(String body) {
    this.body = body;
    return this;
  }

  /**
   * Compares this comment DTO to another object for equality. The result is {@code true} if and
   * only if the argument is not {@code null} and is a CommentDto object that has the same values
   * for postId, id, name, email, and body properties.
   *
   * @param o The object to compare this CommentDto against.
   * @return true if the given object represents a CommentDto equivalent to this comment, false
   * otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CommentDto that = (CommentDto) o;

    return new EqualsBuilder().append(postId, that.postId)
        .append(id, that.id)
        .append(name, that.name)
        .append(email, that.email)
        .append(body, that.body)
        .isEquals();
  }

  /**
   * Returns a hash code value for the comment. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}. The hash code is computed using the
   * hash codes of the postId, id, name, email, and body properties.
   *
   * @return a hash code value for this comment.
   */
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(postId)
        .append(id)
        .append(name)
        .append(email)
        .append(body)
        .toHashCode();
  }

}
