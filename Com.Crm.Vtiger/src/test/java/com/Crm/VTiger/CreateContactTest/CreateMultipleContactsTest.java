package com.Crm.VTiger.CreateContactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Crm.Vtiger.GenericUtilities.BaseClass;
import com.Crm.Vtiger.GenericUtilities.ExcelFileUtility;
import com.Crm.Vtiger.GenericUtilities.JavaUtility;
import com.Crm.Vtiger.ObjectRepository.ContactInfoPage;
import com.Crm.Vtiger.ObjectRepository.ContactsPage;
import com.Crm.Vtiger.ObjectRepository.CreateNewContactPage;
import com.Crm.Vtiger.ObjectRepository.HomePage;


public class CreateMultipleContactsTest extends BaseClass {

	    @Test(dataProvider="multipledata",dataProviderClass=ExcelFileUtility.class)
	    public void verifyUserCreateContactTest(String name) throws Throwable{
		//FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelFileUtility eu=new ExcelFileUtility();
		//WebDriverUtility wdu=new WebDriverUtility();
		int rnum=ju.getrandom();
		//String ActualOrgNmae=eu.getDataFromExcelSheet("Sheet1", 0, 0)+rnum;
		String ActualOrgNmae=name+rnum;
		//WebDriver driver =new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ipathconstant.implicitwaitDuration));
//		wdu.maximize(driver);
//		wdu.wait(driver);
//		
//		driver.get(fu.getDataFromProperty("url"));
		
//		driver.findElement(By.name("user_name")).sendKeys(fu.getDataFromProperty("username"));
//		driver.findElement(By.name("user_password")).sendKeys(fu.getDataFromProperty("password"));
//		driver.findElement(By.cssSelector("#submitButton")).click();
//		Loginpage lp=new Loginpage(driver);
//		lp.login(fu.getDataFromProperty("username"), fu.getDataFromProperty("password"));
		
		//driver.findElement(By.linkText("Contacts")).click();
		HomePage hp=new HomePage(driver);
		hp.clickContact();
		
		//driver.findElement(By.xpath("//img[contains(@title,'Cr')]")).click();
		ContactsPage cp=new ContactsPage(driver);
		cp.contactsClick();
		
//		driver.findElement(By.name("lastname")).sendKeys(ActualOrgNmae);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContactPage(ActualOrgNmae);
	
		//wdu.getScreenshot(driver, "verify1");
		
		//String expectedOrgName=driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		ContactInfoPage cinp=new ContactInfoPage(driver);
		String expectedOrgName=cinp.contcInfoPage();
		Assert.assertTrue(expectedOrgName.contains(ActualOrgNmae));
		System.out.println("pass");
		
//		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act=new Actions(driver);
//		act.moveToElement(wb).perform();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//hp.logoutFromApp(driver);
	  }

}






