Feature: Verify user is able to create a new bid 

Background:
    Given I have logged into sharepoint
  
  Scenario Outline: Create New bids
  	Given I click on Create New bid button  
	Then Create new bids with values <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>  		
  Examples:
  | BidTitle | ClientName | BidEventType | BidManager | SalesLead | Sensitivitylevel | Notes | Securityclearancerequirements | SubmissionInstructions |
  | Bid Title 1 | British Telecom1 | BAFO1 | Jigar Mehta	| Jigar Mehta |	Standard Security |	Notes1 | SecurityClearanceRequirements | SubmissionInstructions1 |
  
 