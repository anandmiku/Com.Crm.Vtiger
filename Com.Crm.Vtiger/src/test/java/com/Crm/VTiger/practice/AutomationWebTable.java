package com.Crm.VTiger.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationWebTable {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement>names=driver.findElements(By.xpath("(//div[@class='entry-content']/table/tbody/tr)[position()<=4]"));
		for(WebElement name:names) {
			System.out.println(name.getText());
		}
	}

}
