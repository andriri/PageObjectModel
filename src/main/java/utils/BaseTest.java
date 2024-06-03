package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import pages.LoginPage;
import pages.MenuPage;


public class BaseTest {

	//initilizam si inchidem driverul dupa fiecare executie
	//folosim before and after class
	
	public WebDriver driver; //am importat WebDriver
	public MenuPage menu;
	public LoginPage login;
	
	//@Parameters({"url"})
	@BeforeClass
	public void setup() { //deschide browserul si navigheaza catre pagina noastra
		
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //mereu pornim pagina web pe pagina maximizata
											 //pentru a gasi toate butoanele cu locatorii (e diferit pe telefon vs monitor)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://keybooks.ro/");
		
		
	}
	//@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000); //lasa browserul deschis 5000 secunde
		driver.quit(); //inchide toate taburile
		//driver.close();//inchide tabul curent
	}
	
	@AfterClass
	public void recordFailure(ITestResult result) {   //listener
		//metoda se va executa dupa rularea fiecarei metode @Test
		//daca metoda este FAILED -> doar atunci face poza
		
		 if(ITestResult.FAILURE == result.getStatus()) {
			 TakesScreenshot sc = (TakesScreenshot) driver;
			 File poza = sc.getScreenshotAs(OutputType.FILE);
			 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
			 
			 try {
				 Files.copy(poza, new File("poze/"+result.getName()+"-"+timeStamp+".png")); 
				 //pt ca fiecare poza salvata sa aiba un nume unic de fiecare data, altfel se suprascrie
				 System.out.println("Picture saved");
				 
			 }catch(IOException e) {
				 System.out.println("Picture could not be saved");
				 e.printStackTrace();
			 }
			 
		 }
		
		
	}
	
}
