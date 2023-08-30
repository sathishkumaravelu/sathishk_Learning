package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day8_ActionClass {
	/*

		Day_8

		Assignment Based on Action Class
		=======================
		https://jqueryui.com/draggable
		https://jqueryui.com/droppable
		https://jqueryui.com/selectable 
	
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
	}

	//@Test
	public void draggable() {
		
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement dragableEle = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(dragableEle, 100, 0).perform();
	}

	//@Test
	public void dragAndDrop() {
		
		driver.get("https://jqueryui.com/Droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement dragableEle = driver.findElement(By.id("draggable"));
		WebElement droppableEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(dragableEle, droppableEle).perform();
	}

	
	

	@Test
	public void selectable() {
		driver.get("https://jqueryui.com/selectable");  
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement Item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement Item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement Item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(Item1).moveToElement(Item5).perform();
		
	}

	
	@AfterTest
	public void postSetup() {
		//driver.quit();
	}

}
