package baseClass;


import org.testng.annotations.BeforeTest;

import uniqueFunctionForEntrata.CommonActions;
import url_Login_Process.BrowserInstance;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	 
	public WebDriver driver = null;
	
	public static final String url = CommonActions.getPropertyValue("configuration.properties", "url");
	
   @BeforeTest
   public void beforeTest() {
	  driver = BrowserInstance.getDriverInstance();
	  driver.get(url);
	  CommonActions.verifyEntrataHomePage(driver);
	  CommonActions.acceptCookies(driver);
  }

  @AfterSuite
  public void afterSuite() {
	  BrowserInstance.browserQuit();
  }
  
}
