package mandatoryHomeWork.week9.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mentor_Selenium_Optimized {
	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.leafground.com/table.xhtml");
		String pageNo = driver.findElement(By.xpath("(//a[@class='ui-paginator-page ui-state-default ui-corner-all'])[last()]")).getText();
		int intPageNo = Integer.parseInt(pageNo);
		
		  List<WebElement> rows = driver.findElements(By.xpath("//*[@class='customer-badge status-new']/ancestor::tr"));
		  for (WebElement row : rows) {
              // Find elements within the row
              WebElement nameElement = row.findElement(By.xpath(".//td[1]"));
              WebElement countryElement = row.findElement(By.xpath(".//td[2]"));
              WebElement joiningDateElement = row.findElement(By.xpath(".//td[4]"));

              // Get text from elements
              String name = nameElement.getText();
              String country = countryElement.getText();
              String joiningDate = joiningDateElement.getText();

              // Print the data in the desired order
              System.out.println("Name: " + name);
              System.out.println("Country: " + country);
              System.out.println("Joining date: " + joiningDate);
          }
		
		}
	}
		
