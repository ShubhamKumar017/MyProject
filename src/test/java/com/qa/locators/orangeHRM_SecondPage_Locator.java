package com.qa.locators;

import org.openqa.selenium.WebDriver;

import com.qa.pageObjects.commonFunctions;

public class orangeHRM_SecondPage_Locator extends commonFunctions{
	
	public orangeHRM_SecondPage_Locator(WebDriver driver) {
		super(driver);
	}

	private String admin_xpath = "//span[text()='Admin']";
	private String pim_xpath = "//span[text()='PIM']";
	private String leave_xpath = "//span[text()='Leave']";
	private String time_xpath = "//span[text()='Time']";
	
	public String getAdmin() {
		return admin_xpath;
	}
	
	public String getPim() {
		return pim_xpath;
	}
	
	public String getLeave() {
		return leave_xpath;
	}
	
	public String getTime() {
		return time_xpath;
	}
	
	public void setAdmin(String admin_xpath) {
		this.admin_xpath = admin_xpath;
	}
	
	public void setPim(String pim_xpath) {
		this.pim_xpath = pim_xpath;
	}
	
	public void setLeave(String leave_xpath) {
		this.leave_xpath = leave_xpath;
	}
	
	public void setTime(String time_xpath) {
		this.time_xpath = time_xpath;
	}

}
