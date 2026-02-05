package DemoPackage;

import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestNGListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //populate common info of the report -like tester name, browsername etc.
	public ExtentTest test; //creating test case entries in the report and update the status of the test methods
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "reports/myReport.html");  // location
																											// of the
																											// report
		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of the report
		sparkReporter.config().setReportName("Functional Testing"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK); // Theme

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Shubham Kumar");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Browser Name", "Chrome");
	}

	public void onTestStart(ITestResult result) {
		// not implemented
	}
	
	public void onTestSuccess(ITestResult result) {
	    test = extent.createTest(result.getName()); //create a new entry in the report
	    test.log(Status.PASS, "TestCase Passed is"+result.getName());  //update status pass
	  }
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName()); //create a new entry in the report
	    test.log(Status.FAIL, "TestCase Failed is"+result.getName());  //update status fail
	    test.log(Status.FAIL, "TestCase Failed cause is"+result.getThrowable());
	  }
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName()); //create a new entry in the report
	    test.log(Status.SKIP, "TestCase Skipped is"+result.getName());  //update status skip
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }

}
