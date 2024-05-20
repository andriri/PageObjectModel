package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class Homework19SelectDropdown extends BaseTest {
	
	@BeforeClass
	public void setup() {
		
		WebDriver driver; 
		driver = new ChromeDriver();
		driver.get("https://keybooks.ro"); 
		driver.manage().window().maximize(); 
	
	//navigate to LoginPage 
	@Test(priority = 1)	
	public class LoginPage {
		
		public WebDriver driver;
			
		public LoginPage(WebDriver driver) {
				this.driver = driver;
			}
		
		WebElement loginButton = driver.findElement(By.linkText("Login"));
	//	WebElement loginButton = driver.findElement(By.cssSelector("li[class='menu_user_login']"));
		loginButton.click();
		WebElement loginOrEmail = driver.findElement(By.id("log"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.cssSelector("input[class='submit_button']"));
		
//	    public By usernameField = By.id("username");
//	    public By passwordField = By.id("password");
//	    public By loginButton = By.name("login");
	  
 
	    driver.findElement(loginOrEmail).sendKeys("TestUser");
	    driver.findElement(password).sendKeys("12345@67890");
	    driver.findElement(submitButton).click();
	    
	
	   JavascriptExecutor jse = (JavascriptExecutor) driver;
	

	
	//navigate to Shipping address page
	@Test(priority = 2)	
	    driver.get("https://keybooks.ro/account/edit-address/shipping/");
		public class ShippingAddressPage {
	    private WebDriver driver;
	    private By countryDropdown = By.id("shipping_country");
	    private By regionDropdown = By.id("shipping_state");

	    public ShippingAddressPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectCountryByIndex(int index) {
	        WebElement countryElement = driver.findElement(countryDropdown);
	        Select countrySelect = new Select(countryElement);
	        countrySelect.selectByIndex(index);
	        Assert.assertEquals(countrySelect.getFirstSelectedOption().getText(), "Canada");
	    }

	    public void selectProvinceByValue(String value) {
	        WebElement regionElement = driver.findElement(regionDropdown);
	        Select regionSelect = new Select(regionElement);
	        regionSelect.selectByValue(value);
	        Assert.assertEquals(regionSelect.getFirstSelectedOption().getText(), "Newfoundland and Labrador");
	    }
	}

		// This is the test class that will run our test
		
		public class ShippingAddressTest extends BaseTest {
	    @Test
	    public void testEditShippingAddress() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("TestUser", "12345@67890");

	        driver.get("https://keybooks.ro/account/edit-address/shipping/");
	        ShippingAddressPage shippingAddressPage = new ShippingAddressPage(driver);
	        shippingAddressPage.selectCountryByIndex(38); // Indexul pentru Canada
	        shippingAddressPage.selectRegionByValue("NL"); // Valoarea pentru Newfoundland and Labrador
	    }
	
}

}
