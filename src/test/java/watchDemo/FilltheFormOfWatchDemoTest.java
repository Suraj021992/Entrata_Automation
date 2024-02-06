package watchDemo;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;
import pages.watchDemo.WatchDemoFormPage;


public class FilltheFormOfWatchDemoTest extends BaseClass{

	WatchDemoFormPage watchDemo = null;
	
	SoftAssert softAssert = null;
	
	@BeforeClass
	public void setUp()
	{
		Reporter.log("===== Verify the Form ======");
		watchDemo = new WatchDemoFormPage();
		softAssert = new SoftAssert();
	}
	
	@Test(priority = 0)
	public void verifyTheRedBorder()
	{
		watchDemo.clickOnWatchDemoButton(driver);
		softAssert.assertTrue(watchDemo.verifyEmailInputBox(driver),"Red Border is not present.");
		softAssert.assertTrue(watchDemo.verifyPhoneNumberInputBox(driver), "Red Border is not present.");
		softAssert.assertAll();	
	}
	
	@Test (priority = 1)
	public void fillFormForWatchDemo()
	{
		driver.navigate().refresh();
		softAssert.assertTrue(watchDemo.FillTheForm(driver),"Watch Demo Button is not enabled after entered the data");
		watchDemo.clickOnEntrata(driver);
		softAssert.assertAll();		
	}
}
