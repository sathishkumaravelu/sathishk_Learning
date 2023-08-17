package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1_Saleforce_CreateAccount {

	/*
	 * Requirement : 
	 * 1. Login to https://login.salesforce.com 
	 * Username:hari.radhakrishnan@qeagle.com Password :Leaf$1234 
	 * 2. Click on toggle menu button from the left corner 
	 * 3. Click view All and click Sales from App Launcher 
	 * 4. Click on Accounts tab 
	 * 5. Click on New button 
	 * 6. Enter 'your name' as account name 
	 * 7. Click save
	 * 
	 */
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Faker fakerObject = new Faker();
		String firstName = fakerObject.name().firstName();		
//		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement accountsElement = driver.findElement(By.xpath("//span[text()='Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(accountsElement));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",accountsElement);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//input[@class='slds-input' and @name='Name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String createdName = driver.findElement(By.xpath("//div[@data-aura-class='sfaOutputNameWithHierarchyIcon']//parent::lightning-formatted-text")).getText();
		System.out.println(createdName);
		if(createdName.equalsIgnoreCase(firstName)) {
			System.out.println("Test case : passed");
		}else {
			System.out.println("Test case : falied");
		}
	
		driver.quit();
	}
	

}
