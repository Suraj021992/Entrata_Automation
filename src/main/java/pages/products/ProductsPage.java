package pages.products;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uniqueFunctionForEntrata.CommonActions;

public class ProductsPage {

	By products = By.cssSelector("div.main-nav-link");
	
	By products_links = By.cssSelector("div.fat-nav-grid>div>a");
	
	By entrataHomeIcon = By.xpath("//a[@title='Entrata Home Page']");
	
	By footer_grid = By.cssSelector("div.footer-nav-grid");
	
	ArrayList<String> links = null;
	
	public void MoveOnProducts(WebDriver driver)
	{
		CommonActions.waitForLoadingElement(driver, entrataHomeIcon);
		CommonActions.mouseHour(driver.findElement(products), driver);
	}
	
	public ArrayList<String> readLinkFromProducts(WebDriver driver)
	{
		links = new ArrayList<String>();
		driver.findElements(products_links).forEach(ele-> links.add(ele.getAttribute("href")));
		CommonActions.mouseHour(driver.findElement(entrataHomeIcon), driver);
		CommonActions.clickOnElement(driver, driver.findElement(entrataHomeIcon));
		return links;
	}
	
	public void scrollToFooter(WebDriver driver)
	{
		CommonActions.scrolToElement(driver, driver.findElement(footer_grid));
	}
}
