package com.rem.qa.pages;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.rem.qa.base.TestBase;
import com.rem.qa.util.TestUtil;

public class LoginPage extends TestBase {
	//WebDriverWait wait = new WebDriverWait(Duration.ofSeconds(20));
	
	@FindBy(name = "logonId")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(xpath ="//button[contains(@class,'button closed-for-sale-logon')]")
	WebElement loginButton;
	
	@FindBy(xpath ="//button[contains(@class,'button logon-view')]")
	WebElement ButtonForCreateAccountPage;
	
	@FindBy(xpath = "//a[contains(@class,'logon-view__forgot-password')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//div[@class='modal__container generic-error-modal ']")
	WebElement loginWarning;
	
	@FindBy(xpath="//button[@aria-label='Close']")
	WebElement closePopup;
	
	@FindBy(className = "main-content-header__info")
	WebElement sessionexp;
	
	
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
    public void closePopup() {
	//wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//wait.until(ExpectedConditions.elementToBeClickable(closePopup));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", closePopup);
	//closePopup.click();
		
	}
    
    public boolean sessionExpired() {
    	return sessionexp.isDisplayed();
    }
	

	
	public String verifyLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public HomePage login() {
		
		email.sendKeys(prop.getProperty("username"));
		pass.sendKeys(prop.getProperty("password"));
		loginButton.click();
		
		return new HomePage();
		
		
	}

	
	
	
	
   public void login(String un, String pwd) {
		
		email.sendKeys(un);
		pass.sendKeys(pwd);
		loginButton.click();
		
}		
	
	public SignUpPage enterCreateNewAccount() {
		
		ButtonForCreateAccountPage.click();
		
		return new SignUpPage();
		
	}
	
	public boolean forgotPass() {
		
	return	forgotPassword.isDisplayed();
		
	}
	
	public boolean loginWarning() {
		
		return loginWarning.isDisplayed();
	}
	
	
	
	
	
	
	

}
