package com.Crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaisationPage {
	@FindBy(xpath="//img[contains(@title,'Cr')]") private WebElement orgLookupIcon;

	public OrganaisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void orgLookUp() {
		orgLookupIcon.click();
	}
	
}
