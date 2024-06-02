package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage {

	public WebDriver driver;
	
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By name = By.xpath("//input[@name='your-name']");
	public By zoomInBtn = By.cssSelector("button[title='Zoom in']");
	public By zoomOutBtn = By.cssSelector("button[title='Zoom out']");
	public By iframe = By.tagName("iframe");
	
	
	
	public void zoomMap(By locator) {
		driver.findElement(locator).click();
	}
	
	
}