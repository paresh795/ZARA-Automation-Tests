package com.rem.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rem.qa.util.TestUtil;
import com.rem.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	@SuppressWarnings("deprecation")
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("C:\\Users\\15199\\Desktop\\QA\\Selenium_WorkSpace\\FirstMavenProject\\src\\main\\java\\com\\rem\\qa\\config\\config.properties");
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
 
public static void intialize() {
	String browsername =  prop.getProperty("browser");
	
	if(browsername.equals("chrome")) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\15199\\Desktop\\QA\\SeleniumJars\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	else if(browsername.equals("firefox")) 
	{
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\15199\\Desktop\\QA\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	
	//wait = new WebDriverWait(Duration.ofSeconds(20));
	
	driver.get(prop.getProperty("url"));
	 
}
 
 
 
 
}
