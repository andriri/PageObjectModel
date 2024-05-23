package tests;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassExample2  extends BaseTest{
	
	@Test
	public void copyPasteTest() throws InterruptedException {
		
		//Discover Your Next Book - din Home
		WebElement discoverText = driver.findElement(By.tagName("em"));
		WebElement loginButton = driver.findElement(By.cssSelector("li[class='menu_user_login']"));
		WebElement userField = driver.findElement(By.id("log"));
		
		//getCurrent() - citeste platforma unde ruleaza (MAC, IOS, Android, Unix...)
		//facem un ternary pt a putea rula pe orice platforma fara a modifica codul
		Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;
		
		Actions action = new Actions(driver);
		
		//selecteaza textul "Discover" de la Discover Your Next Book" = CTRL+C
		//am facut cu SHIFT pt ca doar cu COPY -> punea un spatiu in plus dupa cuvant (la double click)
		action
		.moveToElement(discoverText)
		.doubleClick()
		.keyDown(Keys.SHIFT)
		.sendKeys(Keys.ARROW_LEFT)
		.keyUp(Keys.SHIFT)
		.perform();
		Thread.sleep(5000);
		
		//face CTRL+V
		action
		    .keyDown(cmdCtrl)
		    .sendKeys("c")
		    .keyUp(cmdCtrl)
		    .perform();
		
		//face click in login pt a stii unde sa copieze textul
		loginButton.click();
		userField.click();
		
		//face Paste la cuvantul Discover in Login
		action
	    .keyDown(cmdCtrl)
	    .sendKeys("v")
	    .keyUp(cmdCtrl)
	    .perform();
		
		Thread.sleep(5000);
		
		
	}

}
