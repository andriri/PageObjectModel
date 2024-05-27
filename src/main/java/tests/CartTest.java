package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.BookSearchPage;
import pages.CartPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class CartTest extends OrderBookTest{
	
	

	String checkoutURL = PropertiesFileProcessor.readPropertiesFile("checkoutURL", "harcodedObjects.properties");
	//String bookToBeOrdered = PropertiesFileProcessor.readPropertiesFile("bookToBeOrdered", "harcodedObjects.properties");
	//String bookURL = PropertiesFileProcessor.readPropertiesFile("bookURL", "harcodedObjects.properties");
	//String cartURL = PropertiesFileProcessor.readPropertiesFile("cartURL", "harcodedObjects.properties");
	
	
	@Test
	public void cartTest() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		CartPage cart = new CartPage(driver);
/*		BookSearchPage search = new BookSearchPage(driver);
		

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
*/		
		Thread.sleep(5000);
		menu.navigateTo(cart.increaseQuantity);
		menu.navigateTo(cart.updateCartButton);
		String upadateCartMessage = driver.findElement(cart.updateCartMessage).getText();
		Assert.assertEquals(upadateCartMessage, "Cart updated.");
		menu.navigateTo(cart.proccedToCheckoutButton);
		String currentCheckoutURL = driver.getCurrentUrl();
		Assert.assertEquals(currentCheckoutURL, checkoutURL);
		boolean biilingDetails = driver.findElement(cart.billingDetails).isDisplayed();
		if (biilingDetails) { System.out.println("Billing Details information is displayed in Cart");
		}
		else { System.err.println("Billing Details information is NOT displayed in Cart");
        System.exit(1);
		}
		boolean addtionalInformation = driver.findElement(cart.additionalInformation).isDisplayed();
		if (addtionalInformation) { System.out.println("Additional Information section is displayed in Cart");
		}
		else { System.err.println("Additional Information section is NOT displayed in Cart");
        System.exit(1);
		}
	}
}
