package naukari;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void testLogin() {
		LoginPage lp=new LoginPage(driver);
		nauakri_commonFunction cf=new nauakri_commonFunction(driver);
		cf.scrollInto(500);
		lp.clickLogin();
		lp.enterUsername("shubhamparth7739@gmail.com");
		lp.enterPassword("");
		lp.clickLoginButton();
		Assert.assertEquals(driver.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
		System.out.println("Title: "+driver.getTitle());
	}
	
	@AfterClass
	void teardown() {
		driver.quit();
	}

}
