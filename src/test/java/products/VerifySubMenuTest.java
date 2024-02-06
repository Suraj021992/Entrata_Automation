package products;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.products.ProductsPage;
import uniqueFunctionForEntrata.CommonActions;
import url_Login_Process.BrowserInstance;

public class VerifySubMenuTest extends BaseClass{
	
	ProductsPage product = null;
	
	@BeforeClass
	public void basicSetUp()
	{
		product = new ProductsPage();
		driver = BrowserInstance.getDriver();
	}
	
	@Test (priority = 2)
	public void readProductsMenu()
	{
		product.MoveOnProducts(driver);
		product.scrollToFooter(driver);
		CommonActions.sleep(2000);
	}
}
