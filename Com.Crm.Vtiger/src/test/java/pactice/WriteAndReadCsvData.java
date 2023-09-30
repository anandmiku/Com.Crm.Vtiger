package pactice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class WriteAndReadCsvData {

	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("./src/test/resources/NewFile.csv");
		CSVWriter csw = new CSVWriter(fw);

		String cell[] = new String[2];

		cell[0] = "admin";
		cell[1] = "password";
		csw.writeNext(cell);
		csw.flush();
		FileReader fr = new FileReader("./src/test/resources/NewFile.csv");
		CSVReader reader = new CSVReader(fr);
		while ((cell = reader.readNext()) != null) {
			String un = cell[0];
			String pw = cell[1];
			
		

			// open v tiger
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost:8888");
			driver.findElement(By.name("user_name")).sendKeys(un);
			driver.findElement(By.name("user_password")).sendKeys(pw);
			driver.findElement(By.cssSelector("#submitbutton")).click();
			
		
			
		}
	}
}
