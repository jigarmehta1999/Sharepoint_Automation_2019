package com.sharepoint.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sharepoint.qa.base.TestBase;
import com.sharepoint.webdriver.WebConnnector;

//import com.sharepoint.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@title='Bid List']")
	WebElement BidListMenu;

	@FindBy(className = "CommandBarItem-commandText")
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
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(BidListMenu));

		// Fluent wait
		// Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30,
		// TimeUnit.SECONDS).pollingEvery(1,
		// TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		try {
			BidListMenu.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickNew() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(CommandBarItems.get(3)));
		} catch (TimeoutException excep) {
			excep.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < CommandBarItems.size(); i++) {
			System.out.println("i = " + i + " text = " + CommandBarItems.get(i).getText());
			if(CommandBarItems.get(i).getText().trim().equals("New")) {
				CommandBarItems.get(i).click();
			}
		}
	}

	public void clickCreateNewBidButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(CreateNewBid));
		try {
			CreateNewBid.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToCreateNewBidFrame() {
		driver.switchTo().frame(CreateNewBidFrame);
	}

	public String getPageTitle() {
		return (driver.getTitle().trim());
	}
}
