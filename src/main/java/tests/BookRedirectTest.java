package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MenuPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class BookRedirectTest extends BaseTest{
	
	MenuPage menu = new MenuPage(driver); 
	
//	driver.navigate().to("https://keyfood.ro/");
//	Thread.sleep(3000);

	  @DataProvider(name = "bookData")
	    public Object[][] bookData() {
	        return new Object[][] {
	            { By.xpath("//a[@href='the-forest']"), "https://keybooks.ro/shop/the-forest/" },
	            { By.xpath("//a[@href='the-son']"), "https://keybooks.ro/shop/the-son/" },
	            { By.xpath("//a[@href='life-in-the-garden']"), "https://keybooks.ro/shop/life-in-the-garden/" },
	            { By.xpath("//a[@href='the-long-road-to-the-deep-silence']"), "https://keybooks.ro/shop/the-long-road-to-the-deep-silence/" },
	            { By.xpath("//a[@href='its-a-really-strange-story']"), "https://keybooks.ro/shop/its-a-really-strange-story/" },
	            { By.xpath("//a[@href='storm']"), "https://keybooks.ro/shop/storm/" },
	        };
	    }
	
	
	@Test(dataProvider = "bookData" ) 
	public void bookTest(By bookLocator, String expectedUrl) {
		
		// Find the book and click on it
        WebElement bookElement = driver.findElement(bookLocator);
        bookElement.click();
						
		
        // Wait for URL to change
        try {
            Thread.sleep(2000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	
		  // Check actual URL-ul 
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Redirected URL is not the one expected ");

        // Back to previous page
        driver.navigate().back();
        
	}
	
	
}
