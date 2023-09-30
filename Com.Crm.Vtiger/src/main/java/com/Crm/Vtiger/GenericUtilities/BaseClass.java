package com.Crm.Vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Crm.Vtiger.ObjectRepository.HomePage;
import com.Crm.Vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public  static WebDriver listnerdriver;
	FileUtility fu=new FileUtility();
	WebDriverUtility wdu=new WebDriverUtility();
	@BeforeSuite
	public void beforeSuiteConfiguration() {
		System.out.println("create database conn");
	}
	@Parameters("browser")
	@BeforeClass
	public void launchBrowserConfig() throws Throwable {
		String browser=fu.getDataFromPropertyFile("browser");
		//RunTime polymorphism or method overriding
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			listnerdriver=driver;
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		wdu.maximize(driver);
		wdu.wait(driver);
	}
	@BeforeMethod
	public void loginAppConfig() throws Throwable {
		driver.get(fu.getDataFromPropertyFile("url"));
		LoginPage lp=new LoginPage(driver);
		lp.login(fu.getDataFromPropertyFile("username"),fu.getDataFromPropertyFile("password"));
	}
	@AfterMethod
	public void logoutAppConfig() {
		HomePage hp=new HomePage(driver);
		hp.logoutFromApp(driver);
	}
	@AfterClass
	public void closeBrowserConfig() {
		driver.quit();
	}
	@AfterSuite
	public void closeDatabaseConfig() {
		System.out.println("Close database conn");
	}
}










