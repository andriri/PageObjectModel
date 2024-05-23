package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ShippingPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class dragAndDropAudioPost extends BaseTest{
	
	
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credentials.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credentials.properties");
	
	
	@Test(priority =1)
	public void goToAudioPost() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver); //sa accesez obiectele din interiorul paginii
		BlogPage blog = new BlogPage(driver);
		ShippingPage shipping = new ShippingPage(driver);
				
		menu.navigateTo(menu.loginLink);
		login.loginInApp(user, pass);		
		menu.hoverElement(menu.userName);
		menu.navigateTo(menu.settings);
		menu.navigateTo(menu.adresses);
		menu.navigateTo(menu.addAddress);
		shipping.filterByCountry(41);
		Thread.sleep(2000);
		WebElement countryElement = driver.findElement(shipping.countryCanada);
		Assert.assertEquals(countryElement.getText(), "Canada");
		shipping.filterByProvince("NL");
		Thread.sleep(2000);
		WebElement provinceText = driver.findElement(shipping.provinceNL);
		Assert.assertEquals(provinceText.getText(), "Newfoundland and Labrador");
	
		//login.logoutFromApp();
			
		
	}
	

}
