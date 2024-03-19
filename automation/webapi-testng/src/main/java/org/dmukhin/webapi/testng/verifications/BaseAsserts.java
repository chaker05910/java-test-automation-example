package org.dmukhin.webapi.testng.verifications;

import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.assertj.core.data.TemporalUnitOffset;
import org.dmukhin.microservices.general.models.BaseDto;

/**
 * Base class for implementing verification assertions in testing. Provides common assertion methods
 * for Data Transfer Object (DTO) verification.
 */
public abstract class BaseAsserts {

    protected static final Logger LOGGER = LogManager.getLogger();


    /**
     * Protected Constructor
     */
    protected BaseAsserts() {
    }

    /**
     * Returns an array of field names to be ignored during verification. This method can be
     * overridden in subclasses.
     *
     * @return An array of strings representing the names of fields to ignore.
     */
    protected String[] defaultIgnoreFields() {
        return new String[0];
    }

    /**
     * Verifies that the provided DTO does not have any null fields or unknown properties. Considers
     * fields specified in `defaultIgnoreFields` for ignoring during verification.
     *
     * @param actualResponse The DTO object to validate.
     * @return The current instance of BaseAsserts for method chaining.
     */
    @Step("Assert that DTO has no null fields or unknown properties.")
    public BaseAsserts hasNoNullFieldsAndUnknownProperties(BaseDto actualResponse) {
        if (defaultIgnoreFields() != null && defaultIgnoreFields().length > 0) {
            hasNoNullFieldsOrPropertiesExcept(actualResponse, defaultIgnoreFields());
        } else {
            hasNoNullFieldsOrProperties(actualResponse);
        }
        hasNoUnknownProperties(actualResponse);
        return this;
    }

    /**
     * Asserts that the provided DTO does not contain unknown properties.
     *
     * @param actualResponse The DTO object to validate.
     * @return The current instance of BaseAsserts for method chaining.
     */
    @Step("Assert that DTO has no unknown properties")
    public BaseAsserts hasNoUnknownProperties(BaseDto actualResponse) {
        assertThat(actualResponse.hasUnknownProperties())
                .as("Has No unknown Properties")
                .isFalse();
        return this;
    }

    /**
     * Asserts that the provided DTO does not have any null fields or properties.
     *
     * @param actualResponse The DTO object to validate.
     * @return The current instance of BaseAsserts for method chaining.
     */
    @Step("Assert that DTO has no null fields or properties")
    public BaseAsserts hasNoNullFieldsOrProperties(BaseDto actualResponse) {
        assertThat(actualResponse)
                .as("Has No Null Fields Or Properties")
                .hasNoNullFieldsOrProperties();
        return this;
    }

    /**
     * Asserts that the provided DTO does not have any null fields or properties, except for the
     * specified fields.
     *
     * @param actualResponse The DTO object to validate.
     * @param fields         The fields to exclude from the null check.
     * @return The current instance of BaseAsserts for method chaining.
     */
    @Step("Assert that DTO has no null fields or properties except specified fields")
    public BaseAsserts hasNoNullFieldsOrPropertiesExcept(BaseDto actualResponse, String... fields) {
        assertThat(actualResponse)
                .as("Has no unknown properties except: " + Arrays.toString(fields))
                .hasNoNullFieldsOrPropertiesExcept(fields);
        return this;
    }


    /**
     * Verifies that two objects are equal.
     *
     * @param expected      The expected object.
     * @param actual        The actual object.
     * @param verifiedField The name of the field to help with logging.
     */
    @Step("Verify that two objects are equal")
    protected void verifyObject(Object expected, Object actual, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: [{}], actual: [{}]", verifiedField, expected,
                actual);
        assertThat(expected)
                .as(verifiedField)
                .isEqualTo(actual);
    }

    /**
     * Verifies that two objects are not equal.
     *
     * @param expected      The expected object.
     * @param actual        The actual object.
     * @param verifiedField The name of the field to help with logging.
     */
    @Step("Verify that two objects are not equal")
    protected void verifyObjectNotEqual(Object expected, Object actual, String verifiedField) {
        LOGGER.debug("Verify data <{}> not equaling expected: [{}], actual: [{}]", verifiedField,
                expected, actual);
        assertThat(expected)
                .as(verifiedField)
                .isNotEqualTo(actual);
    }

    /**
     * Verifies that two lists of strings are equal.
     *
     * @param expected      The expected list of strings.
     * @param actual        The actual list of strings.
     * @param verifiedField The name of the field to help with logging.
     */
    @Step("Verify that two lists of objects are equal")
    protected void verifyObjects(List<Object> expected, List<Object> actual, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: [{}], actual: [{}]", verifiedField, expected,
                actual);
        assertThat(expected)
                .as(verifiedField)
                .isEqualTo(actual);
    }

    /**
     * Verifies that a list of expected strings exactly matches a list of actual strings in any order.
     * Logs the expected and actual lists for easier identification in case of a failure.
     *
     * @param expected      The expected list of strings.
     * @param actual        The actual list of strings.
     * @param verifiedField The field name used for logging the verification step.
     */
    @Step("Verify that a list of expected strings exactly matches a list of actual strings in any order")
    protected void verifyListOfStrings(List<String> expected, List<String> actual,
            String verifiedField) {
        LOGGER.debug("Verify List of Strings <{}>\nexpected: {},\nactual: {}", verifiedField,
                expected,
                actual);
        assertThat(expected)
                .as(verifiedField)
                .containsExactlyInAnyOrderElementsOf(actual);
    }

    /**
     * Verifies that a list of actual strings contains all elements of an expected list of strings.
     * Logs the expected and actual lists for easier identification in case of a failure.
     *
     * @param expected      The expected list of strings.
     * @param actual        The actual list of strings.
     * @param verifiedField The field name used for logging the verification step.
     */
    @Step("Verify that a list of actual strings contains all elements of an expected list of strings")
    protected void verifyListOfStringsContains(List<String> expected, List<String> actual,
            String verifiedField) {
        LOGGER.debug("Verify List of Strings <{}> contains\nactual: {},\nexpected: {}",
                verifiedField,
                expected,
                actual);
        assertThat(actual)
                .as(verifiedField)
                .contains(expected.toArray(new String[0]));
    }

    /**
     * Verifies that the provided list of objects has the specified size.
     *
     * @param actual        The actual list of objects.
     * @param size          The expected size of the list.
     * @param verifiedField The name of the field being verified, used for logging.
     */
    @Step("Verify that the list of objects has a specified size")
    protected void verifyListHasSize(List<Object> actual, int size, String verifiedField) {
        LOGGER.debug("Verify List of Objects <{}> has size\nactual: {},\nexpected: {}",
                verifiedField,
                actual.size(),
                size);
        assertThat(actual)
                .as(verifiedField)
                .hasSize(size);
    }

    /**
     * Verifies that the size of the provided list of objects is greater than the specified size.
     *
     * @param actual        The actual list of objects.
     * @param size          The expected minimum size of the list.
     * @param verifiedField The name of the field being verified, used for logging.
     */
    @Step("Verify that the size of the list of objects is greater than a specified size")
    protected void verifyListSizeGreaterThan(List<Object> actual, int size, String verifiedField) {
        LOGGER.debug("Verify List of Objects <{}> size greater than\nactual: {},\nexpected: >{}",
                verifiedField, actual.size(),
                size);
        assertThat(actual)
                .as(verifiedField)
                .hasSizeGreaterThan(size);
    }

    /**
     * Verifies that a specified field is not blank. Logs the field for easier identification in case
     * of a failure.
     *
     * @param field The field to be verified as not blank.
     */
    @Step("Verify that a specified field is not blank")
    protected void verifyFieldIsNotBlank(String field) {
        LOGGER.debug("Verify field: {} is not blank", field);
        assertThat(field).isNotBlank();
    }

    /**
     * Verifies that two DTOs are equal, ignoring specified fields. Throws a RuntimeException if the
     * actual or expected objects are not instances of the specified type.
     *
     * @param actual         The actual DTO object.
     * @param expected       The expected DTO object.
     * @param type           The class type of the DTOs.
     * @param ignoringFields Array of field names to be ignored during comparison.
     */
    @Step("Verify that two DTOs are equal, considering specified fields to ignore")
    protected void verifyDTOEquality(BaseDto actual, BaseDto expected,
            Class<? extends BaseDto> type,
            String... ignoringFields) {
        verifyDTOEquality(actual, expected, type, true, ignoringFields);
    }

    /**
     * Verifies that two DTOs are equal, comparing only specified fields. Throws a RuntimeException if
     * the actual or expected objects are not instances of the specified type.
     *
     * @param actual          The actual DTO object.
     * @param expected        The expected DTO object.
     * @param type            The class type of the DTOs.
     * @param comparingFields Array of field names to be compared during comparison.
     */
    @Step("Verify that two DTOs are equal, considering specified fields")
    protected void verifyDTOEqualitySpecialFields(BaseDto actual, BaseDto expected,
            Class<? extends BaseDto> type,
            String... comparingFields) {
        verifyDTOEquality(actual, expected, type, false, comparingFields);
    }

    /**
     * Private helper method to verify DTO equality based on a comparison strategy. This method is
     * used to reduce code duplication in public verification methods.
     *
     * @param actual       The actual DTO object.
     * @param expected     The expected DTO object.
     * @param type         The class type of the DTOs.
     * @param ignoreFields If true, fields are ignored; if false, only specified fields are compared.
     * @param fields       Array of field names to be ignored or compared, based on ignoreFields.
     */
    private void verifyDTOEquality(BaseDto actual, BaseDto expected, Class<? extends BaseDto> type,
            boolean ignoreFields, String... fields) {
        if (!actual.getClass().isAssignableFrom(type) || !expected.getClass()
                .isAssignableFrom(type)) {
            throw new RuntimeException(
                    String.format(
                            "Incompatible types of DTOs provided. Type expected by method: %s, " +
                                    "actual DTO type [%s}, expected DTO type [%s}",
                            type.getSimpleName(),
                            actual.getClass().getSimpleName(),
                            expected.getClass().getSimpleName()));
        }

        LOGGER.debug("Compare JSON objects: expected: {}, actual: {}",
                actual.getClass().getSimpleName(),
                expected.getClass().getSimpleName());

        RecursiveComparisonConfiguration comparisonConfiguration = RecursiveComparisonConfiguration.builder()
                .withIgnoredFields(defaultIgnoreFields())
                .withIgnoreAllActualNullFields(true)
                .withIgnoredOverriddenEqualsForTypes(BaseDto.class)
                .build();

        if (ignoreFields) {
            comparisonConfiguration.ignoreFields(fields);
        } else {
            comparisonConfiguration.compareOnlyFields(fields);
        }

        assertThat(actual)
                .usingRecursiveComparison(comparisonConfiguration)
                .isEqualTo(expected);
    }

    /**
     * Verifies that a given number is positive.
     *
     * @param actual        The number to be checked.
     * @param verifiedField A description of the field to aid in logging.
     */
    @Step("Verify that a given number is positive")
    protected void verifyNumberIsPositive(Number actual, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: Greater than 0 , actual: [{}]", verifiedField,
                actual);
        assertThat(actual.doubleValue())
                .as(verifiedField)
                .isPositive();
    }

    /**
     * Verifies that a given number is not negative.
     *
     * @param actual        The number to be checked.
     * @param verifiedField A description of the field to aid in logging.
     */
    @Step("Verify that a given number is not negative")
    protected void verifyNumberIsNotNegative(Number actual, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: Not less than 0 , actual: [{}]", verifiedField,
                actual);
        assertThat(actual.doubleValue())
                .as(verifiedField)
                .isNotNegative();
    }

    /**
     * Verifies that a string contains only digits.
     *
     * @param actual        The string to be checked.
     * @param verifiedField A description of the field to aid in logging.
     */
    @Step("Verify that a string contains only digits")
    protected void verifyContainsOnlyDigits(String actual, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: contains only digits , actual: [{}]",
                verifiedField,
                actual);
        assertThat(actual)
                .as(verifiedField)
                .containsOnlyDigits();
    }

    /**
     * Verifies that the actual object is one of the objects in the provided array. Logs the actual
     * value and the array of possible values for debugging purposes.
     *
     * @param actual        The actual object to be verified.
     * @param in            An array of objects among which the actual object should be found.
     * @param verifiedField The name of the field being verified, used for logging.
     */
    @Step("Verify that the actual object is one of the objects in the provided array")
    protected void verifyIsIn(Object actual, Object[] in, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: in <{}>", actual, in);
        assertThat(actual)
                .as(verifiedField)
                .isIn(in);
    }

    /**
     * Verifies that the actual object is not in the provided array of objects. Logs the actual value
     * and the array for debugging purposes.
     *
     * @param actual        The actual object to be verified.
     * @param in            An array of objects among which the actual object should not be found.
     * @param verifiedField The name of the field being verified, used for logging.
     */
    @Step("Verify that the actual object is not in the provided array of objects")

    protected void verifyIsNotIn(Object actual, Object[] in, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: not in <{}>", actual, in);
        assertThat(actual)
                .as(verifiedField)
                .isNotIn(in);
    }

    /**
     * Verifies that the actual string contains a specific regex pattern. Logs the actual string and
     * the regex pattern for debugging purposes.
     *
     * @param actual        The actual string to be verified.
     * @param containsRegex The regex pattern that should be contained in the actual string.
     * @param verifiedField The name of the field being verified, used for logging.
     */
    @Step("Verify that the actual string contains a specific regex pattern")
    protected void verifyContains(String actual, String containsRegex, String verifiedField) {
        LOGGER.debug("Verify data <{}> expected: contains text <{}>", actual, containsRegex);
        assertThat(actual)
                .as(verifiedField)
                .contains(containsRegex);
    }

    /**
     * Verifies that the actual date is close to the expected date within a specified temporal offset.
     * Logs both the expected and actual dates for debugging purposes.
     *
     * @param actual        The actual date in string format (ISO-8601).
     * @param expected      The expected date in string format (ISO-8601).
     * @param offset        The temporal unit offset within which the dates should be close.
     * @param verifiedField The name of the field being verified, used for logging.
     */
    @Step("Verify that the actual date is close to the expected date within a specified temporal offset")
    protected void verifyDateIsClosedTo(String actual, String expected, TemporalUnitOffset offset,
            String verifiedField) {
        Instant expectedDate = Instant.parse(expected);
        Instant actualDate = Instant.parse(actual);
        LOGGER.debug("Verify Date <{}> expected: [{}] is close to: [{}]", verifiedField,
                expectedDate,
                actualDate);
        assertThat(actualDate)
                .as(verifiedField)
                .isCloseTo(expectedDate, offset);
    }
}