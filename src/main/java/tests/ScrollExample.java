package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest{
	
	//@Test
	//scroll simplu
	public void scrollByAmountTest() {
				
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1500).perform();
	}
	
	
	//@Test
	//scroll pana la un anumit element - in pagina de About
	public void scrollToElement() {
		
		Actions action = new Actions(driver);
		WebElement signUpButton = driver.findElement(By.cssSelector("input[value='Sign up']"));
		
		action.scrollToElement(signUpButton).perform();
		action.moveToElement(signUpButton).perform();
		
	}
	
	@Test
	public void scrollTopAndDown() throws InterruptedException {
		
		Actions action = new Actions(driver);
		
		//am apasat END de pe tastatura
		action.sendKeys(Keys.END).perform();
		
		Thread.sleep(3000);
		
		//am apasat HOME de pe tastatura
		action.sendKeys(Keys.HOME).perform();
		
	}

}
