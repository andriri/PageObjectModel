package tests;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.ContactsPage;
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

	//@Test
	public void dragAndDropExample() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		ShopPage shop = new ShopPage(driver);
		shop.dragAndDrop(shop.sliderInitialPosition, 100, 0); //am tras 100 pixeli din stanga la dreapta
		shop.dragAndDrop(shop.sliderFinalPosition, -100, 0);  //am tras dinspre dreapta in stanga 100 pixeli
		
	}
	
	@Test
	public void sendKeysExample() {
		
		MenuPage menu = new MenuPage(driver); //pt a putea naviga
		menu.navigateTo(menu.contactsLink);
		
		ContactsPage contacs = new ContactsPage(driver);
		WebElement nameElement = driver.findElement(contacs.name);
		
		Actions action = new Actions(driver);
		
		action
		    .moveToElement(nameElement)
		    .click(nameElement)
		    .sendKeys("nume")
			.sendKeys(Keys.TAB, "email@email.com")
			.pause(Duration.ofSeconds(2))  //un fel de Thead sleep 2 sec
			.sendKeys(Keys.TAB, "My subject")
			.pause(Duration.ofSeconds(2))
			.sendKeys(Keys.TAB, "My message")
			.pause(Duration.ofSeconds(2))
			.sendKeys(Keys.TAB, Keys.ENTER)
			.pause(Duration.ofSeconds(2)) 
			.perform();
	}
}
