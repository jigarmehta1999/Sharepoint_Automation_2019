$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com/sharepoint/qa/features/CreateNewBidFieldVerification.feature");
formatter.feature({
  "name": "Verify inputs fields on Create New Bid dialog are visible and enabled",
  "description": "\tAs a user who wants to create a new bid\n\tI want to verify if the given fields are visible and enabled",
  "keyword": "Feature"
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
  "name": "Verifying inputs fields",
  "description": "",
  "keyword": "Scenario"
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
  "name": "Validate the required input Fields are visible and enabled in Create New Bid dialog",
  "keyword": "Then "
});
formatter.match({
  "location": "Generic_Steps.validate_the_required_input_Fields_are_visible_and_enabled()"
});
formatter.result({
  "status": "passed"
});
});