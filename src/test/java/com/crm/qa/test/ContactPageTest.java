package com.crm.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utiles.Utiles;

public class ContactPageTest extends TestBase {
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
		utiles.swithToFrame();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		cp=hp.onClickContacts();
		
		
	}
	@DataProvider
	public Object[][] getCrmtestdata()
	{
		Object data[][]=Utiles.getTestData(sheetname);
		return data;
	}
	@Test(dataProvider="getCrmtestdata")
	public void newcontact(String title,String firstname,String lastname) {
		cp.onClickNewContact();
		cp.createnewContact(title,firstname,lastname);
		cp.onClickNewContact();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
