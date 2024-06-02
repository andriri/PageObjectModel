package tests;

import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.MenuPage;
import utils.BaseTest;

public class IframeExample extends BaseTest {

	@Test
	public void iFrameExampleTest() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		ContactsPage contacts =  new ContactsPage(driver);
		
		menu.navigateTo(menu.contactsLink);
		//Thread.sleep(5000);
		
		//Facem switch catre DOM-ul din interiorul iframe-ului
		driver.switchTo().frame(driver.findElement(contacts.iframe));
		
		contacts.zoomMap(contacts.zoomInBtn);
		contacts.zoomMap(contacts.zoomInBtn);
		contacts.zoomMap(contacts.zoomInBtn);
		
		//facem switch inapoi catre DOM-ul principal
		driver.switchTo().defaultContent();
		
		driver.findElement(contacts.name).sendKeys("Harry Potter");
		
		//nu mai merge pentru ca am iesit din iframe. trebuie facut switch inapoi daca vreau
		//sa apas din nou pe butoane
		contacts.zoomMap(contacts.zoomOutBtn);
		
	}
	
	
}