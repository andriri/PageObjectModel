package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AudioPostPage {
	
	
	public WebDriver driver;

	public AudioPostPage(WebDriver driver) {
	this.driver = driver;
}
	//identify slider elements
	public By playButton = By.xpath("//div[@class='mejs-button mejs-playpause-button mejs-play']");
	public By audioBar = By.xpath("//span[@class='mejs-time-current']");
	public By volumeBar = By.xpath("//div[@class='mejs-horizontal-volume-total']");
	
	public void dragAndDrop(By locator, int x, int y) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		//action.dragAndDropBy(element, x, y).perform();
		// sau scriem toate actiunile in lant una dupa alta
		action.moveToElement(element).clickAndHold(element).moveByOffset(x, y).release().perform();
		
	}

}
