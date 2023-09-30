package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TokyoOlympic2020 {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https;//olympics.com/en/olympic-games/tokyo-2020/medals");
		WebElement country=driver.findElement(By.className("evgKXR"));
		System.out.println(country.getText());
	}

}
