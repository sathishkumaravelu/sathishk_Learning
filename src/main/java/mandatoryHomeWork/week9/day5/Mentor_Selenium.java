package mandatoryHomeWork.week9.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mentor_Selenium {
	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.leafground.com/table.xhtml");
		String pageNo = driver.findElement(By.xpath("(//a[@class='ui-paginator-page ui-state-default ui-corner-all'])[last()]")).getText();
		int intPageNo = Integer.parseInt(pageNo);
		for(int i=1;i<=intPageNo;i++ ) {
		
		List<WebElement> findElements = driver
				.findElements(By.xpath("//*[@class='customer-badge status-new']/ancestor::tr//td[1]"));

		for (WebElement name : findElements) {
			String actualName = name.getText();
			System.out.println("Name :" + actualName);
		}

		List<WebElement> findElementsCountry = driver
				.findElements(By.xpath("//*[@class='customer-badge status-new']/ancestor::tr//td[2]"));

		for (WebElement findElementsCountryEle : findElementsCountry) {
			String actualCountry = findElementsCountryEle.getText();
			System.out.println("Country :" + actualCountry);
		}

		List<WebElement> findElementsJoiningDate = driver
				.findElements(By.xpath("//*[@class='customer-badge status-new']/ancestor::tr//td[4]"));

		for (WebElement findElementsDate : findElementsJoiningDate) {
			String actualCountry = findElementsDate.getText();
			System.out.println("Joining date :" + actualCountry);
		}
//		
//		boolean enabled = driver.findElement(By.xpath("//a[@aria-label='Next Page']")).isEnabled();
//		if(enabled) {
//			driver.findElement(By.xpath("//a[@aria-label='Next Page']")).click();
//		}
		}
	}
		
}
