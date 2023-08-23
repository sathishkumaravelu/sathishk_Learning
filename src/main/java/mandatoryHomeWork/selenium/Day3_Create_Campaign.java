package mandatoryHomeWork.selenium;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day3_Create_Campaign {

	/*
	 * _Day_3 Assignment:_"Test Steps for Create Campaign: 
	 * 1. Login to https://login.salesforce.com 
	 * 2. Click on toggle menu button from the left corner
	 * 3. Click view All and click Sales from App Launcher 
	 * 4. Click on Campaigns tab 
	 * 5. Click on New button 
	 * 6. Enter Campaign name as 'Bootcamp' 
	 * 7. Choose Start date as Tomorrow 
	 * 8. End date as Tomorrow+1 
	 * 9. click Save and Verify the newly created Campaign"
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

	}

	@Test
	public void createCampagine() {

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement campaignsEle = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", campaignsEle);

		driver.findElement(By.xpath("//div[text()='New']")).click();

		driver.findElement(By.xpath("//div[@class='uiInput uiInputText uiInput--default uiInput--input']/input"))
				.sendKeys("Sathish Bootcamp");

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement startCalanderEle = driver.findElement(By.xpath("(//div[@class='form-element'])[1]/input"));
		wait.until(ExpectedConditions.elementToBeClickable(startCalanderEle));
		startCalanderEle.click();

		/*
		 * String currentDateStr = driver .findElement(By.
		 * xpath("//td[contains(@class,'slds-is-today slds-is-selected')]/span")).
		 * getText();
		 * 
		 * int currentDateInt = Integer.parseInt(currentDateStr);
		 * System.out.println(currentDateInt);
		 */

		driver.findElement(By.xpath("//td[contains(@class,'slds-is-selected ')]/following::td[1]"))
				.click();
		
		WebElement endCalanderEle = driver.findElement(By.xpath("(//div[@class='form-element'])[2]/input"));
		wait.until(ExpectedConditions.elementToBeClickable(endCalanderEle));
		endCalanderEle.click();

		driver.findElement(By.xpath("//td[contains(@class,'slds-is-selected ')]/following::td[2]"))
				.click();
		
		WebElement saveEle = driver.findElement(By.xpath("//button[@title='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(saveEle)).click();
		
		try {
			WebElement createCampaignNameEle= driver.findElement(By.xpath("//div[@data-aura-class='sfaOutputNameWithHierarchyIcon']/lightning-formatted-text"));
			
			System.out.println(createCampaignNameEle.getText());
			Assert.assertTrue(createCampaignNameEle.getText().equalsIgnoreCase("Sathish Bootcamp"));
			
			
		} catch (NoSuchElementException e) {
			String errorText = driver.findElement(By.xpath("//span[@class='genericError uiOutputText']")).getText();
			Assert.assertEquals("Review the errors on this page.", errorText,"Error message not displayed ");
		}
		
	}
}
