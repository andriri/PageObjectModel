package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.BlogPage;
import utils.BaseTest;
import pages.BlogPage;

public class JSExecutorBlog extends BaseTest {

	@Test
	public void navigateToPostFormats() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		BlogPage blog = new BlogPage(driver);
		
		Thread.sleep(2000);
		//Actions actions = new Actions(driver);
        //actions.moveToElement((WebElement) blog.blogHover).perform();
		
		//WebElement blogMenu = driver.findElement(blog.blogHover);
		
		WebElement blogMenu = driver.findElement(By.xpath("li[id='menu-item-76']"));
		WebElement galleryFormatElement = driver.findElement(By.cssSelector("a[href='https://keybooks.ro/2016/02/01/gallery-format/']"));

		
		//String hoverScript = "var event = new MouseEvent('mouseover', { bubbles: true, cancelable: true, view: window }); arguments[0].dispatchEvent(event);";
		String javaScriptHover = "var objObject = document.createEvent('MouseEvents');" + "objObject.initMouseEvent('mouseover',true);" + "arguments[0].dispatchEvent(objObject);";
		jse.executeScript(javaScriptHover, blogMenu);
        
        // Folosim JavaScript Executor pentru a face click pe link-ul Post Formats
        jse.executeScript("arguments[0].click();", blog.blogPostFormats);
		
		jse.executeScript("arguments[0].scrollIntoView()", galleryFormatElement);
		
		//scroll down
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		
		
	}
}