package com.qa.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunctions {
	WebDriver driver;
	public commonFunctions(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public void scrollInto(int pixelNumber) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, "+pixelNumber+")", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}
	
	public void scrollByVisibleText(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement ele=driver.findElement(By.xpath("//*[contains(text(),'Please provide your own email and mobile number at the time of registration.')]"));
		js.executeScript("arguments[0].scrollIntoView()", xpath);
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}
	
	public void clickByxpath(String xpath) {
		WebElement ele=driver.findElement(By.xpath(xpath));
		ele.click();
		logPassInReport("Clicked on element with xpath: " + xpath);
	}
	
	public void sendKeysByXpath(String xpath, String value) {
		WebElement ele=driver.findElement(By.xpath(xpath));
		ele.sendKeys(value);
	}
	
	public WebElement waitForElementToBeClickable(String xpath, int time) {
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(time)); //declaration
		return mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public WebElement waitForElementToBeVisible(String xpath, int time) {
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(time)); //declaration
		return mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public WebElement fluentWaitForElement(String xpath, int timeout, int pollingTime) {
		Wait<WebDriver> mywait = new WebDriverWait(driver,Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(Exception.class);
		
		return mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void logPassInReport(String message) {
		System.out.println("PASS: " + message);
	}

}
