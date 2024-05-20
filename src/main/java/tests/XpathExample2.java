package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample2 extends BaseTest{

	@Test
	public void xpathExample() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		//parent
		WebElement loginPopUp = driver.findElement
				(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", loginPopUp);
		
		Thread.sleep(2000);
		loginPopUp.click();
		
		//descendant
		WebElement user = driver.findElement
				(By.xpath("//ul[@id='menu_user']/descendant::input[@name='log']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", user);
		
		Thread.sleep(2000);
		user.sendKeys("Test");
		
		
		/*
		 * //ul[@id='menu_user']//input[@name='log']
		 * 
		 * //ul[@id='menu_user']/descendant::input[@name='log']
		 */
		
		
// --> //ul[@id='menu_user']/descendant::form[@name='login_form']/child::div[contains(@class, 'password_field')]/child::input
		
		//child- referinta catre un copil direct
		WebElement pass =  driver.findElement
				(By.xpath("//ul[@id='menu_user']/descendant::form[@name='login_form']/child::div[contains(@class, 'password_field')]/child::input"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", pass);
		
		Thread.sleep(2000);
		pass.sendKeys("Test");
		
		
		//following -sibling
		//  /input - am adaugat la sfarsit pt a identifica dora Remember me, nu si Forgot password
		WebElement rememberMe = driver.findElement(By.xpath("//ul//div[contains(@class, 'login_field')]/following-sibling::div[contains(@class, 'remember_field')]/input"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", rememberMe);
		
		Thread.sleep(2000);
		rememberMe.click();
		
		//preceding-sibling
		WebElement user2 = driver.findElement(By.xpath("//ul//div[contains(@class, 'submit_field')]/preceding-sibling::div[contains(@class, 'login_field')]"));
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: pink;border:6px solid red;')", user2);
		
		
		//following 
		 // ajuta sa COBOR pe arbore, Nu tine cont de relatia de mostenire, 
		//  //a[@href='tel:123-456-7890'] - pt numar telefon de la 'Free Call' in dreapta sus
		
		WebElement forgotLink = driver.findElement(By.xpath("//a[@href='tel:123-456-7890']/following::a[@class='forgot_password']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: pink;border:6px solid red;')", forgotLink);
		
		
		//preceding 
		// ajuta sa URC fara sa tina cont de relatie de mostenire
		
		//butonul Login dupa username si pass
		WebElement submitButton = driver.findElement(By.xpath("//div[@class='top_panel_middle']/preceding::input[@value='Login']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: pink;border:6px solid red;')", submitButton);
		
		Thread.sleep(2000);
		submitButton.click();
	}
	

	
	
}