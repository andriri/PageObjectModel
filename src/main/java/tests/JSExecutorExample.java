package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JSExecutorExample extends BaseTest {

	@Test
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//driver.get(url)
		//driver.navigate().to(url)
		//toate 3 comenzile fac acelasi lucru
		jse.executeScript("window.location='https//keyfood.ro'");
		
		//driver.navigate().back()
		jse.executeScript("window.history.go(-1)");
		
		//driver.navigate().forward()
		jse.executeScript("window.history.forward()");
		
		//1 - Metode de a face Refresh pe pagina
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		Actions action = new Actions(driver);
		action.sendKeys(Keys.F5).perform();
		//4
		driver.get(driver.getCurrentUrl());
		
	}
	
	@Test
	public void example2() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
	/*	WebElement searchIcon = driver.findElement(By.cssSelector("button[class*='icon-search']"));
		WebElement searchInput = driver.findElement(By.cssSelector("input[class='search_field']"));
		
			
		//alternativa pentru click()
		jse.executeScript("arguments[0].click()", searchIcon);
		
		//alternativa pentru sendKeys() - vreau sa scriu in interiorul lui
		jse.executeScript("arguments[0].value='cooking'", searchInput);
		
		//alternativa pentru click()
		jse.executeScript("arguments[0].click()", searchIcon);
		
		*/
		
		//alternativa pentru click()
		jse.executeScript("document.getElementsByClassName('icon-search')[0]");
		//alternativa pentru sendKeys()
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		//alternativa pentru click()
		jse.executeScript("document.getElementsByClassName('icon-search')[0]");
		
		//se mai poate scrie si in forma asta
		
	}
}
