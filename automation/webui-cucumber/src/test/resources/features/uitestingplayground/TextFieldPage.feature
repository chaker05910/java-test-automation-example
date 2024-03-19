@web
Feature: UITestingPlayground: Text Field Page

  Scenario: Verify text input page button editing
    Given I'm on 'uitestingplayground' homepage
    When Click the text input button on home page
    And Enter text 'New Name' into new button name input field on text input page
    And Click updating button on text input page
    Then Verify updating button 'New Name' text on text input page