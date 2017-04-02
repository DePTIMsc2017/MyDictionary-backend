Feature: Login

Background:
    Given The user is on login page

Scenario: The user wants to sign in with correct username and password
	  When The user types teszt@teszt.hu into E-mail cím
	  And The user types teszt into Jelszó
	  And The user clicks on Bejelentkezés button
	  Then The user is logged in

  Scenario: The user wants to sign in with wrong username and correct password
	  When The user types WrongUser@wrong.wrong into E-mail cím
	  And The user types TestJelszo into Jelszó
	  And The user clicks on Bejelentkezés button
	  Then The Hibás felhasználónév/jelszó! ErrorMessage appears
	  And The user is not logged in

  Scenario: The user wants to sign in with wrong password and correct username
	  When The user types Test@test.hu into E-mail cím
	  And The user types WrongPassword into Jelszó
	  And The user clicks on Bejelentkezés button
	  Then The Hibás felhasználónév/jelszó! ErrorMessage appears
	  And The user is not logged in

  Scenario: The user wants to sign in with wrong username and password
	  When The user types WrongUser@wrong.wrong into E-mail cím
	  And The user types WrongPassword into Jelszó
	  And The user clicks on Bejelentkezés button
	  Then The Hibás felhasználónév/jelszó! ErrorMessage appears
	  And The user is not logged in