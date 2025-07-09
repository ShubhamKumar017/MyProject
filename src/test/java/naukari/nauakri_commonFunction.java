package naukari;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class nauakri_commonFunction {
	WebDriver driver;
	
	public nauakri_commonFunction(WebDriver driver) {
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

}
