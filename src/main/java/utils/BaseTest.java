package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	//initilizam si inchidem driverul dupa fiecare executie
	//folosim before and after class
	
	public WebDriver driver; //am importat WebDriver
	
	@BeforeClass
	public void setup() { //deschide browserul si navigheaza catre pagina noastra
		
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //mereu pornim pagina web pe pagina maximizata
											 //pentru a gasi toate butoanele cu locatorii (e diferit pe telefon vs monitor)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://keybooks.ro/");
		
		
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000); //lasa browserul deschis 5000 secunde
		driver.quit(); //inchide toate taburile
		//driver.close();//inchide tabul curent
	}
	
}
