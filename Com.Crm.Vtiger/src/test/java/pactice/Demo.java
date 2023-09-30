package pactice;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
		//driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> allSuggestion = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
		//Thread.sleep(1000);
		for (WebElement sug : allSuggestion) {
			String sug1 = sug.getText();
			if (sug1.contains("iphone 14")) {
				sug.click();
				break;
			}

		}
		//Locatiing theIst product price..
		WebElement price = driver.findElement(By.xpath("//div[@cel_widget_id=\"MAIN-SEARCH_RESULTS-3\"]//span[@class=\"a-price-whole\"]"));
		System.out.println(price.getText());
	}

}
