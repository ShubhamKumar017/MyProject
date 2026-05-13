package com.qa.locators;

import org.openqa.selenium.WebDriver;

import com.qa.pageObjects.commonFunctions;

public class orangeHRM__LoginPage_Locators extends commonFunctions {
	
	public orangeHRM__LoginPage_Locators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String username_xpath = "//input[@name='username']";
	private String password_xpath = "//input[@name='password']";
	private String submitButton_xpath = "//button[@type='submit']";
	
	public String getUsername() {
		return username_xpath;
	}
	
	public String getPassword() {
		return password_xpath;
	}
	
	public String getSubmitButton() {
		return submitButton_xpath;
	}
	
	public void setUsername(String username_xpath) {
		this.username_xpath = username_xpath;
	}
	
	public void setPassword(String password_xpath) {
		this.password_xpath = password_xpath;
	}
	
	public void setSubmitButton(String submitButton_xpath) {
		this.submitButton_xpath = submitButton_xpath;
	}

}
