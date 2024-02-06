package baseClass;


import org.testng.annotations.BeforeTest;

import uniqueFunctionForEntrata.CommonActions;
import url_Login_Process.BrowserInstance;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	 
	public WebDriver driver = null;
	
	public static final String url = CommonActions.getPropertyValue("configuration.properties", "url");
	
	
   @BeforeSuite
   public void beforeSuite() {
	   }
	
 
   @BeforeTest
   public void beforeTest() {
	  driver = BrowserInstance.getDriverInstance();
	  driver.get(url);
	  CommonActions.verifyEntrataHomePage(driver);
	  CommonActions.acceptCookies(driver);
  }
  
  @AfterTest
  public void afterTest() {
  }

  @AfterSuite
  public void afterSuite() {
	  BrowserInstance.browserQuit();
  }
  
}
