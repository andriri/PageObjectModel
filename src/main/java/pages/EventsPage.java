package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventsPage {

	public WebDriver driver;
	
	public EventsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By seminarEventLink = By.linkText("Seminar of Modern Art");
	
	
	public void clickOnEvent(By locator) {
		driver.findElement(locator).click();
	}
	
}