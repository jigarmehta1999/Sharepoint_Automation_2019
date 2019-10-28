package com.sharepoint.qa.steps;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.sharepoint.qa.base.TestBase;

import com.sharepoint.qa.pages.CreateNewBidPage;
import com.sharepoint.qa.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Generic_Steps extends TestBase {

	HomePage homepage;
	CreateNewBidPage createnewbidpage;

	SoftAssert sa;

	@Then("Create new bids with values (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)")
	public void create_new_bids(String Name, String BidTitle, String ClientName, String BidEventType,
			String BidManager, String SalesLead, String SensitivityLevel, String Notes, String SecurityClearanceRequirements,
			String SubmissionInstructions) throws InterruptedException {
		System.out.println("Name = " + Name);
		System.out.println("BidTitle = " + BidTitle);
		System.out.println("ClientName = " + ClientName);
		System.out.println("BidEventType = " + BidEventType);
		System.out.println("BidManager = " + BidManager);
		System.out.println("SalesLead = " + SalesLead);
		System.out.println("Sensitivitylevel = " + SensitivityLevel);
		System.out.println("Notes = " + Notes);
		System.out.println("Securityclearancerequirements = " + SecurityClearanceRequirements);
		System.out.println("SubmissionInstructions = " + SubmissionInstructions);
		System.out.println();
		System.out.println();

//		TestBase.initialization();
//		homepage = new HomePage();
		createnewbidpage = new CreateNewBidPage();
//		sa = new SoftAssert();
//		test = rep.createTest("Testing CreateNewBid");

		test.log(Status.INFO, "Browser used: " + prop.get("browser"));

		
/*		String CRMID = createnewbidpage.setCRMID();
		test.log(Status.INFO, "CRMID = " + CRMID);

		createnewbidpage.setBidTitle(BidTitle);
		test.log(Status.INFO, "BidTitle = " + BidTitle);

		createnewbidpage.setClientName(ClientName);
		test.log(Status.INFO, "ClientName = " + ClientName);

		createnewbidpage.setBidEventType(BidEventType);
		test.log(Status.INFO, "BidEventType = " + BidEventType);

		String actualsubmissiondate = createnewbidpage.setSubmissonDate();
		test.log(Status.INFO, "Submission Date = " + actualsubmissiondate);

		createnewbidpage.setBidManager(BidManager);
		test.log(Status.INFO, "BidManager = " + BidManager);

		createnewbidpage.setSalesLead(SalesLead);
		test.log(Status.INFO, "SalesLead = " + SalesLead);

		createnewbidpage.setSensitivityLevel(SensitivityLevel);
		test.log(Status.INFO, "SensitivityLevel = " + SensitivityLevel);

		createnewbidpage.setNotes(Notes);
		test.log(Status.INFO, "Notes = " + Notes);

		createnewbidpage.setSecurityClearanceRequirements(SecurityClearanceRequirements);
		test.log(Status.INFO, "SecurityClearanceRequirements = " + SecurityClearanceRequirements);

		createnewbidpage.setSubmissionInstructions(SubmissionInstructions);
		test.log(Status.INFO, "SubmissionInstructions = " + SubmissionInstructions);

		createnewbidpage.clickOKButton();

		String url = prop.getProperty("url");
		String[] temp = url.split("Forms/StandardSecurityView.aspx");
		String bidlisturl = temp[0].concat(CRMID);

		System.out.println("bidlisturl = " + bidlisturl);
		boolean bidcreated = false;

		HttpURLConnection huc = null;
		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Bid creation is unsuccessful");
			test.log(Status.INFO, "bidlisturl = " + bidlisturl);
			sa.fail();
		}

		for (int i = 0; i < 20; i++) {
			int responsecode = 0;
			try {
				responsecode = huc.getResponseCode();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("responsecode = " + responsecode);
			if (responsecode == 200) {
				System.out.println("i = " + i);
				test.log(Status.PASS, "Bid creation is successful. Bid number " + CRMID);
				test.log(Status.INFO, "Bid url = " + bidlisturl);
				bidcreated = true;
				break;
			}
			Thread.sleep(1000);
		}

		System.out.println("bidcreated = " + bidcreated);
		sa.assertTrue(bidcreated); */
		rep.flush();
		sa.assertAll();

	}

	@Given("I have logged into sharepoint")
	public void i_have_logged_into_sharepoint() throws InterruptedException {
		TestBase.initialization();		
		HomePage homepage = new HomePage();

		sa = new SoftAssert();
		test = rep.createTest("Testing...");

		String expectedtitle = "Home";
		String actualtitle = homepage.getPageTitle();

		System.out.println("actualtitle = " + actualtitle);
		sa.assertEquals(actualtitle, expectedtitle);

		test.log(Status.INFO, "Expected title = " + expectedtitle);
		test.log(Status.INFO, "Actual title = " + actualtitle);
		if (expectedtitle.equals(actualtitle)) {
			test.log(Status.PASS, "Expected and Actual title is a match");
		} else {
			test.log(Status.FAIL, "Expected and Actual title does NOT match");
		}

//		sa.assertAll();
	}

	@Given("I click on Create New bid button")
	public void i_click_on_button() throws InterruptedException {
		Thread.sleep(8000);
		HomePage homepage = new HomePage();
		
		test.log(Status.INFO, "Browser used: " + prop.get("browser"));

		homepage.clickBidListMenu();
		homepage.clickNew();
		homepage.clickCreateNewBidButton();
	}

	@Then("^Validate the required input Fields are visible and enabled in Create New Bid dialog$")
	public void validate_the_required_input_Fields_are_visible_and_enabled() {
		CreateNewBidPage createnewbidpage = new CreateNewBidPage();

		if (createnewbidpage.isNameTextBoxDisplayed()) {
			test.log(Status.PASS, "CRM ID TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "CRM ID TextBox is NOT Displayed");
		}
		if (createnewbidpage.isNameTextBoxEnabled()) {
			test.log(Status.PASS, "CRM ID TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "CRM ID TextBox is NOT Enabled");
		}

		if (createnewbidpage.isBidTitleTextBoxDisplayed()) {
			test.log(Status.PASS, "Bid Title TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Title TextBox is NOT Displayed");
		}
		if (createnewbidpage.isBidTitleTextBoxEnabled()) {
			test.log(Status.PASS, "Bid Title TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Title TextBox is NOT Enabled");
		}

		if (createnewbidpage.isClientNameTextBoxDisplayed()) {
			test.log(Status.PASS, "Client Name TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Client Name TextBox is NOT Displayed");
		}
		if (createnewbidpage.isClientNameTextBoxEnabled()) {
			test.log(Status.PASS, "Client Name TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "Client Name TextBox is NOT Enabled");
		}

		if (createnewbidpage.isBidEventTypeDropDownBoxDisplayed()) {
			test.log(Status.PASS, "Bid Event Type is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Event Type is NOT Displayed");
		}
		if (createnewbidpage.isBidEventTypeDropDownBoxEnabled()) {
			test.log(Status.PASS, "Bid Event Type is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Event Type is NOT Enabled");
		}
		
		if (createnewbidpage.isBidManagerDropDownDisplayed()) {
			test.log(Status.PASS, "Bid Manager DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Manager DropDown is NOT Displayed");
		}
		if (createnewbidpage.isBidManagerDropDownEnabled()) {
			test.log(Status.PASS, "Bid Manager DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Manager DropDown is NOT Enabled");
		}
		
		if (createnewbidpage.isSalesLeadDropDownDisplayed()) {
			test.log(Status.PASS, "Sales Lead DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Sales Lead DropDown is NOT Displayed");
		}
		if (createnewbidpage.isSalesLeadDropDownEnabled()) {
			test.log(Status.PASS, "Sales Lead DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Sales Lead DropDown is NOT Enabled");
		}

		if (createnewbidpage.isSubmissionDateFieldDisplayed()) {
			test.log(Status.PASS, "Submission Date Field is Displayed");
		} else {
			test.log(Status.FAIL, "Submission Date Field is NOT Displayed");
		}
		if (createnewbidpage.isSubmissionDateFieldEnabled()) {
			test.log(Status.PASS, "Submission Date Field is Enabled");
		} else {
			test.log(Status.FAIL, "Submission Date Field is NOT Enabled");
		}

		if (createnewbidpage.isSensitivityLevelDropDownDisplayed()) {
			test.log(Status.PASS, "Sensitivity Level DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Sensitivity Level DropDown is NOT Displayed");
		}
		if (createnewbidpage.isSensitivityLevelDropDownEnabled()) {
			test.log(Status.PASS, "Sensitivity Level DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Sensitivity Level DropDown is NOT Enabled");
		}

		if (createnewbidpage.isNotesTextDisplayed()) {
			test.log(Status.PASS, "Notes Text is Displayed");
		} else {
			test.log(Status.FAIL, "Notes Text is NOT Displayed");
		}
		if (createnewbidpage.isNotesTextEnabled()) {
			test.log(Status.PASS, "Notes Text is Enabled");
		} else {
			test.log(Status.FAIL, "Notes Text is NOT Enabled");
		}

		if (createnewbidpage.isSecurityClearanceRequirementsTextDisplayed()) {
			test.log(Status.PASS, "Security Clearance Requirements Text is Displayed");
		} else {
			test.log(Status.FAIL, "Security Clearance Requirements Text is NOT Displayed");
		}
		if (createnewbidpage.isSecurityClearanceRequirementsTextEnabled()) {
			test.log(Status.PASS, "Security Clearance Requirements Text is Enabled");
		} else {
			test.log(Status.FAIL, "Security Clearance Requirements Text is NOT Enabled");
		}

		if (createnewbidpage.isSubmissionInstructionsTextDisplayed()) {
			test.log(Status.PASS, "Submission Instructions Text is Displayed");
		} else {
			test.log(Status.FAIL, "Submission Instructions Text is NOT Displayed");
		}
		if (createnewbidpage.isSubmissionInstructionsTextEnabled()) {
			test.log(Status.PASS, "Submission Instructions Text is Enabled");
		} else {
			test.log(Status.FAIL, "Submission Instructions Text is NOT Enabled");
		}

		if (createnewbidpage.isSaveButtonDisplayed()) {
			test.log(Status.PASS, "Save Button is Displayed");
		} else {
			test.log(Status.FAIL, "Save Button is NOT Displayed");
		}
		if (createnewbidpage.isSaveButtonEnabled()) {
			test.log(Status.PASS, "Save Button is Enabled");
		} else {
			test.log(Status.FAIL, "Save Button is NOT Enabled");
		}

		if (createnewbidpage.isCancelButtonDisplayed()) {
			test.log(Status.PASS, "Cancel Button is Displayed");
		} else {
			test.log(Status.FAIL, "Cancel Button is NOT Displayed");
		}
		if (createnewbidpage.isCancelButtonEnabled()) {
			test.log(Status.PASS, "Cancel Button is Enabled");
		} else {
			test.log(Status.FAIL, "Cancel Button is NOT Enabled");
		}

		sa.assertTrue(createnewbidpage.isNameTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isNameTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidTitleTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isBidTitleTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isClientNameTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isClientNameTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidEventTypeDropDownBoxDisplayed());
		sa.assertTrue(createnewbidpage.isBidEventTypeDropDownBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidManagerDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isBidManagerDropDownEnabled());
		
		sa.assertTrue(createnewbidpage.isSalesLeadDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isSalesLeadDropDownEnabled());
		
		sa.assertTrue(createnewbidpage.isSubmissionDateFieldDisplayed());
		sa.assertTrue(createnewbidpage.isSubmissionDateFieldEnabled());

		sa.assertTrue(createnewbidpage.isSensitivityLevelDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isSensitivityLevelDropDownEnabled());

		sa.assertTrue(createnewbidpage.isNotesTextDisplayed());
		sa.assertTrue(createnewbidpage.isNotesTextEnabled());

		sa.assertTrue(createnewbidpage.isSecurityClearanceRequirementsTextDisplayed());
		sa.assertTrue(createnewbidpage.isSecurityClearanceRequirementsTextEnabled());

		sa.assertTrue(createnewbidpage.isSubmissionInstructionsTextDisplayed());
		sa.assertTrue(createnewbidpage.isSubmissionInstructionsTextEnabled());

		sa.assertTrue(createnewbidpage.isCRMIDTextDisplayed());
		sa.assertTrue(createnewbidpage.isCRMIDTextEnabled());
		
		sa.assertTrue(createnewbidpage.isSaveButtonDisplayed());
		sa.assertTrue(createnewbidpage.isSaveButtonEnabled());

		sa.assertTrue(createnewbidpage.isCancelButtonDisplayed());
		sa.assertTrue(createnewbidpage.isCancelButtonEnabled());

		rep.flush();
		sa.assertAll();

	}

}
