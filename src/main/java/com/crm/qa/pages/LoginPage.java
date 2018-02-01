package com.crm.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://www.freecrm.com/register/']") WebElement signup;
	@FindBy(xpath="//input[@name='username']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	@FindBy(xpath="//img[@class='img-responsive']") WebElement crmlogo;
	
	public SignUpPage signupClick() {
		signup.click();
		return new SignUpPage();
		
	}
	public Homepage loginClick(String usern,String pass) {
		username.sendKeys(usern);
		password.sendKeys(pass);
		login.click();
		return new Homepage();
	}
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public boolean validateCrmLogo() {
		return crmlogo.isDisplayed();
	}
}
