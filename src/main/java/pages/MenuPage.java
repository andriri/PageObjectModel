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
	//public By blogLink = By.linkText("BLOG");
	public By eventsLink = By.linkText("EVENTS");
	public By blogLink = By.xpath("//a[@class='sf-with-ul'][contains(text(), 'Blog')]");
	public By userName = By.xpath("//span[@class='user_name']");
	public By settings = By.xpath("//a[@class='icon icon-cog']");
	public By adresses = By.xpath("//a[contains(text(), 'Addresses')]");
	public By addAddress = By.xpath("//a[@class='edit'][contains(text(), 'Add')]");
	public By searchButton = By.xpath("//button[@type='submit']");
	public By searchField = By.xpath("//input[@placeholder='Search']");
	
	//WebElement settings = driver.findElement(By.xpath("//a[@class='icon icon-cog']"));
	
	
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
	
	public void sendText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public void getText(By locator) {
		driver.findElement(locator).getText();
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
