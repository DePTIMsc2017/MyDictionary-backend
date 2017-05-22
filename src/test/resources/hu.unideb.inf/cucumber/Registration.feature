Feature: Registration

Background:
    Given The user is on register page

Scenario: The user wants to register with no data input filled
    When The user does not fill any input
    And The user clicks on Registration button
    Then The Registration button is disabled


Scenario: The user wants to register with one data input filled
    When The user fills one input
    And The user clicks on Registration button
    Then The Registration button is disabled

Scenario: The user wants to register with no terms and conditions aggreed
    When The user fills all inputs
    And The user does not accept terms and conditions
    Then The Registration button is disabled

Scenario: The user wants to register with wrong passwords given
    When The user types TestPswd12 into Password
    And The user types TestPswd12 into Password again
    Then The A két jelszó nem egyezik meg! ErrorMessage appears

Scenario: The user wants to register with wrong password format given
    When The user types TestPswd into Password
    And The user types TestPswd into Password again
    Then The A jelszónak tartalmaznia kell számot, kis- és nagy betűt ErrorMessage appears


Scenario: The user wants to register with wrong password format given
    When The user types TestPswd%12 into Password
    And The user types TestPswd%12 into Password again
    Then The A jelszó csak számokat, kis- és nagy betűket tartalmazhat ErrorMessage appears


Scenario: The user wants to register with username that is already taken
    When The user fills all inputs
    And The user clicks on Registration button
    Then The username is already taken ErrorMessage appears

Scenario: The user wants to register
    When The user fills all inputs
    And The user clicks on Registration button
    Then is redirected to registration-success page

