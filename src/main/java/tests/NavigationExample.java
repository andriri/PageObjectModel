package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class NavigationExample extends BaseTest {
	
	@Test
	public void navigationTest() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.navigate().to("https://keyfood.ro/");
		Thread.sleep(3000);
		driver.navigate().back(); //apasa butonul Back din pagina
		Thread.sleep(3000);
		driver.navigate().forward(); //apasa butonul Forward din pagina
		Thread.sleep(3000);
		driver.navigate().refresh(); //apasa butonul Refresh din pagina
		//Refresh se poate face si asa
		Actions action = new Actions(driver);
		action.sendKeys(Keys.F5).perform();
				
	}

}
