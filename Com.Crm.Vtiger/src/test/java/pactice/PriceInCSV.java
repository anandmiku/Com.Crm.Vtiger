package pactice;


import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.opencsv.CSVWriter;


public class PriceInCSV {
	public static void main(String[] args) throws IOException {
		
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
		
		driver.findElement(By.xpath("//a[text()='ROYAL SCOT GREY 1 Pair Breathing Finger Sleeve for PUBG...']")).click();
		//driver.findElement(By.xpath("//a[text()='AMKETTE Evo Gamepad Pro 4 Controller with Instant Play ...']")).click();
		//driver.findElement(By.xpath("//a[text()='Lenovo LOQ Core i7 13620H 13th Gen - (16 GB/512 GB SSD/...']")).click();
		String mainid=driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		
		for(String id:allid)
		{
			if(!(mainid.equals(id)))
			{
				driver.switchTo().window(id);
			}
		}
		
		WebElement price = driver.findElement(By.cssSelector("[class='_30jeq3 _16Jk6d']"));	
		
		String Price = price.getText();
		FileWriter fw =new  FileWriter("./src/test/resources/Practice.csv");
		CSVWriter csw=new CSVWriter(fw);
		String cell[]= new String[1];
		cell[0]=Price;
		
		
		csw.writeNext(cell);
		csw.flush();

	}

}
	
		
