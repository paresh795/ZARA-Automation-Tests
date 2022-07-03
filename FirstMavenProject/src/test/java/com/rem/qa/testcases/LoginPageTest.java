package com.rem.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rem.qa.base.TestBase;
import com.rem.qa.pages.HomePage;
import com.rem.qa.pages.LoginPage;
import com.rem.qa.pages.SignUpPage;
import com.rem.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	SoftAssert sa;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialize();
		homePage = new HomePage();
		loginPage = new LoginPage();
		
		homePage.loginPageEnter();
		loginPage.closePopup();
		sa = new SoftAssert();
	}
	
	@Test (enabled = true)
	public  void validateLoginPageTitleTest() {
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "[ZARA Canada | SALE]");
	}
	
	
	@Test (enabled = true)
	public void loginTest() {
	
	homePage = loginPage.login();
	
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object data[][]=TestUtil.getTestData("Sheet2");
		return data;
		
		
	}
	
	@Test(dataProvider= "getLoginData",enabled = true)
	public void loginTest(String un, String pwd) {
		
	 loginPage.login(un,pwd);
	 sa.assertTrue(loginPage.sessionExpired());
	 sa.assertAll();
	 
	
		
	}
	
	@Test (enabled = true)
	public void createAccountTest() {
		signUpPage = loginPage.enterCreateNewAccount();
		
	}
	
	@Test (enabled = true)
	public void forgotPasswordTest() {
		loginPage.forgotPass();
		
		Assert.assertTrue(loginPage.forgotPass());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
