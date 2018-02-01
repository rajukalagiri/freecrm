package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
 public ContactPage() {
	PageFactory.initElements(driver, this);
}
 	@FindBy(xpath="//td[contains(text(),'raju kalagiri')]") WebElement homelogo;
	@FindBy(xpath="//a[@title='Deals']") WebElement deals;
	@FindBy(xpath="//a[@title='Contacts']") WebElement contacts;
	@FindBy(xpath="//a[@title='New Contact']") WebElement newcontact;
	@FindBy(xpath="//a[@title='Combined Form']") WebElement combinedForm;
	@FindBy(xpath="//select[@name='title' and @class='select']") WebElement seltitle;
	@FindBy(xpath="//input[@id='first_name']") WebElement firstname;
	@FindBy(xpath="//input[@id='surname']") WebElement lastname;
	@FindBy(xpath="//input[@value='Save' and @type='submit']") WebElement submit;
	
	public boolean validatelogo() {
		return homelogo.isDisplayed();
	}
	public ContactPage onClickContacts() {
		contacts.click();
		return new ContactPage();
		
	}
	public DealsPage onClickDeals() {
		deals.click();
		return new DealsPage();
		
	}
	public void onClickNewContact() {
		Actions a=new Actions(driver);
		a.moveToElement(contacts).perform();
		newcontact.click();
	}
	public void createnewContact(String title,String firstName,String lastName) {
		Select sel=new Select(seltitle);
		sel.selectByVisibleText(title);
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		submit.click();
		
	}
	
 
}
