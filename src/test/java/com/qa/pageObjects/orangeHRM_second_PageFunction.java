package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;

import com.qa.locators.orangeHRM_SecondPage_Locator;

public class orangeHRM_second_PageFunction extends orangeHRM_SecondPage_Locator{
	WebDriver driver;
	public orangeHRM_second_PageFunction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void adminTab() {
		waitForElementToBeClickable(getAdmin(), 10).click();
	}

}
