package com.qa.testCases;

import org.testng.annotations.Test;

import com.qa.pageObjects.orangeHRM_Login_PageFunction;
import com.qa.pageObjects.orangeHRM_PIM_PageFunction;
import com.qa.pageObjects.orangeHRM_addEmployee_PageFunction;
import com.qa.utilities.Base;

public class orangeHRM_addEmployee extends Base{
	
	// This test case will add a new employee in the OrangeHRM application and verify if the employee is added successfully.
	// Steps:
	// 1. Login to the application
	// 2. Navigate to PIM module
	// 3. Click on Add Employee button
	// 4. Enter employee details and save
	// 5. Verify if the employee is added successfully by checking the employee list
	
	@Test
	public void addEmployeeTest() throws InterruptedException {
		// Step 1: Login to the application
		orangeHRM_Login_PageFunction loginPage = new orangeHRM_Login_PageFunction(driver);
		loginPage.enterUsername(System.getProperty("orangeHRMUsername"));
		loginPage.enterPassword(System.getProperty("orangeHRMPassword"));
		loginPage.clickSubmit();
		
		// Step 2: Navigate to PIM module
		orangeHRM_PIM_PageFunction pimPage = new orangeHRM_PIM_PageFunction(driver);
		pimPage.clickAddEmployee();
		
		// Step 3: Click on Add Employee button
		orangeHRM_addEmployee_PageFunction addEmployeePage = new orangeHRM_addEmployee_PageFunction(driver);
		
		// Step 4: Enter employee details and save
		addEmployeePage.enterFirstName("John");
		addEmployeePage.enterLastName("Doe");
		addEmployeePage.clickSave();
		
		// Step 5: Verify if the employee is added successfully by checking the employee list
		pimPage.clickEmployeeList();
		pimPage.verifyNewEmployeeDetailsInList("Doe");
		
	}

}
