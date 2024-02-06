package url_Login_Process;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserInstance {
	
    public static WebDriver driver = null;
	
	static String url = "";
	
	public  static WebDriver getDriverInstance()
	{
		System.setProperty("webdriver.chrome.driver", "");
		System.setProperty("org.freemaker.loggerLibrary", "none");
		if(driver == null){
			
		ChromeOptions  options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("--no-sandbox");
		options.addArguments("start-maximized");
		options.addArguments("--disable-gpu");
		options.addArguments("--profile-directory=Default");
		
		LoggingPreferences logpref = new LoggingPreferences();
		logpref.enable(LogType.PERFORMANCE, Level.ALL);
		
		options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);
		
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);	
		options.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriverManager.chromedriver().setup();
		

		driver = new ChromeDriver(options);
		return driver;
	 }
	return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void browserClose() { driver.close(); driver = null; }
	 
	
	public static void browserQuit() {  driver.quit(); driver = null;  }

	
	
}
