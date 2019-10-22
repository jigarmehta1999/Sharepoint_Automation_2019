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
import org.openqa.selenium.support.ui.Select;

import com.sharepoint.qa.base.TestBase;
import com.sharepoint.webdriver.WebConnnector;

//import com.sharepoint.qa.base.TestBase;

public class CreateNewBidPage extends TestBase{

//	WebConnnector con;
	
	@FindBy(xpath = "//*[@class='ms-standardheader']/nobr")
	List<WebElement> ListLabels;

	// Title value should be "New Document Set: Create New Bid"
	@FindBy(xpath="//h1[@id='dialogTitleSpan']")
	WebElement DialogTitle;

	@FindBy(xpath = "//input[@title='CRM ID Required Field']")
	WebElement CRMID;

	@FindBy(xpath = "//input[@title='Bid Title Required Field']")
	WebElement BidTitle;

	@FindBy(xpath = "//input[@title='Client Name Required Field']")
	WebElement ClientName;

	@FindBy(xpath = "//select[@title='Bid Event Type Required Field']")
	WebElement BidEventType;

	@FindBy(xpath = "//input[@title='Submission Date Required Field']")
	WebElement SubmissonDate;

	@FindBy(xpath = "(//span[@dir='none']/select)[2]")
	WebElement BidManager;

	@FindBy(xpath = "(//span[@dir='none']/select)[3]")
	WebElement SalesLead;

	@FindBy(xpath = "(//span[@dir='none']/select)[4]")
	WebElement SensitivityLevel;

	@FindBy(xpath = "//textarea[@title='Notes']")
	WebElement Notes;

	@FindBy(xpath = "//textarea[@title='Security clearance requirements Required Field']")
	WebElement SecurityClearanceRequirements;

	@FindBy(xpath = "//textarea[@title='Submission instructions Required Field']")
	WebElement SubmissionInstructions;

//	@FindBy(xpath = "//input[@value='OK']")
	@FindBy(css="input[value=OK]")
	WebElement OK;

	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement Cancel;
	
	@FindBy(xpath="//td[@valign='top']")
	List<WebElement> tdelements;
	
	@FindBy(xpath="(//img[@class='ms-dlgCloseBtnImg']/..)[2]")
	WebElement CloseButton;
	
	public void clickCloseButton() {
		CloseButton.click();
	}
	
	public CreateNewBidPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isCRMIDTextBoxDisplayed() {
		//return (CRMID.isDisplayed());
		return(driver.findElement(By.xpath("//input[@title='CRM ID Required Field']")).isDisplayed());
	}

	public boolean isCRMIDTextBoxEnabled() {
		//return (CRMID.isEnabled());
		return(driver.findElement(By.xpath("//input[@title='CRM ID Required Field']")).isEnabled());
	}

	public boolean isBidTitleTextBoxDisplayed() {
		//return (BidTitle.isDisplayed());
		return(driver.findElement(By.xpath("//input[@title='Bid Title Required Field']")).isDisplayed());
	}

	public boolean isBidTitleTextBoxEnabled() {
		//return (BidTitle.isEnabled());
		return(driver.findElement(By.xpath("//input[@title='Bid Title Required Field']")).isEnabled());
	}

	public boolean isClientNameTextBoxDisplayed() {
		//return (ClientName.isDisplayed());
		return(driver.findElement(By.xpath("//input[@title='Client Name Required Field']")).isDisplayed());
	}

	public boolean isClientNameTextBoxEnabled() {
		//return (ClientName.isEnabled());
		return(driver.findElement(By.xpath("//input[@title='Client Name Required Field']")).isEnabled());
	}

	public boolean isBidEventTypeTextBoxDisplayed() {
		return (BidEventType.isDisplayed());
	}

	public boolean isBidEventTypeTextBoxEnabled() {
		return (BidEventType.isEnabled());
	}

	public boolean isSubmissionDateFieldDisplayed() {
		return (SubmissonDate.isDisplayed());
	}

	public boolean isSubmissionDateFieldEnabled() {
		return (SubmissonDate.isEnabled());
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

	public boolean isOKButtonDisplayed() {
		return (OK.isDisplayed());
	}

	public boolean isOKButtonEnabled() {
		return (OK.isEnabled());
	}

	public boolean isCancelButtonDisplayed() {
		return (Cancel.isDisplayed());
	}

	public boolean isCancelButtonEnabled() {
		return (Cancel.isEnabled());
	}

	public void clickOKButton() {
		try {
			OK.click();
		} catch (StaleElementReferenceException  e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}
		
	}

	public void clickCancelButton() {
		Cancel.click();
	}

	public void setCRMIDText(String CRM_ID) throws InterruptedException {
		CRMID.sendKeys(CRM_ID);
		Thread.sleep(500);
	}

	public List<WebElement> getTdElements() {
		return tdelements;
	}
	
	public ArrayList<String> getCreateNewBidLabels() throws InterruptedException {
		ArrayList<String> arrayLabels = new ArrayList<String>();
		for (int i = 0; i < ListLabels.size(); i++) {
			arrayLabels.add(ListLabels.get(i).getText());
		}
		return arrayLabels;
	}

	public String setCRMID() throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();
		String formattedLocalDateTime = dtf.format(now);
		this.CRMID.sendKeys(formattedLocalDateTime);
		Thread.sleep(500);
		return formattedLocalDateTime;
	}

	public void setBidTitle(String BidTitle) throws InterruptedException {
		this.BidTitle.sendKeys(BidTitle);
		Thread.sleep(500);
	}

	public void setClientName(String ClientName) throws InterruptedException {
		this.ClientName.sendKeys(ClientName);
		Thread.sleep(500);
	}

	public void setBidEventType(String BidEventType) throws InterruptedException {
		this.BidEventType.sendKeys(BidEventType);
		Thread.sleep(500);
	}

	public String setSubmissonDate() throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();
		String formattedLocalDate = dtf.format(now);
		this.SubmissonDate.sendKeys(formattedLocalDate);
		Thread.sleep(500);
		return formattedLocalDate;
	}

	public void setBidManager(String BidManager) throws InterruptedException {
		Select bidmanager = new Select(this.BidManager);
		bidmanager.selectByVisibleText(BidManager);
		Thread.sleep(500);
		//this.BidManager.sendKeys(BidManager);
	}

	public void setSalesLead(String SalesLead) throws InterruptedException {
		Select saleslead = new Select(this.SalesLead);
		saleslead.selectByVisibleText(SalesLead);
	//	this.SalesLead.sendKeys(SalesLead);
		Thread.sleep(500);
	}

	public void setSensitivityLevel(String SensitivityLevel) throws InterruptedException {
		Select senstivitylevel = new Select(this.SensitivityLevel);
		senstivitylevel.selectByVisibleText(SensitivityLevel);
	//	this.SensitivityLevel.sendKeys(SensitivityLevel);
		Thread.sleep(500);
	}

	public void setNotes(String Notes) throws InterruptedException {
		this.Notes.sendKeys(Notes);
		Thread.sleep(500);
	}

	public void setSecurityClearanceRequirements(String SecurityClearanceRequirements) throws InterruptedException {
		this.SecurityClearanceRequirements.sendKeys(SecurityClearanceRequirements);
		Thread.sleep(500);
	}

	public void setSubmissionInstructions(String SubmissionInstructions) throws InterruptedException {
		this.SubmissionInstructions.sendKeys(SubmissionInstructions);
		Thread.sleep(500);
	}

	public String getDialogTitle() {
		//return(DialogTitle.getAttribute("title").trim());
		return(DialogTitle.getText().trim());
	}

}
