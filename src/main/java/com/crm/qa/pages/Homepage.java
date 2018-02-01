package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase{
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[contains(text(),'raju kalagiri')]") WebElement homelogo;
	@FindBy(xpath="//a[@title='Deals']") WebElement deals;
	@FindBy(xpath="//a[@title='Contacts']") WebElement contacts;
	
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
}
