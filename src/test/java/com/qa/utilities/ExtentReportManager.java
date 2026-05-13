package com.qa.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info of the report -like tester name, browsername etc.
	public ExtentTest test; // creating test case entries in the report and update the status of the test methods

	String repName;

	public void onStart(ITestContext context) {
		
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); Date date
		 * = new Date(); String currentDateTimeStamp = sdf.format(date);
		 */

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+context + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + repName);// Specify the location of the report
//		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of the report
		sparkReporter.config().setReportName("Functional Testing"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK); // Theme

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Shubham Kumar");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Browser Name", "Chrome");
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // add method to the category mentioned in the testng.xml file
		test.log(Status.INFO, result.getMethod().getMethodName() + " started executing"); // log the start of test method execution
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // add method to the category mentioned in the testng.xml file
		test.log(Status.PASS, "TestCase Passed is" + result.getMethod().getMethodName()); // update status pass
//		test.log(Status.PASS, "TestCase Passed is" + result.getName()); // update status pass
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		test.log(Status.FAIL, "TestCase Failed is" + result.getName()); // update status fail
		test.log(Status.FAIL, "TestCase Failed cause is" + result.getThrowable().getMessage()); // update status fail with cause of failure
		try {
			String screenshotPath = new Base().captureScreenshot(result.getName()); // capture screenshot and get the path of the screenshot
			test.addScreenCaptureFromPath(screenshotPath); // attach screenshot to the report
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // add method to the category mentioned in the testng.xml file
		test.log(Status.SKIP, "TestCase Skipped is" + result.getName()); // update status skip
		test.log(Status.SKIP, "TestCase Skipped cause is" + result.getThrowable().getMessage()); // update status skip with cause of skip
	}

	public void onFinish(ITestContext context) {
		extent.flush(); // to write or update the report
		
		String reportPath = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport= new File(reportPath);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}