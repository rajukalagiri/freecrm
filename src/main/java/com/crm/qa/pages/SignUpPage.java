package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[@id='payment_plan_id']") 
	WebElement edition;
	@FindBy(xpath="//input[@name='first_name']") 
	WebElement fiestName;
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastname;
	@FindBy(xpath="//input[@name='email']") 
	WebElement email;
	@FindBy(xpath="//input[@name='email_confirm']") 
	WebElement emailConfirm;
	@FindBy(xpath="//input[@name='username']") 
	WebElement username;
	@FindBy(xpath="//input[@name='password']") 
	WebElement password;
	@FindBy(xpath="//input[@name='passwordconfirm']") 
	WebElement passwordconfirm;
	@FindBy(xpath="//input[@name='agreeTerms']") 
	WebElement agreeTerms;
	@FindBy(xpath="//div[@class='myButton']") 
	WebElement submit;
	public void signUpClick() {
		Select sel= new Select(edition);
		sel.selectByVisibleText("Free Edition");
		fiestName.sendKeys("raju");
		lastname.sendKeys("kalagiri");
		email.sendKeys("rajukalagiri@gmail.com");
		emailConfirm.sendKeys("rajukalagiri@gmail.com");
		username.sendKeys("rajukalagiri");
		password.sendKeys("Reddy@107326");
		passwordconfirm.sendKeys("Reddy@107326");
		agreeTerms.click();
		submit.click();
	}
	public String validatesignUppageTitle() {
		return driver.getTitle();
	}
	

}
