package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class LoginTest extends BaseTest{
	
	
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credentials.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credentials.properties");
	
	
	@Test(priority =1)
	public void validLoginTest() {
		
		MenuPage menu = new MenuPage(driver); //sa accesez obiectele din interiorul paginii
		LoginPage login = new LoginPage(driver);
				
		menu.navigateTo(menu.loginLink);
		login.loginInApp(user, "something wrong");		
		
		assertTrue(login.checkMsgIsDisplayed(login.successLoginMessage));
		login.logoutFromApp();
			
		
		}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		
		MenuPage menu = new MenuPage(driver); 
		LoginPage login = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		login.loginInApp(user, "123123123");	
	//	assertFalse(login.checkMsgIsDisplayed(login.successLoginMessage));
		assertTrue(login.checkMsgIsDisplayed(login.errorLoginMessage));
		
	}

}
