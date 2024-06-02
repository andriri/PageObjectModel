package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericEvenPage {

	public WebDriver driver;
	
	
	public GenericEvenPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By mapLink = By.linkText("View larger map");
	public By iframe = By.tagName("iframe");
	
	
	public void openMap() {
		driver.switchTo().frame(driver.findElement(iframe));
		driver.findElement(mapLink).click();
	}
	
}