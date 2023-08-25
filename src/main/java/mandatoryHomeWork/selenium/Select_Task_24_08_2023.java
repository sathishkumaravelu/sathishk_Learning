package mandatoryHomeWork.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Task_24_08_2023 {

	public static void main(String[] args) {
		
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.leafground.com/select.xhtml");
		System.out.println("page loaded : "+driver.getTitle());
		
		WebElement favoriteselectEle = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		
		Select favSelectDD = new Select(favoriteselectEle);
		
		WebElement firstSelectedOption = favSelectDD.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
		
		List<WebElement> options = favSelectDD.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
		
		boolean isMultiple = favSelectDD.isMultiple();
		System.out.println(isMultiple);
		
		favSelectDD.selectByVisibleText("Selenium");
		
		
	}
	
}
