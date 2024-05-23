package tests;

import org.testng.annotations.Test;
import pages.BlogPage;
import pages.AudioPostPage;
import pages.MenuPage;
import utils.BaseTest;

public class dragAndDropAudioPost extends BaseTest{
	
	@Test
	public void goToAudioPost() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver); //sa accesez obiectele din interiorul paginii
		BlogPage blog = new BlogPage(driver);
		AudioPostPage audio = new AudioPostPage(driver);
				
		menu.hoverElement(menu.blogLink);
		menu.navigateTo(blog.blogPostFormats);
		Thread.sleep(2000);
		menu.navigateTo(blog.audioPost);
		menu.navigateTo(audio.playButton);
		audio.dragAndDrop(audio.audioBar, 200, 0);
		audio.dragAndDrop(audio.volumeBar, 50, 0);
		Thread.sleep(2000);	
	}
}
