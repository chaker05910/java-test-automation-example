package org.example.verifications.placeholder;

import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import org.example.service.placeholder.models.comment.CommentDto;
import org.example.verifications.BaseAsserts;

/**
 * Contains assertion methods for verifying properties of lists of CommentDto objects.
 */
public class CommentsListAsserts extends BaseAsserts {

    private final List<CommentDto> commentDtoList;

    /**
     * Constructs a CommentsListAsserts object with the provided list of CommentDto objects.
     *
     * @param commentDtoList The list of CommentDto objects to be verified.
     */
    CommentsListAsserts(List<CommentDto> commentDtoList) {
        this.commentDtoList = commentDtoList;
        LOGGER.info("Validating comments endpoint");
    }

    /**
     * Verifies that the response containing a list of CommentDto objects is valid.
     *
     * @return The current instance of CommentsListAsserts for method chaining.
     */
    @Step("Verify that the comments list response is valid")
    public CommentsListAsserts isResponseValid() {
        for (CommentDto commentDto : commentDtoList) {
            hasNoNullFieldsAndUnknownProperties(commentDto);
        }
        return this;
    }

    /**
     * Verifies that the list of CommentDto objects contains expected comment names.
     *
     * @param expectedCommentNames The list of expected comment names.
     * @return The current instance of CommentsListAsserts for method chaining.
     */
    @Step("Verify that the comments list contains expected names")
    public CommentsListAsserts verifyCommentNamesInList(List<String> expectedCommentNames) {
        List<String> commentNames = commentDtoList.stream().map(CommentDto::getName).toList();
        verifyListOfStringsContains(expectedCommentNames, commentNames, "Comment names");
        return this;
    }

    /**
     * Verifies that the list of CommentDto objects has a size greater than the specified size.
     *
     * @param size The expected minimum size of the comment list.
     * @return The current instance of CommentsListAsserts for method chaining.
     */
    @Step("Verify that the comments list size is greater than a specified size")
    public CommentsListAsserts isCommentListSizeGreaterThan(int size) {
        verifyListSizeGreaterThan(Arrays.asList(commentDtoList.toArray()), size, "Comment List");
        return this;
    }
}
