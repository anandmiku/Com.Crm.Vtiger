package com.Crm.VTiger.OrganisationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Crm.Vtiger.GenericUtilities.BaseClass;
import com.Crm.Vtiger.GenericUtilities.ExcelFileUtility;
import com.Crm.Vtiger.GenericUtilities.JavaUtility;
import com.Crm.Vtiger.ObjectRepository.CreateNewOrgPage;
import com.Crm.Vtiger.ObjectRepository.HomePage;
import com.Crm.Vtiger.ObjectRepository.OrgInfoPage;
import com.Crm.Vtiger.ObjectRepository.OrganaisationPage;

public class CreateOrganaizationTest extends BaseClass {

	@Test(groups={"Regressionsuite","smokesuite"})
	public void verifyuserCreateOrganaisationTest() throws Throwable {
		//FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelFileUtility eu=new ExcelFileUtility();
		int rnum=ju.getrandom();
		String ActualOrgNmae=eu.getDataFromExcel("Sheet1", 1, 0)+rnum;
		//WebDriver driver =new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ipathconstant.implicitwaitDuration));
//		driver.get(fu.getDataFromProperty("url"));
//		
//		Loginpage lop=new Loginpage(driver);
//		lop.login(fu.getDataFromProperty("username"), fu.getDataFromProperty("password"));
		
//		driver.findElement(By.name("user_name")).sendKeys(fu.getDataFromProperty("username"));
//		driver.findElement(By.name("user_password")).sendKeys(fu.getDataFromProperty("password"));
//		driver.findElement(By.cssSelector("#submitButton")).click();
		HomePage hp=new HomePage(driver);
		hp.orgClick();
		
		OrganaisationPage orgpge=new OrganaisationPage(driver);
		orgpge.orgLookUp();
		
		CreateNewOrgPage cnorg=new CreateNewOrgPage(driver);
		cnorg.cretaeOrg(ActualOrgNmae);
		
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[contains(@title,'Cr')]")).click();
//		driver.findElement(By.name("accountname")).sendKeys(ActualOrgNmae);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String expectedOrg-Name=driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		OrgInfoPage orgInP=new OrgInfoPage(driver);
		String oggInfo=orgInP.organisationInfo();
		Assert.assertTrue(oggInfo.contains(ActualOrgNmae));
		System.out.println("pass");
		
//		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act=new Actions(driver);
//		act.moveToElement(wb).perform();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//hp.logoutFromApp(driver);
		
	}

}
