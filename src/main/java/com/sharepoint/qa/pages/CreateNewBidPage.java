package com.sharepoint.qa.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sharepoint.qa.base.TestBase;
import com.sharepoint.webdriver.WebConnnector;

//import com.sharepoint.qa.base.TestBase;

public class CreateNewBidPage extends TestBase {

//	WebConnnector con;

	@FindBy(xpath = "//input[@title='Name Required Field']")
	WebElement Name;

	@FindBy(xpath = "//input[@title='Bid Title']")
	WebElement BidTitle;

	@FindBy(xpath = "//input[@title='Client Name Required Field']")
	WebElement ClientName;

	@FindBy(xpath = "//select[@title='Bid Event Type Required Field']")
	WebElement BidEventType;

	@FindBy(xpath = "//select[@id='DropdownNr1']")
	WebElement BidManager;

	@FindBy(xpath = "//select[@id='DropdownNr2']")
	WebElement SalesLead;

	@FindBy(xpath = "//input[@title='Submission Date Required Field']")
	WebElement SubmissonDate;

	@FindBy(xpath = "//select[@title='Sensitivity level Required Field']")
	WebElement SensitivityLevel;

	@FindBy(xpath = "//textarea[@title='Notes']")
	WebElement Notes;

	@FindBy(xpath = "//textarea[@title='Security clearance requirements Required Field']")
	WebElement SecurityClearanceRequirements;

	@FindBy(xpath = "//textarea[@title='Submission instructions Required Field']")
	WebElement SubmissionInstructions;

	@FindBy(xpath = "//input[@title='CRM ID']")
	WebElement CRMID;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement Save;

	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement Cancel;

	@FindBy(xpath = "//td[@valign='top']/../td[3]")
	List<WebElement> FinalBidValues;

//	driver.findElement(By.xpath("//input[@title='Name Required Field']")).sendKeys("Name1");
//	driver.findElement(By.xpath("//input[@title='Bid Title']")).sendKeys("Bid Title 1");
//	driver.findElement(By.xpath("//input[@title='Client Name Required Field']")).sendKeys("Client Name 1");

//	Select bideventtype = new Select(driver.findElement(By.xpath("//select[@title='Bid Event Type Required Field']")));
//	bideventtype.selectByVisibleText("BAFO");

//	Select bidmanager = new Select(driver.findElement(By.xpath("//select[@id='DropdownNr1']")));
//	bidmanager.selectByVisibleText("Charlotte Scott");

//	Select saleslead = new Select(driver.findElement(By.xpath("//select[@id='DropdownNr2']")));
//	saleslead.selectByVisibleText("Alan Campbell");

//	driver.findElement(By.xpath("//input[@title='Submission Date Required Field']")).sendKeys("25/09/2019");;

//	Select sensitivitylevel = new Select(driver.findElement(By.xpath("//select[@title='Sensitivity level Required Field']")));
//	sensitivitylevel.selectByVisibleText("Restricted Access");

//	driver.findElement(By.xpath("//textarea[@title='Notes']")).sendKeys("Notes 1");

//	driver.findElement(By.xpath("//textarea[@title='Security clearance requirements Required Field']")).sendKeys("Security clearance requirements 1");

//	driver.findElement(By.xpath("//textarea[@title='Submission instructions Required Field']")).sendKeys("Submission instructions 1");

//	driver.findElement(By.xpath("//input[@title='CRM ID']")).sendKeys("CRMID1 ");

	public CreateNewBidPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isNameTextBoxDisplayed() {
		return (Name.isDisplayed());
	}

	public boolean isNameTextBoxEnabled() {
		return (Name.isEnabled());
	}

	public boolean isBidTitleTextBoxDisplayed() {
		return (BidTitle.isDisplayed());
	}

	public boolean isBidTitleTextBoxEnabled() {
		return (BidTitle.isEnabled());
	}

	public boolean isClientNameTextBoxDisplayed() {
		return (ClientName.isDisplayed());
	}

	public boolean isClientNameTextBoxEnabled() {
		return (ClientName.isEnabled());
	}

	public boolean isBidEventTypeDropDownBoxDisplayed() {
		return (BidEventType.isDisplayed());
	}

	public boolean isBidEventTypeDropDownBoxEnabled() {
		return (BidEventType.isEnabled());
	}

	public boolean isBidManagerDropDownDisplayed() {
		return (BidManager.isDisplayed());
	}

	public boolean isBidManagerDropDownEnabled() {
		return (BidManager.isEnabled());
	}

	public boolean isSalesLeadDropDownDisplayed() {
		return (SalesLead.isDisplayed());
	}

	public boolean isSalesLeadDropDownEnabled() {
		return (SalesLead.isEnabled());
	}

	public boolean isSubmissionDateFieldDisplayed() {
		return (SubmissonDate.isDisplayed());
	}

	public boolean isSubmissionDateFieldEnabled() {
		return (SubmissonDate.isEnabled());
	}

	public boolean isSensitivityLevelDropDownDisplayed() {
		return (SensitivityLevel.isDisplayed());
	}

	public boolean isSensitivityLevelDropDownEnabled() {
		return (SensitivityLevel.isEnabled());
	}

	public boolean isNotesTextDisplayed() {
		return (Notes.isDisplayed());
	}

	public boolean isNotesTextEnabled() {
		return (Notes.isEnabled());
	}

	public boolean isSecurityClearanceRequirementsTextDisplayed() {
		return (SecurityClearanceRequirements.isDisplayed());
	}

	public boolean isSecurityClearanceRequirementsTextEnabled() {
		return (SecurityClearanceRequirements.isEnabled());
	}

	public boolean isSubmissionInstructionsTextDisplayed() {
		return (SubmissionInstructions.isDisplayed());
	}

	public boolean isSubmissionInstructionsTextEnabled() {
		return (SubmissionInstructions.isEnabled());
	}

	public boolean isCRMIDTextDisplayed() {
		return (CRMID.isDisplayed());
	}

	public boolean isCRMIDTextEnabled() {
		return (CRMID.isEnabled());
	}

	public boolean isSaveButtonDisplayed() {
		return (Save.isDisplayed());
	}

	public boolean isSaveButtonEnabled() {
		return (Save.isEnabled());
	}

	public boolean isCancelButtonDisplayed() {
		return (Cancel.isDisplayed());
	}

	public boolean isCancelButtonEnabled() {
		return (Cancel.isEnabled());
	}

	public void clickSaveButton() {
		try {
			Save.click();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}

	public void clickCancelButton() {
		Cancel.click();
	}

	public void setName(String Name) throws InterruptedException {
		this.Name.sendKeys(Name);
		Thread.sleep(2000);
	}

	public void setBidTitle(String BidTitle) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("BidTitle before typing = " + BidTitle);
		for (int i = 0; i < BidTitle.length(); i++) {
			char ch = BidTitle.charAt(i);
			this.BidTitle.sendKeys(String.valueOf(ch));
			Thread.sleep(500);
		}
//		this.BidTitle.sendKeys(BidTitle);
//		Thread.sleep(2000);
	}

	public void setClientName(String ClientName) throws InterruptedException {
		for (int i = 0; i < ClientName.length(); i++) {
			char ch = ClientName.charAt(i);
			this.ClientName.sendKeys(String.valueOf(ch));
			Thread.sleep(500);
		}
//		this.ClientName.sendKeys(ClientName);
//		Thread.sleep(2000);
	}

	public void setBidEventType(String BidEventType) throws InterruptedException {
		this.BidEventType.sendKeys(BidEventType);
		Thread.sleep(2000);
	}

	public void setBidManager(String BidManager) throws InterruptedException {
		Select bidmanager = new Select(this.BidManager);
		bidmanager.selectByVisibleText(BidManager);
		Thread.sleep(2000);
		// this.BidManager.sendKeys(BidManager);
	}

	public void setSalesLead(String SalesLead) throws InterruptedException {
		Select saleslead = new Select(this.SalesLead);
		saleslead.selectByVisibleText(SalesLead);
		// this.SalesLead.sendKeys(SalesLead);
		Thread.sleep(2000);
	}

	public String setSubmissonDate() throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String formattedLocalDate = dtf.format(now);
		this.SubmissonDate.sendKeys(formattedLocalDate);
		Thread.sleep(2000);
		return formattedLocalDate;
	}

	public void setSensitivityLevel(String SensitivityLevel) throws InterruptedException {
		Select senstivitylevel = new Select(this.SensitivityLevel);
		senstivitylevel.selectByVisibleText(SensitivityLevel);
		// this.SensitivityLevel.sendKeys(SensitivityLevel);
		Thread.sleep(2000);
	}

	public void setNotes(String Notes) throws InterruptedException {
		this.Notes.sendKeys(Notes);
		Thread.sleep(2000);
	}

	public void setSecurityClearanceRequirements(String SecurityClearanceRequirements) throws InterruptedException {
		this.SecurityClearanceRequirements.sendKeys(SecurityClearanceRequirements);
		Thread.sleep(2000);
	}

	public void setSubmissionInstructions(String SubmissionInstructions) throws InterruptedException {
		this.SubmissionInstructions.sendKeys(SubmissionInstructions);
		Thread.sleep(2000);
	}

	public String setNameandCRMID() throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String formattedLocalDateTime = dtf.format(now);
		this.CRMID.sendKeys(formattedLocalDateTime);
		this.Name.sendKeys(formattedLocalDateTime);
		Thread.sleep(2000);
		return formattedLocalDateTime;
	}
	
	public ArrayList<String> getFinalBidValues() {
		ArrayList<String> temp = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FinalBidValues.get(0)));
		
		for (int i = 0; i < FinalBidValues.size(); i++) {
			temp.add(FinalBidValues.get(i).getText());
		}
		return temp;
	}

}
