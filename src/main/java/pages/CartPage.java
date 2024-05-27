package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CartPage {
	
	public By increaseQuantity = By.xpath("//div[@class='quantity']//span[@class='q_inc']");
    public By updateCartButton = By.xpath("//button[@name='update_cart']");
    public By updateCartMessage = By.xpath("//div[@class='woocommerce-message']");
    public By proccedToCheckoutButton = By.xpath("//a[@class='checkout-button button alt wc-forward']");	
    public By billingDetails = By.xpath("//div[@class='woocommerce-billing-fields']//h3[contains(text(), 'Billing details')]");
    public By additionalInformation = By.xpath("//div[@class='woocommerce-additional-fields']//h3[contains(text(), 'Additional information')]");
    
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
		
	public void filterByCountry(int countryIndex) {
		//Country dropdown list
		WebElement country = driver.findElement(By.xpath("//select[@name='shipping_country']"));
		Select selectDropdown = new Select(country);
		selectDropdown.selectByIndex(countryIndex);
		}
		
}
