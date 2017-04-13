Feature: InitialPage
Background: The user is on initial page
    Given The user is on initial page

	Scenario: The user clicks on Excercise button
	  When The user clicks on Excercise button
	  Then nothing happens, stayed on initial page
	  
	Scenario: The user clicks on Szavak felvétele button 
	  When The user clicks on Szavak felvétele button
	  Then nothing happens, stayed on initial page
	
	Scenario: The user clicks on Possibilities button
	  When The user clicks on Possibilities button
	  Then nothing happens, stayed on initial page
