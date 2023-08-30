package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day9_ExplicitWait {
	/*

		Selenium WebDriver

		Day_9:

		Step:1  Launch the browser and Load url
		https://www.leafground.com/window.xhtml
		Step:2 Click on the button Open with delay
             apply explicitWait->numberofWindowsTobe
		Step:3 Get the title of second window
		Step:4 Quit browser


	 */
	
	public WebDriverWait wait;
	public ChromeDriver driver;

	@BeforeMethod
	public void setUpMethod() {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		driver = new ChromeDriver(op);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.leafground.com/window.xhtml");


	}

	@Test
	public void windowsLearning() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Open with delay']/.."))).click();
		//wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<String>(windowHandles);
		System.out.println(driver.switchTo().window(listWindows.get(1)).getTitle());
	}

	@AfterTest
	public void postSetup() {
		driver.quit();
	}

}
