package mandatoryHomeWork.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day4_Chatter_Tab {

	/*
	 * _Day_3 Assignment:_"Test Steps for Create Campaign: 1. Login to
	 * https://login.salesforce.com 2. Click on toggle menu button from the left
	 * corner 3. Click view All and click Sales from App Launcher 4. Click on
	 * Campaigns tab 5. Click on New button 6. Enter Campaign name as 'Bootcamp' 7.
	 * Choose Start date as Tomorrow 8. End date as Tomorrow+1 9. click Save and
	 * Verify the newly created Campaign"
	 * 
	 */

	public WebDriverWait wait;
	public ChromeDriver driver;

	@BeforeTest
	public void setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@Test
	public void createChatter() {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Chatter']"))));
		WebElement chatterEle = driver.findElement(By.xpath("//a[@title='Chatter']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", chatterEle);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Question']"))));
		String chatterTitle = driver.getTitle();
		System.out.println(chatterTitle);

		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']"))
				.sendKeys("sathish testing");
		driver.findElement(By.xpath("//div[@data-placeholder='If you have more to say, add details here...']"))
				.sendKeys("test");
		driver.findElement(By.xpath("//button[@title='Click, or press Ctrl+Enter']")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@data-aura-class='forceChatterFeedBodyQuestionWithoutAnswer'])[1]/span"))));
		
		String actualValue = driver.findElement(By.xpath("(//div[@data-aura-class='forceChatterFeedBodyQuestionWithoutAnswer'])[1]/span")).getText();

		Assert.assertEquals(actualValue, "sathish testing");
	}

	@AfterTest
	public void postSetup() {
		driver.quit();
	}

}
