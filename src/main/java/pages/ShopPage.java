package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ShopPage {
	
	//tine locatorii si metodele (functionalitati) din pagina respectiva
	//nu testeaza si NU se face assert in pages
	//scop: sa fie apelate in teste
	
	public WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori
	//identificam clasa de tip select
	public By orderDropdown = By.name("orderby"); //are tag name select
	
	
	//metode specifice functionalitatii din pagina respectiva
	public void filterByValue(String value) {
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
	}
	
	public void filerByIndex(int index) {
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
	}
	
	public void filterByVisibleText(String visibleText) {
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(visibleText);
	}
	
	public String getCurrentSelectedOption() {
		WebElement element = driver.findElement(orderDropdown);
		Select selectDropdown = new Select(element);
		return selectDropdown.getFirstSelectedOption().getText();
	}
}
