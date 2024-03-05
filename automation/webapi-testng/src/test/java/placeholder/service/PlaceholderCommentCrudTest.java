package placeholder.service;

import static org.example.service.placeholder.PlaceholderApi.placeholderApi;
import static org.example.verifications.placeholder.PlaceholderAsserts.placeholderAsserts;

import java.util.Arrays;
import java.util.List;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.example.service.placeholder.models.comment.CommentDto;
import org.example.testcases.general.placeholder.BasePlaceholderTest;
import org.example.testcases.groups.TestGroups;
import org.testng.annotations.Test;

/**
 * Test class for performing CRUD operations on comments in the JSONPlaceholder API. It extends
 * BaseTestNgTests, indicating it uses TestNG as the testing framework.
 */
@Epic("Placeholder Service")
@Feature("Comment Endpoint")
public class PlaceholderCommentCrudTest extends BasePlaceholderTest {

  /**
   * Test for verifying the ability to create a new comment. This test creates a comment and
   * verifies that the created comment matches the input.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("POST: Verify ability to create new Comment")
  public void testCreatingNewComment() {
    CommentDto commentDto = new CommentDto()
        .setPostId(faker.number().randomNumber())
        .setName("name_" + faker.name().firstName())
        .setEmail(faker.internet().emailAddress())
        .setBody(faker.lorem().characters(100));
    CommentDto createdCommentResponse = placeholderApi().comment().create(commentDto);

    placeholderAsserts().commentAsserts(createdCommentResponse)
        .isResponseValid()
        .isResponseEqualTo(commentDto, "id");
  }

  /**
   * Test for verifying the ability to update an existing comment. This test updates a comment and
   * verifies that the updated comment matches the new data.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("PUT: Verify ability to update Comment")
  public void testUpdateComment() {
    int commentId = 1;
    CommentDto commentDto = new CommentDto()
        .setPostId((long) commentId)
        .setName("UpdateName_" + faker.name().firstName())
        .setEmail("UpdatedEmail_" + faker.internet().emailAddress())
        .setBody(faker.lorem().characters(100));
    CommentDto updateResponse = placeholderApi().comment().update(commentId, commentDto);

    placeholderAsserts().commentAsserts(updateResponse)
        .isResponseValid()
        .isResponseEqualTo(commentDto, "id");
  }

  /**
   * Test for verifying the ability to retrieve a specific comment by its ID. The test retrieves a
   * comment and then verifies specific fields of the comment.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("GET: Verify ability to retrieve user by Id")
  public void testRetrieveCommentById() {
    int commentId = 5;
    CommentDto comment = placeholderApi().comment().getById(commentId);
    CommentDto expectedComment = new CommentDto()
        .setName("vero eaque aliquid doloribus et culpa")
        .setEmail("Hayden@althea.biz");

    // Verification
    placeholderAsserts().commentAsserts(comment)
        .isResponseValid()
        .isResponseFieldsEqualTo(expectedComment, "name", "email");
  }

  /**
   * Test for verifying the ability to retrieve a list of all comments. This test fetches all
   * comments and performs assertions on the size of the list and specific content.
   */
  @Test(groups = {TestGroups.REG, TestGroups.API, TestGroups.COMP})
  @TmsLink("TMS-123")
  @Story("GET: Verify ability to retrieve Comments list")
  public void testRetrieveAllComments() {
    List<CommentDto> comments = placeholderApi().comment().getAll();
    List<String> commentNames = Arrays.asList("id labore ex et quam laborum",
        "quo vero reiciendis velit similique earum",
        "odio adipisci rerum aut animi");

    placeholderAsserts().commentListAsserts(comments)
        .isResponseValid()
        .isCommentListSizeGreaterThan(300)
        .verifyCommentNamesInList(commentNames);
  }
}
