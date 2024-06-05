package pages;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {
	
public WebDriver driver;
	
	public BlogPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//public By blogHover = By.xpath("a[contains(text(), 'Blog')]");	
	public By blogHover = By.xpath("li[id='menu-item-76']");	
	public By blogClassic = By.cssSelector("a[href='https://keybooks.ro/category/classic/']");
	public By blogPost = By.cssSelector("a[href='https://keybooks.ro/2016/02/02/15-amazing-things-about-reading-in-the-fall/']");
	public By commentInput = By.id("comment");
	public By nameInput = By.id("input[id='author']");
    public By emailInput = By.id("input[id='email']");
	public By postComment = By.cssSelector("div[class='comment']");
	public By galerryFormatComment = By.cssSelector("div[class='comments_field comments_message']");
	public By galerryFormatName = By.id("input[id='author']");  
	public By galerryFormatPostComment = By.id("input[id='send_comment']");
	
	public By resultText = By.cssSelector("div[class='comment_not_approved']");
	public By blogPostFormats = By.cssSelector("a[href='https://keybooks.ro/category/post-formats/']");
	public By blogGalleryFormat = By.cssSelector("a[href='https://keybooks.ro/2016/02/01/gallery-format/']");

	public By audioPost = By.cssSelector("a[href='https://keybooks.ro/2016/02/02/audio-post/']");

	
	public void blogInApp() {
		
		driver.findElement(blogClassic).click();
		driver.findElement(blogPost).click();
		driver.findElement(commentInput).sendKeys("Lovely book");
		driver.findElement(nameInput).sendKeys("Irina Andrei");
		driver.findElement(emailInput).sendKeys("irinaandrei83@gmail.com");
		driver.findElement(postComment).click();
		driver.findElement(resultText).isSelected();
		
		//Thread.sleep(1000);
	    //check text awaiting approval
	    WebElement resultText = driver.findElement(By.cssSelector("div[class='comment_not_approved']"));
	    String actualMessage = resultText.getText();
	    String expectedMessage = "Your comment has been successfully posted.";
		assertEquals(actualMessage, expectedMessage);
		//getText(), "Your comment is awaiting moderation.");
	
	}
	
	public void postComment() {
		driver.findElement(galerryFormatComment).sendKeys("Homework 23");
		driver.findElement(galerryFormatName).sendKeys("Irina Andrei");
		driver.findElement(emailInput).sendKeys("irinaandrei83@gmail.com");
		driver.findElement(galerryFormatPostComment).click();
	}
	
//    // Write a comment
//    WebElement commentInput = driver.findElement(By.id("comment"));
//    commentInput.sendKeys("Lovely book");
//	
//	// Find the Name input field and send a value
//	driver.findElement(By.cssSelector("input[id='author']")).sendKeys("Irina Andrei");
//			
//	// Find the Email input field and send a value
//	driver.findElement(By.cssSelector("input[id='email']")).sendKeys("irinaandrei83@gmail.com");
//	
//	public By postComment = By.cssSelector("div[class='comment']");
//	postComment.click();
	
	//assertTrue(login.checkCommentIsDisplayed(login.errorLoginMessage));
	
	
	
	//verificam ca apare pop-up cu eroare sau succes
	public boolean checkMsgIsDisplayed(By locator) {
			
			return driver.findElement(locator).isDisplayed();
			
	}
}
