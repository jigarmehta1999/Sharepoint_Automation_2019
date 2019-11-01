$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com/sharepoint/qa/features/NewBid.feature");
formatter.feature({
  "name": "Verify user is able to create a new bid",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Create New bids",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click on Create New bid button",
  "keyword": "Given "
});
formatter.step({
  "name": "Create new bids with values \u003cBidTitle\u003e and \u003cClientName\u003e and \u003cBidEventType\u003e and \u003cBidManager\u003e and \u003cSalesLead\u003e and \u003cSensitivitylevel\u003e and \u003cNotes\u003e and \u003cSecurityclearancerequirements\u003e and \u003cSubmissionInstructions\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "BidTitle",
        "ClientName",
        "BidEventType",
        "BidManager",
        "SalesLead",
        "Sensitivitylevel",
        "Notes",
        "Securityclearancerequirements",
        "SubmissionInstructions"
      ]
    },
    {
      "cells": [
        "Bid Title 1",
        "British Telecom1",
        "BAFO",
        "Jigar Mehta",
        "Jigar Mehta",
        "Standard Security",
        "Notes1",
        "SecurityClearanceRequirements1",
        "SubmissionInstructions1"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have logged into sharepoint",
  "keyword": "Given "
});
formatter.match({
  "location": "Generic_Steps.i_have_logged_into_sharepoint()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create New bids",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click on Create New bid button",
  "keyword": "Given "
});
formatter.match({
  "location": "Generic_Steps.i_click_on_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create new bids with values Bid Title 1 and British Telecom1 and BAFO and Jigar Mehta and Jigar Mehta and Standard Security and Notes1 and SecurityClearanceRequirements1 and SubmissionInstructions1",
  "keyword": "Then "
});
formatter.match({
  "location": "Generic_Steps.create_new_bids(String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
});