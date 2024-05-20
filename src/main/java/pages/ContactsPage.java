package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage {

	public WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public By name = By.xpath("//input[@name='your-name']"); //am identificat primul element Name
	
}
