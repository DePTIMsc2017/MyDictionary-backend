Feature: Login

Background:
    Given The user is on login page

Scenario: The user wants to sign in with correct username and password
	  When The user types teszt into username
	  And The user types teszt into password
	  And The user clicks on Login button
	  Then The user is logged in

  Scenario: The user wants to sign in with wrong username and correct password
	  When The user types Wrong into username
	  And The user types TestJelszo into password
	  And The user clicks on Login button
	  Then The Hibás felhasználónév/jelszó! ErrorMessage appears
	  And The user is not logged in

  Scenario: The user wants to sign in with wrong password and correct username
	  When The user types teszt into username
	  And The user types WrongPassword into password
	  And The user clicks on Login button
	  Then The Hibás felhasználónév/jelszó! ErrorMessage appears
	  And The user is not logged in

  Scenario: The user wants to sign in with wrong username and password
	  When The user types WrongUser into username
	  And The user types WrongPassword into password
	  And The user clicks on Login button
	  Then The Hibás felhasználónév/jelszó! ErrorMessage appears
	  And The user is not logged in