@web
Feature: UITestingPlayground: Click Page

  Scenario: Verify click page bad button class
    Given I'm on 'uitestingplayground' homepage
    When Click the click button on home page
    And Click the bad button on click page
    Then Verify bad button 'btn btn-success' class name on click page