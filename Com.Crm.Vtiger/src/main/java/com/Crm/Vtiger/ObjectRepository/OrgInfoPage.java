package com.Crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	@FindBy(css=".dvHeaderText") private WebElement orgHeaderText;
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public String organisationInfo() {
		return orgHeaderText.getText();
	}

}
