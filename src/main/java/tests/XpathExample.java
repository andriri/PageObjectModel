package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.PropertiesFileProcessor;





public class XpathExample extends BaseTest{
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credentials.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credentials.properties");

	/*
	 * CSS
	/li[class='menu_user_login']
	
	   XPATH
	//li[@class='menu_user_login']
	
	*/
	
	@Test(priority = 1)
	public void XpathExampleTest() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	
		WebElement loginButton = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		
				
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:6px solid green;')", loginButton);
		loginButton.click();
		
		//OR
		// //input[@id='log' or @name='log']
		WebElement userField = driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:6px solid green;')", userField);
		
		userField.sendKeys(user);
		
		//AND
		WebElement passField = driver.findElement(By.xpath("//input[@type='password' and @name='pwd']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:6px solid green;')", passField);
		
		passField.sendKeys(pass);
		
		WebElement submitButton = driver.findElement(By.xpath("//div[@class='popup_form_field submit_field']/input"));
		
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:6px solid green;')", submitButton);
		
		submitButton.click();
		
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void xpathExample2() {
		
		driver.findElement(By.xpath("//span[@class='user_name']")).click();
		
		//text() ->referinta catre textul dintre tag-urile html
		driver.findElement(By.xpath("//a[text()='Settings']")).click();
		
	}
}
