import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollingPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ignouadmission.samarth.edu.in/index.php/site/index");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//1: scroll down page by pixel number 
		/*js.executeScript("window.scrollBy(0, 1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));*/
		
		//2: scroll page till element is visible
		WebElement ele=driver.findElement(By.xpath("//*[contains(text(),'Please provide your own email and mobile number at the time of registration.')]"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//3: scroll page till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll page up to initial page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		js.executeScript("document.body.style.zoom='40%'");
	}

}
