package com.Crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//identifying webelements using Selenium annotations and declare as private
	@FindBy(name="user_name") private WebElement untext;
	@FindBy(name="user_password") private WebElement pwdtext;
	@FindBy(css="#submitButton") private WebElement loginbtn;
	
	//intialisation of elements 
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	// by using generic method we can access outside of the class
	public void login(String un,String pwd) {
		untext.sendKeys(un);
		pwdtext.sendKeys(pwd);
		loginbtn.click();
	}
}
