package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;

import com.qa.locators.orangeHRM_addEmployee_Locators;

public class orangeHRM_addEmployee_PageFunction extends orangeHRM_addEmployee_Locators{
	WebDriver driver;
	public orangeHRM_addEmployee_PageFunction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterFirstName(String firstName) {
		waitForElementToBeVisible(getFirstName(), 10).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		waitForElementToBeVisible(getLastName(), 10).sendKeys(lastName);
	}
	
	public void clickSave() {
		waitForElementToBeClickable(getSaveButton(), 10).click();
	}
	
	

	
	
	
}
