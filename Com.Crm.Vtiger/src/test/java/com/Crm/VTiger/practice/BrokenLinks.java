package com.Crm.VTiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		
		List<WebElement>allLinks=driver.findElements(By.xpath("//a"));
		//create an empty arraylist for broken links
		List<String> brokenLinks=new ArrayList<String>();
		for(int i=0;i<allLinks.size();i++) {
			String links=allLinks.get(i).getAttribute("href");
			
			int statuscode=0;
			
			//create url
			try {
				URL url=new URL(links);
				URLConnection conn=url.openConnection();
				HttpURLConnection urlc=(HttpURLConnection)conn;
				statuscode=urlc.getResponseCode();
				if(statuscode>=400) {
					brokenLinks.add(links+" "+statuscode);
				}
				
			} catch (Exception e) {
				continue;
			}
			System.out.println(brokenLinks);
		}
		
		
		FileInputStream fis=new FileInputStream("C:\\Users\\kiran\\OneDrive\\Desktop\\Book.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		sh.createRow(4).createCell(1).setCellValue(brokenLinks.toString());
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\kiran\\OneDrive\\Desktop\\Book.xlsx");
		book.write(fos);
		fos.flush();
		
	}
}












