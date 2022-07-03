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

public class SignUpPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	SoftAssert sa;
	
	public SignUpPageTest() {
		super();
	}
	
  @DataProvider
  public Object[][] getSignUpData(){
	  Object data[][] = TestUtil.getTestData("Sheet1");
	  return data;
	  
  }
  
  @BeforeMethod
  public void setup() {
	  
	    intialize();
		homePage = new HomePage();
		loginPage = new LoginPage();
		signUpPage =new SignUpPage();
		
		homePage.loginPageEnter();
		loginPage.closePopup();
		loginPage.enterCreateNewAccount();
		
  }
	
  @Test (dataProvider = "getSignUpData")
  public void createAccount(String email, String password, String confirmPassword,String firstName, String lastName) throws InterruptedException {
	  
	  signUpPage.submitCreateAccForm(email, password, confirmPassword, firstName, lastName);
	 
	  Assert.assertTrue(signUpPage.validateWarningBox());

  }
  
  @Test
  public void ValidateHelpListSize() {
	  
	  Assert.assertEquals(signUpPage.validateHelpList(),10);
	  

  }
  
  @Test
  public void ValidateFollowUsListSize() {
	  
	  Assert.assertEquals(signUpPage.validateFollowUsList(),7);
	  

  }
  
  @Test
  public void ValidateCompanyListSize() {
	  
	  Assert.assertEquals(signUpPage.validateCompanyList(),5);
	  

  }
  
  @Test
  public void ValidatePoliciesListSize() {
	  
	  Assert.assertEquals(signUpPage.validatePoliciesList(),5);
	  

  }
  
  @AfterMethod
	void tearDown() {
		driver.quit();
	}
  
  
}

