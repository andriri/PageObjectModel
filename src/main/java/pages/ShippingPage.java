package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class ShippingPage {

	public By countryCanada = By.xpath("//span[@title='Canada']");
	public By provinceNL = By.xpath("//span[@title='Newfoundland and Labrador']");
	 
	
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
		
}
