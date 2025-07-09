import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ignouadmission.samarth.edu.in/index.php/site/index");
		driver.manage().window().maximize();
		// Full page screenshot 
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\fullPage.png");
		sourceFile.renameTo(targetFile);
		
		// capture the specific section screenshot
		/*
		WebElement featureSection=driver.findElement(By.xpath("//*[@id='du-page-wrapper']/div/div/div[2]"));
		File sourceFile=featureSection.getScreenshotAs(OutputType.FILE);
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\specificSection.png");
		sourceFile.renameTo(targetFile);
		*/
		
		driver.quit();
	}

}
