package com.sharepoint.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sharepoint.qa.base.TestBase;
import com.sharepoint.webdriver.WebConnnector;

//import com.sharepoint.qa.base.TestBase;

public class BidOperationsPage extends TestBase{
	
	@FindBy(xpath = "//a[@title='Create New Bid']")
	WebElement CreateNewBid;
	
//	@FindBy(xpath = "//a[@title='Create New Bid']")
//	WebElement CreateNewBid = driver.findElement(By.xpath((String) BidOperationsPageprop.get("CreateNewBid")));
	
	
	@FindBy(xpath = "//iframe[@class='ms-dlgFrame']")
	WebElement CreateNewBidFrame;

	public BidOperationsPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void clickCreateNewBid() {
		CreateNewBid.click();
	}
	
	public void switchToCreateNewBidFrame() {
		driver.switchTo().frame(CreateNewBidFrame);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
