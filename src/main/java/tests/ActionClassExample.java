package tests;

import org.testng.annotations.Test;

import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class ActionClassExample extends BaseTest {
	//extends BaseTest - pentru a avea acces la clasa driver
	
	//@Test
	public void hoverExample() throws InterruptedException {

		// am adaugat prima data metoda hoverElement in MenuPage pt a o putea refolosi
		
		MenuPage menu = new MenuPage(driver); //instanta a paginii de Menu pt a o putea accesa
		
		menu.hoverElement(menu.aboutLink);
		Thread.sleep(3000);
		menu.hoverElement(menu.blogLink);
		
	}

	@Test
	public void dragAndDropExample() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		ShopPage shop = new ShopPage(driver);
		shop.dragAndDrop(shop.sliderInitialPosition, 100, 0); //am tras 100 pixeli din stanga la dreapta
		shop.dragAndDrop(shop.sliderFinalPosition, -100, 0);  //am tras dinspre dreapta in stanga 100 pixeli
		
	}
}
