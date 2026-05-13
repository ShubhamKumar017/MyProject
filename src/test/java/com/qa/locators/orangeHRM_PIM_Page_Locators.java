package com.qa.locators;

import org.openqa.selenium.WebDriver;

import com.qa.pageObjects.commonFunctions;

public class orangeHRM_PIM_Page_Locators extends commonFunctions{
	
	public orangeHRM_PIM_Page_Locators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String addEmployee_xpath = "//a[text()='Add Employee']";
	private String employeeList_xpath = "//a[text()='Employee List']";
	private String reports_xpath = "//a[text()='Reports']";
	private String configuration_xpath = "//a[text()='Configuration']";
	
	public String getAddEmployee() {
		return addEmployee_xpath;
	}
	
	public String getEmployeeList() {
		return employeeList_xpath;
	}
	
	public String getReports() {
		return reports_xpath;
	}
	
	public String getConfiguration() {
		return configuration_xpath;
	}
	
	public void setAddEmployee(String addEmployee_xpath) {
		this.addEmployee_xpath = addEmployee_xpath;
	}
	
	public void setEmployeeList(String employeeList_xpath) {
		this.employeeList_xpath = employeeList_xpath;
	}
	
	public void setReports(String reports_xpath) {
		this.reports_xpath = reports_xpath;
	}
	
	public void setConfiguration(String configuration_xpath) {
		this.configuration_xpath = configuration_xpath;
	}

}
