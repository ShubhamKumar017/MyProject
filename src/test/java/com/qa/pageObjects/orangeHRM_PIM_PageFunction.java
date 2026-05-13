package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;

import com.qa.locators.orangeHRM_PIM_Page_Locators;

public class orangeHRM_PIM_PageFunction extends orangeHRM_PIM_Page_Locators{

	public orangeHRM_PIM_PageFunction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickEmployeeList() {
		waitForElementToBeClickable(getEmployeeList(), 10).click();
		
	}
	
	public void clickAddEmployee() {
		waitForElementToBeClickable(getAddEmployee(), 10).click();
	}
	
	public void clickReports() {
		waitForElementToBeClickable(getReports(), 10).click();
	}
	
	public void clickConfiguration() {
		waitForElementToBeClickable(getConfiguration(), 10).click();
	}
	
	public void verifyNewEmployeeDetailsInList(String employeeName) {
		String employee = "//div[contains(text(),'"+employeeName+"')]"; 
		waitForElementToBeVisible(employee, 10).isDisplayed();
		if(waitForElementToBeVisible(employee, 10).isDisplayed()) {
			System.out.println("Employee details are displayed in the list");
		}
		else {
			System.out.println("Employee details are not displayed in the list");
		}
	}
}
