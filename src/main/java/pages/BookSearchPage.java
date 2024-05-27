package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BookSearchPage {
	public WebDriver driver;
	public BookSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori
	//public By loadMore = By.xpath("//a[@id='viewmore_link']");
	public By loadMore = By.xpath("//span[contains(text(), 'LOAD MORE')]");
	public By addToCart = By.xpath("//button[@name='add-to-cart']");
	public By addToCartMessage = By.xpath("//div[@class='woocommerce-message']");
	public By viewCart = By.xpath("//a[@tabindex='1'][@class='button wc-forward']");	
	
	//metoda pentru a cauta cartea
	public void findBookByTitle(String bookTitle) throws InterruptedException {
		while (true) {
			try {
				WebElement element = driver.findElement(By.xpath("//h4[@class='post_title']//a[contains(text(), '"+bookTitle+"')]"));
				//Try to find the book name title
				if (element.isDisplayed()) {
					element.click();
					System.out.println(bookTitle+" found and clicked");
					break;
				}
			} catch (Exception e) {
				// Book not found, try clicking LOAD MORE button
				try {
					driver.findElement(loadMore).click();
					Thread.sleep(2000);
					System.out.println("LOAD MORE button clicked, searching for "+'"'+bookTitle+'"'+" again ...");
				} catch (Exception ex) {
					System.out.println("LOAD MORE button not found. Stopping search.");
					break;
					}	
				}
			}
	}
}