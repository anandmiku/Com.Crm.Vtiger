package com.Crm.VTiger.OrganisationTest;

import org.testng.annotations.Test;

import com.Crm.Vtiger.GenericUtilities.ExcelFileUtility;
import com.Crm.Vtiger.GenericUtilities.JavaUtility;

public class CreateMultpleOrganisationTest{

	
	@Test(dataProvider="multipledata",dataProviderClass=ExcelFileUtility.class)
	public void createMultipleOrgNames(String name,String name1) {
			JavaUtility ju=new JavaUtility();
			int rnum=ju.getrandom();
			System.out.println(name+rnum+"-->"+name1+rnum);
	}
}

