package com.qa.locators;

import org.openqa.selenium.WebDriver;

import com.qa.pageObjects.commonFunctions;

public class orangeHRM_addEmployee_Locators extends commonFunctions{
	
	public orangeHRM_addEmployee_Locators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String firstName_xpath = "//input[@name='firstName']";
	private String lastName_xpath = "//input[@name='lastName']";
	private String saveButton_xpath = "//button[@type='submit']";
	
	public String getFirstName() {
		return firstName_xpath;
	}
	
	public String getLastName() {
		return lastName_xpath;
	}
	
	public String getSaveButton() {
		return saveButton_xpath;
	}
	
	public void setFirstName(String firstName_xpath) {
		this.firstName_xpath = firstName_xpath;
	}
	
	public void setLastName(String lastName_xpath) {
		this.lastName_xpath = lastName_xpath;
	}
	
	public void setSaveButton(String saveButton_xpath) {
		this.saveButton_xpath = saveButton_xpath;
	}

}
