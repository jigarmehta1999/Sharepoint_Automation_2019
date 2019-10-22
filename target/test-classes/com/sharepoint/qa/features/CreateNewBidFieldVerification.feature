Feature: Verify inputs fields on Create New Bid dialog are visible and enabled 
	As a user who wants to create a new bid
	I want to verify if the given fields are visible and enabled

Background:
    Given I have logged into sharepoint
  
Scenario: Verifying inputs fields
	Given I click on Create New bid button  
	Then Validate the required input Fields are visible and enabled in Create New Bid dialog 
	