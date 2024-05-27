package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest{
	
	//@Test
	//scroll simplu
	public void scrollByAmountTest() {
		//jseExecutor scroll
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1500)");
		
		//action class scroll
		Actions action = new Actions(driver);
		action.scrollByAmount(0,1500).perform();
	}
	
	
	//@Test
	//scroll pana la un anumit element - in pagina de About
	public void scrollToElement() {
		WebElement signUpButton = driver.findElement(By.cssSelector("input[value='Sign up']"));
		
		//jseExecutor scroll to element
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", signUpButton);
				
		//action class scroll to element
		Actions action = new Actions(driver);
				
		action.scrollToElement(signUpButton).perform();
		action.moveToElement(signUpButton).perform();
	}
	
	@Test
	public void scrollTopAndDown() throws InterruptedException {
		//jseExecutor scroll - face jos-sus de 4 ori
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//face scroll JOS
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		//face scroll SUS folosind "-"
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
		
		//action class scroll
		Actions action = new Actions(driver);
		//am apasat END de pe tastatura
		action.sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		//am apasat HOME de pe tastatura
		action.sendKeys(Keys.HOME).perform();
		
	}

}
