package com.crm.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	SignUpPage sp;
	LoginPage lp;
	@BeforeMethod
	public void browserInitilaize()
	{
		initializtion();
		sp=new SignUpPage();
		lp=new LoginPage();
		lp.signupClick();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test
	public void signup()
	{
		sp.signUpClick();
	}
	@AfterMethod
	public void teardown() {
		//driver.close();
	}
}
