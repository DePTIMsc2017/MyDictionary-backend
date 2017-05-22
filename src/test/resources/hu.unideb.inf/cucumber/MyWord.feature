Feature: MyWord

Background:
    Given The user is on My words page

Scenario: The user wants to see the words from Fruits collection
    When The user clicks on
    Then The word table appears

Scenario: The user wants to delete words from Fruits collection
    Given The user clicks on Fruits collection card
    When The user clicks on delete icon
    Then The word from the clicked row is deleted from the collection


Scenario: The user wants to delete words from Fruits collection
    Given The user clicks on Fruits collection card
    And The user checks the checkbox
    When The user clicks on Delete selected rows button
    Then The row is deleted

Scenario: The user wants to add new word collection
    When The user clicks on New word collection card
    Then The popup window appears

Scenario: The user wants to add new word collection
    When The user fills the popup window name input with Vegetables and description with Many types of vegetables
    And The user clicks on Confirm button
    Then The new collection appears

Scenario: The user wants to add new word collection without filling the inputs
    When The user does not fill the input fields
    And The user clicks on Confirm button
    Then The button is not clickable

Scenario: The user wants to close the popup window
    Given Popup window
    When The user clicks on Close button
    Then The popup window disappears