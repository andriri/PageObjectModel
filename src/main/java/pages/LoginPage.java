package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By userField = By.id("log");
	public By passField = By.id("password");
	public By submitButton = By.cssSelector("input[class='submit_button']");
	public By successLoginMessage = By.cssSelector("div[class*='sc_infobox_style_success']");
	public By errorLoginMessage = By.cssSelector("div[class*='sc_infobox_style_error']");
	public By logoutButton = By.linkText("Logout");
	public By closePopUpButton = By.className("popup_close");
	
	
	public void loginInApp(String user, String pass) {
		
		driver.findElement(userField).clear();
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).clear();
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(submitButton).click();
	}
	
	
	//verificam ca apare pop-up cu eroare sau succes
	public boolean checkMsgIsDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();
		
	}
		
	public void logoutFromApp() {
		
		driver.findElement(logoutButton).click();
	}
	
	public void closeLoginPopUp() {
		driver.findElement(closePopUpButton).click();
	}
}
