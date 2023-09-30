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


public class CreateContactTest extends BaseClass {
	    @Test
	    public void verifyUserCreateContactTest() throws Throwable{
	
		JavaUtility ju=new JavaUtility();
		ExcelFileUtility eu=new ExcelFileUtility();
	
		int rnum=ju.getrandom();
		String ActualOrgNmae=eu.getDataFromExcel("Sheet1", 0, 0)+rnum;
		
		HomePage hp=new HomePage(driver);
		hp.clickContact();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.contactsClick();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContactPage(ActualOrgNmae);
		
		ContactInfoPage cinp=new ContactInfoPage(driver);
		String expectedOrgName=cinp.contcInfoPage();
		Assert.assertTrue(expectedOrgName.contains(ActualOrgNmae));
		System.out.println("pass");
	  }

}
