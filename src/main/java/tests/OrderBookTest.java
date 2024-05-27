package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.BookSearchPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class OrderBookTest extends BaseTest{
	
	String bookToBeOrdered = PropertiesFileProcessor.readPropertiesFile("bookToBeOrdered", "harcodedObjects.properties");
	String bookURL = PropertiesFileProcessor.readPropertiesFile("bookURL", "harcodedObjects.properties");
	String cartURL = PropertiesFileProcessor.readPropertiesFile("cartURL", "harcodedObjects.properties");
	
	@Test
	public void OrderBook() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		BookSearchPage search = new BookSearchPage(driver);
		

		menu.navigateTo(menu.searchButton);
		menu.sendText(menu.searchField, bookToBeOrdered+Keys.ENTER);
		Thread.sleep(2000);
		search.findBookByTitle(bookToBeOrdered);
		String currentBookURL = driver.getCurrentUrl();
		Assert.assertEquals(currentBookURL, bookURL);
		menu.navigateTo(search.addToCart);
		String addToCartMessage = driver.findElement(search.addToCartMessage).getText();
		Assert.assertEquals(addToCartMessage, "VIEW CART\n“The story about me” has been added to your cart.");
		menu.navigateTo(search.viewCart);
		String currentCartURL = driver.getCurrentUrl();
		Assert.assertEquals(currentCartURL, cartURL);
	}
}
