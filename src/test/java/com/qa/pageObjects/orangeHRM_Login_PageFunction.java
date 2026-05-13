package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;

import com.qa.locators.orangeHRM__LoginPage_Locators;

public class orangeHRM_Login_PageFunction extends orangeHRM__LoginPage_Locators{
	WebDriver driver;
	
	public orangeHRM_Login_PageFunction (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void enterUsername(String username) throws InterruptedException {
		Thread.sleep(4000);
		waitForElementToBeVisible(getUsername(), 10).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		waitForElementToBeVisible(getPassword(), 10).sendKeys(password);
	}
	
	public void clickSubmit() {
		waitForElementToBeClickable(getSubmitButton(), 10).click();
	}

}
