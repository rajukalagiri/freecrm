package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	Homepage homepage;
	
	@BeforeMethod
	public void browserInitilaize()
	{
		initializtion();
		lp=new LoginPage();
		
	}
	@Test
	public void titleValidation() {
		String title=lp.validatePageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		//driver.close();
	}
	@Test
	public void login() {
		homepage=lp.loginClick(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
