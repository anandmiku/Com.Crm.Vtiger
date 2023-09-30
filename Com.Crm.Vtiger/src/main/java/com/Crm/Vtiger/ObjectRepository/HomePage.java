package com.Crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Crm.Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	@FindBy(linkText="Organizations") private WebElement orglink;
	@FindBy(linkText="Contacts") private WebElement contactlink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement AdmistratorImg;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signoutbtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void orgClick() {
		orglink.click();
	}
	public void clickContact() {
		contactlink.click();
	}
	public void logoutFromApp(WebDriver driver) {
		moveToElement(driver,AdmistratorImg);
		signoutbtn.click();
	}
}
