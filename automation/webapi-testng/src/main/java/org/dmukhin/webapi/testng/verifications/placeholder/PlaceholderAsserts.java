package org.dmukhin.webapi.testng.verifications.placeholder;

import java.util.List;
import org.example.service.placeholder.models.comment.CommentDto;
import org.example.service.placeholder.models.user.UserDto;

/**
 * Factory class for creating instances of assertion classes related to placeholder entities.
 */
public class PlaceholderAsserts {

  private PlaceholderAsserts() {
    // Private constructor to prevent instantiation from outside the class
  }

  /**
   * Returns a new instance of PlaceholderAsserts.
   *
   * @return A new instance of PlaceholderAsserts.
   */
  public static PlaceholderAsserts placeholderAsserts() {
    return new PlaceholderAsserts();
  }

  /**
   * Creates a new instance of CommentAsserts for verifying properties of a single CommentDto
   * object.
   *
   * @param commentDto The CommentDto object to be verified.
   * @return A new instance of CommentAsserts.
   */
  public CommentAsserts commentAsserts(CommentDto commentDto) {
    return new CommentAsserts(commentDto);
  }

  /**
   * Creates a new instance of CommentsListAsserts for verifying properties of a list of CommentDto
   * objects.
   *
   * @param commentDtoList The list of CommentDto objects to be verified.
   * @return A new instance of CommentsListAsserts.
   */
  public CommentsListAsserts commentListAsserts(List<CommentDto> commentDtoList) {
    return new CommentsListAsserts(commentDtoList);
  }

  /**
   * Creates a new instance of UserAsserts for verifying properties of a single UserDto object.
   *
   * @param userDto The UserDto object to be verified.
   * @return A new instance of UserAsserts.
   */
  public UserAsserts userAsserts(UserDto userDto) {
    return new UserAsserts(userDto);
  }

  /**
   * Creates a new instance of UserListAsserts for verifying properties of a list of UserDto
   * objects.
   *
   * @param userDtoList The list of UserDto objects to be verified.
   * @return A new instance of UserListAsserts.
   */
  public UserListAsserts userListAsserts(List<UserDto> userDtoList) {
    return new UserListAsserts(userDtoList);
  }
}
