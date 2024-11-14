package org.dmukhin.webui.testng.testcases.enums;

/**
 * Defines constants for various test groups. This class provides a centralized location for
 * defining group names used in test categorization.
 */
public class TestGroups {

    /**
     * Test group name for regression tests.
     */
    public static final String REG = "regression";
    /**
     * Test group name for UI tests.
     */
    public static final String UI = "ui";
    /**
     * Test group name for component tests.
     */
    public static final String COMP = "component";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private TestGroups() {
        // default constructor
    }
}
