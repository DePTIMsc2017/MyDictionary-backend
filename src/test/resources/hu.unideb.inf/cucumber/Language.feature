Feature: Language

Background:
    Given The user is on webpage

    Scenario: The user tries to change the language of the page from Hun to Eng
	  When The user clicks the Flag icon
	  And The user chooses the Eng option
	  Then the Súgó transforms into About
	  And the Bejelentkezés transforms into Login

	Scenario: The user tries to change the language of the page from Eng to Hun
	  When The user clicks the Flag icon
	  And The user chooses the Hun option
	  Then the About transforms into Súgó
	  And the Login transforms into Bejelentkezés

	Scenario: The user tries to change the language of the page from Hun to Hun
	  When The user clicks the Flag icon
	  And The user chooses the Hun option
	  Then nothing happens

	Scenario: The user tries to change the language of the page from Eng to Eng
	  When The user clicks the Flag icon
	  And The user chooses the Eng option
	  Then nothing happens