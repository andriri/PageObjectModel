package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class DataProviderExample  extends BaseTest{
		

	String user = PropertiesFileProcessor.readPropertiesFile("username", "credentials.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credentials.properties");
	

	String user2 = PropertiesFileProcessor.readPropertiesFile("username2", "credentials.properties");
	String pass2 = PropertiesFileProcessor.readPropertiesFile("password2", "credentials.properties");
	
	//metoda ce se ocupa cu gestionarea datelor de test, da seturi de date
	//testam aceeasi functionalitate (metoda executat intr-o bucla fara sa trebuiasca sa o scriu eu) cu seturi diferite de date
	
	@DataProvider  //intoarce mereu un array in 2 dimensiuni
	public Object[][] loginTestData() {
		
		Object[][] data = new Object[4][3];  //rulez 4 seturi de date cu cate 3 valori fiecare
		
		data[0][0] = user;  //set de date valid
		data[0][1] = pass;
		data[0][2] = true;  //adaug o valoare noua boolean pt assert sa stim daca ne asteptam sa pice sau nu
		
		data[1][0] = "usergresit"; //set de date Invalid
		data[1][1] = "passgresit";
		data[1][2] = false;
		
		data[2][0] = user2; //set de date valid
		data[2][1] = pass2;
		data[2][2] = true;
		
		data[3][0] = user; //set de date Invalid
		data[3][1] = pass2;
		data[3][2] = false;
		
		return data;
						
	}
	
	@Test(dataProvider = "loginTestData" ) 
	public void loginTest(String username, String password, boolean sucess) {
		// am copiat functionalitatea din LoginTest
		
		MenuPage menu = new MenuPage(driver); //sa accesez obiectele din interiorul paginii
		LoginPage login = new LoginPage(driver);
				
		menu.navigateTo(menu.loginLink);
		login.loginInApp(username, password);		
		
		if(sucess) {
			
			assertTrue(login.checkMsgIsDisplayed(login.successLoginMessage));
			login.logoutFromApp();
			
		}else if(!sucess) {
			
			assertTrue(login.checkMsgIsDisplayed(login.errorLoginMessage));
			login.closeLoginPopUp();
		}
			
	}
	
}
