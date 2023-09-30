package Vtiger.CreateContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Crm.Vtiger.GenericUtilities.ExcelFileUtility;
import com.Crm.Vtiger.GenericUtilities.FileUtility;
import com.Crm.Vtiger.GenericUtilities.JavaUtility;
import com.Crm.Vtiger.GenericUtilities.WebDriverUtility;
import com.Crm.Vtiger.ObjectRepository.HomePage;
import com.Crm.Vtiger.ObjectRepository.LoginPage;


public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		FileUtility futil = new FileUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		// jutil.getrandom();

		/*
		 * Random r=new Random(); int random=r.nextInt(1000);
		 */
		// string name="Dev"+random;

		ExcelFileUtility eutil = new ExcelFileUtility();
		String name = eutil.getDataFromExcel("TestData", 0, 0) + jutil.getrandom();
		String UN = futil.getDataFromPropertyFile("username");
		String PWD = futil.getDataFromPropertyFile("password");
		String URL = futil.getDataFromPropertyFile("url");
		String BROWSER = futil.getDataFromPropertyFile("browser");
		// runtime polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		// Random r = new Random();
		// int random = r.nextInt(1000);
		String LastName = "Patel" + jutil.getrandom();
		// WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wutil.maximize(driver);
		wutil.wait(driver);
		driver.get(URL);
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(UN);
		 * driver.findElement(By.name("user_password")).sendKeys(PWD);
		 * driver.findElement(By.id("submitButton")).click();
		 */

		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PWD);
		// driver.findElement(By.linkText("Contacts")).click();

		HomePage hp = new HomePage(driver);
		hp.clickContact();
		driver.findElement(By.xpath("//img[contains(@title,'Create Contact')]")).click();
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wutil.getScreenshot(driver, "name");
		String msg = driver.findElement(By.className("dvHeaderText")).getText();
		if (msg.contains(LastName)) {
			System.out.println("Test Case Pass");
		} else {
			System.out.println("Test Case Failed");
		}
		// logout
		/*
		 * WebElement logout=driver.findElement(By.xpath(
		 * "//img[@src='themes/softed/images/user.PNG']")); wutil.screenshot(logout,
		 * "Logoutbutton"); Actions act= new Actions(driver);
		 * act.moveToElement(logout).perform();
		 * driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 */

		hp.logoutFromApp(driver);
		driver.quit();
	}

}
