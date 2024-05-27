package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ShippingPage {
	
	public By billingCountry = By.xpath("//select[@name='shipping_country']");
    public By billingState = By.xpath("//select[@name='shipping_state']");
	 
	
	public WebDriver driver;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}
		
	public void filterByCountry(int countryIndex) {
		//Country dropdown list
		WebElement country = driver.findElement(By.xpath("//select[@name='shipping_country']"));
		Select selectDropdown = new Select(country);
		selectDropdown.selectByIndex(countryIndex);
		}
		

	public void filterByProvince(String provinceName) {
		//Province dropdown list
		WebElement province = driver.findElement(By.xpath("//select[@name='shipping_state']"));
		Select selectDropdown = new Select(province);
		selectDropdown.selectByValue(provinceName);
	}
	
	public String getCurrentSelectedOption(By locator) {
        WebElement element = driver.findElement(locator);
        Select selectDropdown = new Select(element);
        return selectDropdown.getFirstSelectedOption().getText();

   }
		
}
