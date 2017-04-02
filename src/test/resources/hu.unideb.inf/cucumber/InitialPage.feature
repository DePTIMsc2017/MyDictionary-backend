Feature: InitialPage
Background: The user is on initial page
    Given The user is on initial page

	Scenario: The user clicks on Gyakorlás button
	  When The user clicks on Gyakorlás button 
	  Then nothing happens, stayed on initial page
	  
	Scenario: The user clicks on Szavak felvétele button 
	  When The user clicks on Szavak felvétele button
	  Then nothing happens, stayed on initial page
	
	Scenario: The user clicks on Lehetőségek button 
	  When The user clicks on Lehetőségek button
	  Then nothing happens, stayed on initial page
