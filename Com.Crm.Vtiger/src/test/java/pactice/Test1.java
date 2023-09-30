package pactice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new EdgeDriver();
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}

}
