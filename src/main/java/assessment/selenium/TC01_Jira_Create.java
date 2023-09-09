package assessment.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_Jira_Create {

	/*
	 * @author - Sathish Kumaravelu
	 * @TC Scope - Create a issue in jira
	 * 
	 * 1. URL : https://api-training.atlassian.net/
	 */
	
	
	public static ChromeDriver driver;
	public  WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		driver= new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://api-training.atlassian.net/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@testleaf.com",Keys.ENTER);
		driver.findElement(By.id("password")).sendKeys("India@123",Keys.ENTER);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//
	}
	
	@Test
	public void createTicket() {
		String SummaryData="Sathish Assessment Ticket";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='SDET-5']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("createGlobalItem"))).click();
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys(SummaryData);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Backlog']"))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@aria-label='Search backlog']"))));
		driver.findElement(By.xpath("//input[@aria-label='Search backlog']")).sendKeys(SummaryData,Keys.ENTER);
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//mark[text()='Sathish Assessment Ticket']"));
		act.moveToElement(ele).perform();
		boolean displayed = ele.isDisplayed();
		Assert.assertEquals(displayed, true);
	}
	
	@AfterMethod
	public void postsetup() {
		driver.close();
	}
}
