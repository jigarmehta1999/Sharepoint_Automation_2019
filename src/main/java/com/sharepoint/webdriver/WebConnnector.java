package com.sharepoint.webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebConnnector {
	public String name;
	public WebDriver driver;
	public Properties prop;

	public WebConnnector() {
		System.out.println("Beginning of WebConnnector constructor");
		if (prop == null) {
			prop = new Properties();
			FileInputStream fs = null;
			try {
				fs = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\project.properties");
				prop.load(fs);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End of WebConnnector constructor");
	}

	public void openBrowser(String BrowserName) {
		System.out.println("Beginning of " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		if (prop.get(BrowserName).equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (prop.get(BrowserName).equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (prop.get(BrowserName).equals("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("End of " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	public void navigate(String url) {
		System.out.println("Beginning of " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get(prop.getProperty(url));
		System.out.println("End of " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	public void type(String username, String usernamefield) {
		if (usernamefield.endsWith("_id")) {
			driver.findElement(By.id(prop.getProperty(usernamefield))).sendKeys(username);
		} else if (usernamefield.endsWith("_xpath")) {
			driver.findElement(By.xpath(prop.getProperty(usernamefield))).sendKeys(username);
		}
	}
}
