Feature: ExerciseLessons

Background:
    Given The user is on Exercise lessons page

Scenario: The user wants to exercise lessons
    When The user selects the collection
    Then The letter lines appear

Scenario: The user wants to exercise lessons with new word
    When The user selects the collection
    And The user clicks on New button
    Then new word appears

Scenario: The user wants to exercise lessons with repeat the last word
    When The user selects the collection
    And The user clicks on Repeat button
    Then the letter lines for word from the same collection appears