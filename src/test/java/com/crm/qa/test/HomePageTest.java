package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utiles.Utiles;

public class HomePageTest extends TestBase {
	LoginPage lp;
	Homepage hp;
	ContactPage cp;
	Utiles utiles;
	@BeforeMethod
	public void browserInitilaize()
	{
		initializtion();
		lp=new LoginPage();
		hp=lp.loginClick(prop.getProperty("username"), prop.getProperty("password"));
		utiles=new Utiles();
		
	}
	@Test
	public void logoValidation() {
		utiles.swithToFrame();
		Assert.assertTrue(hp.validatelogo());
		driver.close();
	}
	@Test
	public void clickcontact() {
		utiles.swithToFrame();
		cp=hp.onClickContacts();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		}

}
