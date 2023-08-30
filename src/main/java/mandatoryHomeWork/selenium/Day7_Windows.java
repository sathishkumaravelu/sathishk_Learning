package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day7_Windows {
	/*

Day_7

Assignment:

1. Launch Salesforce application https://login.salesforce.com/
2. Login with username as "hari.radhakrishnan@qeagle.com" 
    and password as "Leaf$1234"
3. Click on Learn More link in Mobile Publisher
4. Click on Confirm button
5. Get child window Title  
6. close the child window 
7. Get parent window Title 
8. close the parent window

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

		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();

	}

	@Test
	public void windowsLearning() {
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listWindows.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("New Child tab title: "+driver.getTitle());
		driver.switchTo().window(parentWindow);
		System.out.println("Parent tab title: "+driver.getTitle());
		driver.close();
		
	}

	@AfterTest
	public void postSetup() {
		//driver.quit();
	}

}
