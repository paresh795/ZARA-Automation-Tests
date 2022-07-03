package com.rem.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rem.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(linkText = "LOG IN")
	WebElement loginPageButton;
	
	@FindBy(xpath ="//a[contains(@class,'layout-logo')]")
	WebElement zaraLogo;
	
	@FindBy(linkText = "HELP")
	WebElement helpButton;
	
	@FindBy(linkText = "Search")
	WebElement search;
	
	@FindBy(xpath = "(//button[@class='slider-spot-universe-collection__button'])[6]")
	WebElement newButton;
	
	@FindBy(xpath = "(//button[@class='slider-spot-universe-collection__button'])[7]")
	WebElement basicsButton;
	
	@FindBy(xpath = "(//button[@class='slider-spot-universe-collection__button'])[8]")
	WebElement joinLifeButton;
	
	@FindBy(xpath = "(//button[@class='slider-spot-universe-collection__button'])[9]")
	WebElement zaraAthleticzButton;
	
	
	
	
	
	public  HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		
		return driver.getTitle();
	}
	public boolean validateZaralogo() {
		
		return zaraLogo.isDisplayed();
		
		
	}
	
	public LoginPage loginPageEnter() {
		
		loginPageButton.click();
		
		
		return new LoginPage();
				
				
	}

}
