package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuPage {
	
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	//driver.findElement(By.locator);
	
	public By loginLink = By.linkText("Login");
	public By contactsLink = By.linkText("CONTACTS");
	public By shopLink = By.linkText("BOOKS");
	public By aboutLink = By.linkText("ABOUT");
	public By blogLink = By.linkText("BLOG");
	
	
	
//	cum scriam inainte
	
//	public void navigateToLogin() {
//		driver.findElement(By.linkText("Login")).click();
//	}
	
	
//	public void navigateToContacts() {
//	driver.findElement(By.linkText("CONTACTS")).click();
//}

	//navigateTo - este functionalitatea paginii
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	//navigateTo(loginLink)
	//navigateTo(contactsLink)
	//navigateTo(shopLink)
	//navigateTo(blogLink)
	
	public void hoverElement(By locator) {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver); //clasa Action face actiuni in lant
   //   action.clickAndHold(element);
		action.moveToElement(element).perform(); //face HOVER
		//la sfarsit dupa toate actiunile punem .perform();  -- e cel care le executa de fapt
		
	}
}
