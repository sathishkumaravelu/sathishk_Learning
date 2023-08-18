package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day2_CreateNewDashBoard {
	/*
	 * "Test Steps to Create New Dashboard: 
	 * 1. Login to https://login.salesforce.com
	 * Username :hari.radhakrishnan@qeagle.com Password :Leaf$1234 
	 * 2. Click on the toggle menu button from the left corner 
	 * 3. Click View All and click Dashboards from App Launcher 
	 * 4. Click on the New Dashboard option 
	 * 5. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
	 * 6.Click on Save.
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
	public void createDashboard() {

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement searchEle = driver.findElement(By.xpath("//input[@part='input']"));
		wait.until(ExpectedConditions.visibilityOf(searchEle));
		searchEle.sendKeys("dashboard");
		
		WebElement dashboardEle = driver.findElement(By.xpath("//a[@data-label='Dashboards']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",dashboardEle);
		
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Sathish");
		driver.findElement(By.id("submitBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}

	@AfterTest
	public void postSetup() {
		driver.quit();
	}

}
