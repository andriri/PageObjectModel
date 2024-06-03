package tests;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class CookiesLogin  extends BaseTest{
	
	
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credentials.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credentials.properties");
	Set<Cookie> cookies;
	
	
	@Test(priority =1)
	public void validLoginTest() {
		
		MenuPage menu = new MenuPage(driver); //sa accesez obiectele din interiorul paginii
		LoginPage login = new LoginPage(driver);
				
		menu.navigateTo(menu.loginLink);
		login.loginInApp(user, pass);		
		
		assertTrue(login.checkMsgIsDisplayed(login.successLoginMessage));
		cookies = driver.manage().getCookies();
							
	}
	
	@Test (priority =2)
	public void cookiesLogin() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		
		for(Cookie cook : cookies) {
			driver.manage().addCookie(cook);
			
		}
		
		Thread.sleep(3000);
		menu.navigateTo(menu.contactsLink);
		
	}

}
