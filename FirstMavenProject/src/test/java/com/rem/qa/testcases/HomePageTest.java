package com.rem.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rem.qa.base.TestBase;
import com.rem.qa.pages.HomePage;
import com.rem.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	public HomePageTest()
	{	
	super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		intialize();
		homePage = new HomePage();
		 
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	@Test(priority =1)
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "ZARA Canada | SALE");
	}
	
	@Test (priority =2)
	public void zaraLogoTest() {
		boolean flag = homePage.validateZaralogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void loginPageButtonTest() {
		
	 loginPage = homePage.loginPageEnter();
		
	}
}
