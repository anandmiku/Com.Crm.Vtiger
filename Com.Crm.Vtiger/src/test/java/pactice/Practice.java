package pactice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
   public static void main(String[] args) throws IOException {
	ChromeDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https;//www.amazon.in/");
	FileInputStream fis=new FileInputStream("./src/test/resources/amazonall links.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Sheet1");
	List<WebElement>all= driver.findElements(By.xpath("//a"));
	for(int i=0;i<all.size();i++)
	{
		Row row=sh.getRow(i);
		Cell cell= row.getCell(0);
		cell.setCellValue(all.get(i).getAttribute("href"));
	}
	FileOutputStream fos=new FileOutputStream("./src/test/resources/amazonall links.xlsx");
	book.write(fos);
	book.close();
}
   
}
