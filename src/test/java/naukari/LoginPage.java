package naukari;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	nauakri_commonFunction cf=new nauakri_commonFunction(driver);
	//locators
	By login_loc = By.xpath("//a[@id='login_Layer']");
	By Username_loc = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
	By Password_loc = By.xpath("//input[@placeholder='Enter your password']");
	By loginButton_loc = By.xpath("//button[@type='submit']");
	
	//Action Methods
	public void clickLogin(){
		//Explicit Wait
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); //declaration
		WebElement login = mywait.until(ExpectedConditions.elementToBeClickable(login_loc));
		login.click();
//		driver.findElement(login_loc).click();
	}
	
	public void enterUsername(String username){
		driver.findElement(Username_loc).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		// Fluent wait declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		WebElement passwordEnter = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(Password_loc);
			}
		});
		passwordEnter.sendKeys(password);
//		driver.findElement(Password_loc).sendKeys(password);
	}
	
	public void clickLoginButton(){
		driver.findElement(loginButton_loc).click();
	}
	
}
