package uniqueFunctionForEntrata;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonActions {
	
	static Actions act = null;
	
	static By cookies = By.cssSelector("button#rcc-confirm-button");
	
	public static String getPropertyValue(String filePath, String property) 
	   {	
		 File file = null;
		 
		 FileInputStream input = null;
		 
		 Properties prop = new Properties();
		 
		 String value = "";	 
		 try 
		 {
			file = new File(filePath);
			input = new FileInputStream(file);
			prop.load(input);
			input.close();
			value = prop.getProperty(property);
		 }
		 catch(FileNotFoundException io)
		  {
			io.printStackTrace();
		  }
		 catch(Exception e)
		  {
			 e.printStackTrace();
		  }	 
		 return value;
	   }
	
	public static WebElement SearchWebElement(WebDriver driver, WebElement ele) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementClickInterceptedException.class).ignoring(NoSuchElementException.class);

		WebElement Alert = wait.until(ExpectedConditions.visibilityOf(ele));

		return Alert;
	}
	
	public static WebElement waitForLoadingElement(WebDriver driver, By parent)
	{
		for(int i = 0; i < 10; i++)
		{
			try {
				WebElement DocumentParent = SearchWebElement(driver, driver.findElement(parent));
				if(DocumentParent.isDisplayed())
				{
					waitForElementVisible(driver, driver.findElement(parent), 25);
					return SearchWebElement(driver, driver.findElement(parent));
				}
			}
			catch (Exception e)
			{
				continue;
			}
		}
		return null;
	}
	
	public static void waitForElementVisible(WebDriver driver,WebElement ele, int waitTime)
	{
		new WebDriverWait(driver, Duration.ofSeconds(waitTime)).until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public static WebElement mouseHour(WebElement ele, WebDriver driver)
	{
		act = new Actions(driver);
		if(ele.isDisplayed()){
			act.moveToElement(ele).build().perform();
			return ele;
		}			
		return null;
	}
	
	public static void clickOnElement(WebDriver driver, WebElement ele) {
		try {
			ele.click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
		}
	}
	
	public static void verifyEntrataHomePage(WebDriver driver)
	{
		CommonActions.waitForLoadingElement(driver, By.xpath("//a[@title='Entrata Home Page']"));
		clickOnElement(driver, driver.findElement(By.xpath("//a[@title='Entrata Home Page']")));
	}
	
	public static void acceptCookies(WebDriver driver)
	{
		WebElement cookie = CommonActions.waitForLoadingElement(driver, cookies);
		if(cookie != null) {		
	      if(cookie.isDisplayed())
	    	clickOnElement(driver, driver.findElement(cookies));
		} 
	}
	
	public static void sendKey(WebDriver driver, WebElement ele, String value)
	{
		try {
			ele.sendKeys(value);
		}
		catch(Exception e)
		{
			 clickOnElement(driver,ele);
			 StringSelection selection = new StringSelection(value);
			 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			 clipboard.setContents(selection, null);
			 ele.sendKeys(Keys.chord(Keys.CONTROL,"V"));
		}
	}
	
	 public static void selectByValue(WebDriver driver, WebElement ele, String txt)
	 {
		 WebElement element = SearchWebElement(driver, ele);
		 Select select = new Select(element); 
		 select.selectByValue(txt);
	 }
	 
	 public static boolean verifyTextAreaRedBorder(WebDriver driver,WebElement ele,String value)
	  {
		 sendKey(driver, ele, value);
		 if(ele.getAttribute("aria-invalid").equals("true"))
			 return true;
		 return false;
	  }
	 
	 public static void scrolToElement(WebDriver driver, WebElement ele)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);",ele);	
	 }
}
