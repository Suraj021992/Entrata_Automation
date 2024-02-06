package pages.watchDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uniqueFunctionForEntrata.CommonActions;

public class WatchDemoFormPage {
	
	By watchDemoHeaderButton = By.xpath("//a[contains(@class,'button-default solid-dark-button') and text()='Watch Demo']");
	
	By firstName = By.xpath("//input[@id='FirstName']");
	
	By lastName = By.xpath("//input[@id='LastName']");
	
	By emailAddress = By.cssSelector("input#Email");
	
	By companyName = By.cssSelector("input#Company");
	
	By phoneNumber = By.cssSelector("input#Phone");
	
	By unitCount = By.cssSelector("select#Unit_Count__c");
	
	By jobTitle = By.cssSelector("input#Title");
	
	By WatchDemoSubmitButton = By.xpath("//button[@type='submit']");
	
	By entrataLogoOnWatchDemoPage = By.id("mkto_gen_Header_Logo");
	

	public void clickOnWatchDemoButton(WebDriver driver)
	{
		CommonActions.waitForLoadingElement(driver, watchDemoHeaderButton);
		CommonActions.clickOnElement(driver, driver.findElement(watchDemoHeaderButton));
	}
	
	public boolean verifyEmailInputBox(WebDriver driver)
	{
		CommonActions.waitForLoadingElement(driver, entrataLogoOnWatchDemoPage);
		return CommonActions.verifyTextAreaRedBorder(driver, driver.findElement(emailAddress), "wrongemail id");
	}
	
	public boolean verifyPhoneNumberInputBox(WebDriver driver)
	{
		return CommonActions.verifyTextAreaRedBorder(driver, driver.findElement(phoneNumber), "Phone number");
	}	
	
	public boolean FillTheForm(WebDriver driver)
	{
		CommonActions.waitForLoadingElement(driver, By.id("mkto_gen_Header_Logo"));
		CommonActions.sendKey(driver, driver.findElement(firstName), "test first name");
		CommonActions.sendKey(driver, driver.findElement(lastName), "test last name");
		CommonActions.sendKey(driver, driver.findElement(emailAddress), "abc@entrata.com");
		CommonActions.sendKey(driver, driver.findElement(companyName), "Companay Name Pvt. Ltd.");
		CommonActions.sendKey(driver, driver.findElement(phoneNumber), "8329193140");
		CommonActions.selectByValue(driver, driver.findElement(unitCount), "11 - 100");
		CommonActions.sendKey(driver, driver.findElement(jobTitle), "Associate");
		if(driver.findElement(WatchDemoSubmitButton).isEnabled())
			return true;
		else 
			return false;
	}
	
	public void clickOnEntrata(WebDriver driver)
	{
		CommonActions.clickOnElement(driver, driver.findElement(entrataLogoOnWatchDemoPage));
	}
}
