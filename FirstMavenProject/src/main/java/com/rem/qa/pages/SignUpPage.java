package com.rem.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.rem.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	@FindBy(name = "email")
	WebElement enterEmail;
	
	@FindBy(name = "password")
	WebElement enterPassword;
	
	@FindBy(name = "passwordConfirm")
	WebElement enterConfirmPassword;
	
	@FindBy(name = "firstName")
	WebElement enterFirstName;
	
	@FindBy(name = "lastName")
	WebElement enterLastName;
	
	@FindBy(name = "newsletterCheck")
	WebElement newsletterButton;
	
	@FindBy(name ="privacyCheck")
	WebElement privacyCheck;
	
	@FindBy(xpath ="//a[text()='Privacy Statement']")
	WebElement privacyStatementLink;
	
	@FindBy(xpath = "//span[text()='Create Account']")
	WebElement createAccountButton;
	
	@FindBy(xpath = "//div[@class='modal__container']")
	WebElement privacyWarningBox;
	
	@FindBy(xpath = "//ul[@class='listH']/li[1]/ul/li/a")
	List<WebElement> HelpList; 
	
	@FindBy(xpath = "//ul[@class='listH']/li[2]/ul/li/a")
	List<WebElement> FollowUsList; 
	
	@FindBy(xpath = "//ul[@class='listH']/li[3]/ul/li/a")
	List<WebElement> CompanyList; 
	
	@FindBy(xpath = "//ul[@class='listH']/li[3]/ul/li/a")
	List<WebElement> PoliciesList; 
	
	
	public SignUpPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void submitCreateAccForm(String email, String password, String confirmPassword,String firstName, String lastName) throws InterruptedException 
	{
		
        enterEmail.sendKeys(email);
		enterPassword.sendKeys(password);
		enterConfirmPassword.sendKeys(confirmPassword);
		enterFirstName.sendKeys(firstName);
		enterLastName.sendKeys(lastName);
		
		//privacyCheck.click();
		
		Thread.sleep(2000);
		
		createAccountButton.click();
		createAccountButton.click();
		
		
		
	}
	
	public boolean validateWarningBox() {
		
		return privacyWarningBox.isDisplayed();
		
		
	}
	
	public int validateHelpList() {
		
		return HelpList.size();
	}
	
    public int validateFollowUsList() {
		
		return FollowUsList.size();
    }
    
 public int validateCompanyList() {
		
		return CompanyList.size();
    }
 
 public int validatePoliciesList() {
		
		return PoliciesList.size();
 }
	
	
	
	

}
