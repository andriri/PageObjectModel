package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.ShopPage;
import pages.MenuPage;
import utils.BaseTest;

public class DropdownExample extends BaseTest {
	
    @Test(priority = 1) 
	public void selectByValueTest() {
		
    	MenuPage menuPage = new MenuPage(driver); //navigam spre Menu Page
    	menuPage.navigateTo(menuPage.shopLink); //face click pe tabul BOOKS
    	//creez pagina ShopPage.java si adaug obicetul
    	
    	ShopPage shopPage = new ShopPage(driver);
    	shopPage.filterByValue("price-desc");
    	
    	assertEquals(shopPage.getCurrentSelectedOption(), "Sort by price: high to low");
    	
    }
    
    @Test(priority = 2) 
    public void selectByIndexTest() {
    	
    	ShopPage shopPage = new ShopPage(driver);
    	shopPage.filerByIndex(3);
    	
    	assertEquals(shopPage.getCurrentSelectedOption(), "Sort by latest");
    }
    
    @Test(priority = 3) 
    public void selectByVisibleTextTest() {  //valorile din dropdown
    	ShopPage shopPage = new ShopPage(driver);
    	shopPage.filterByVisibleText("Sort by popularity");
    	assertEquals(shopPage.getCurrentSelectedOption(), "Sort by popularity");
    	
    }
    
    
	
}
