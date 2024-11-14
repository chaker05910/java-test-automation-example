@web
Feature: UITestingPlayground: Visibility Page

  Scenario: Verify removed button is not visible after clicking hide button
    Given I'm on 'uitestingplayground' homepage
    When Click the visibility button on home page
    And Click hide button on visibility page
    Then Verify remove button not visible on visibility page
