Feature: Welcome
	
  Scenario: The user wants to sign in with correct username and password
	  Given The user is on login page
	  When The user types Test@test.hu into E-mail cím
	  And The user types TestJelszo into Jelszó
	  And The user clicks Bejelentkezés button 
	  Then the user is logged in 
  
  Scenario: The user wants to sign in with wrong username and correct password
	  Given The user is on login page
	  When The user types WrongUser into E-mail cím
	  And The user types TestJelszo into Jelszó
	  And The user clicks Bejelentkezés button 
	  Then the Hibás felhasználónév/jelszó! ErrorMessage appears 
	  Then the user is not logged in 
  
  Scenario: The user wants to sign in with wrong password and correct username
	  Given The user is on login page
	  When The user types WrongPassword into Jelszó
	  And The user types Test@test.hu into E-mail cím
	  And The user clicks Bejelentkezés button 
	  Then the Hibás felhasználónév/jelszó! ErrorMessage appears 
	  Then the user is not logged in 
	  
  Scenario: The user wants to sign in with wrong username and password
	  Given The user is on login page
	  When The user types WrongPassword into Jelszó and WrongUser into E-mail cím
	  And The user clicks Bejelentkezés button 
	  Then the Hibás felhasználónév/jelszó! ErrorMessage appears 
	  Then the user is not logged in 
	  
    Scenario: The user tries to change the language of the page from Hun to Eng
	  Given The user is on webpage
	  When The user clicks the Flag icon 
	  And The user chooses the Eng option
	  Then the Súgó transforms into About
	  Then the Bejelentkezés transforms into Login
	  
	Scenario: The user tries to change the language of the page from Eng to Hun
	  Given The user is on webpage
	  When The user clicks the Flag icon 
	  And The user chooses the Hun option
	  Then the About transforms into Súgó
	  Then the Login transforms into Bejelentkezés
	  
	Scenario: The user tries to change the language of the page from Hun to Hun
	  Given The user is on webpage
	  When The user clicks the Flag icon 
	  And The user chooses the Hun option
	  Then nothing happens
	  
	Scenario: The user tries to change the language of the page from Eng to Eng
	  Given The user is on webpage
	  When The user clicks the Flag icon 
	  And The user chooses the Eng option
	  Then nothing happens
	  
	Scenario: The user clicks on Gyakorlás button 
	  Given The user is on initial page
	  When The user clicks on Gyakorlás button 
	  Then nothing happens 
	  
	Scenario: The user clicks on Szavak felvétele button 
	  Given The user is on initial page
	  When The user clicks on Szavak felvétele button 
	  Then nothing happens 
	
	Scenario: The user clicks on Lehetőségek button 
	  Given The user is on initial page
	  When The user clicks on Lehetőségek button 
	  Then nothing happens 
	  
	  
	  
	  
	  
	  