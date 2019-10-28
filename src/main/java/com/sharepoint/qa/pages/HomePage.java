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

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a[@title='Bid List']")
	WebElement BidListMenu;
	
	@FindBy(className="CommandBarItem-commandText")
	List<WebElement> CommandBarItems;
	
	@FindBy(xpath = "//span[contains(text(),'Create New Bid')]")
	WebElement CreateNewBid;
	
//	@FindBy(xpath = "//a[@title='Create New Bid']")
//	WebElement CreateNewBid = driver.findElement(By.xpath((String) BidOperationsPageprop.get("CreateNewBid")));
	
	
	@FindBy(xpath = "//iframe[@class='ms-dlgFrame']")
	WebElement CreateNewBidFrame;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public void clickBidListMenu() throws InterruptedException {
		BidListMenu.click();
		Thread.sleep(10000);
	}
	
	public void clickNew() throws InterruptedException {
		for (int i = 0; i < CommandBarItems.size(); i++) {
			System.out.println(CommandBarItems.get(i).getText());
			if(CommandBarItems.get(i).getText().trim().equals("New")) {
				CommandBarItems.get(i).click();
			}
		}
		Thread.sleep(5000);
	}
	
	public void clickCreateNewBidButton() throws InterruptedException {
		CreateNewBid.click();
		Thread.sleep(20000);
	}
	
	public void switchToCreateNewBidFrame() {
		driver.switchTo().frame(CreateNewBidFrame);
	}
	
	public String getPageTitle() {
		return (driver.getTitle().trim());
	}
}
