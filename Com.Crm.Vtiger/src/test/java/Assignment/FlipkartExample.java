package Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FlipkartExample {
public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[contains(@class,'_2doB4z')]")).click();
		
		WebElement electronics= driver.findElement(By.xpath("//div[text()='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(electronics).perform();
		
		WebElement gaming=driver.findElement(By.xpath("//a[text()='Gaming']"));
		act.moveToElement(gaming).click().perform();
		
		driver.findElement(By.linkText("Gamepads")).click();
		
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		driver.findElement(By.xpath("//a[contains(@title,'Gonsgadapp Pubg Controller')]")).click();	

		/*Set<String> allId=driver.getWindowHandle();
		for(String id:mainId) {
			if() {
				
			}*/
		}
		
		
}

