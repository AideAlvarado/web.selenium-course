package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.Login.LoginPage;
import com.opensource.admin.UserManagementPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

//ESTO ES CON UN POM, UN PATRON DE DISEÑO

//CAPA 3 

public class TC001_AdminSearchEmployee_POM { // Al ser una clase, tenemos que instanciar nuestro constructor (tenemos que instanciar el estado de los objetos):
   
	//esto se llama composicion:
	WebDriver driver; // este Webdriver es exclusivo para nuestra clase, no viene del SeleniumWrapper. Va a generar un driver nuevo por cada testng class
	SeleniumWrapper seleniumWrapper; // ctrl + shift + o para importar las librerias
	LoginPage login; // creamos el objeto de LoginPAge
	UserManagementPage um;
	String username, password;

	
	
	@BeforeTest // es para setear todo antes de ejecutar
	public void beforeTest() {
		
		seleniumWrapper = new SeleniumWrapper(driver); //aqui solo se instancia
		driver = seleniumWrapper.chromeDriverConnection(); //con esto conectamos la capa 3 con la capa 1 (seleniumWrapper)
		login = new LoginPage(driver); //OBJETO LOGIN
		um = new UserManagementPage(driver);

		
		// SETUP DATA
		//con JSON FILE
		
	//	this.username = "Admin";
	//	this.password = "admin123";
			this.username = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "username");
			this.password = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "password");
		
		//Esto: seleniumWrapper.getJSONValue(this.getClass().getSimpleName() va a leer el nombre de mi clase y la va a llamar
		
		//EXCEL
		//		this.username = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 0);
		//	this.password = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 1);
	}
	
	

	@Test
	public void TC001_AdminSearchEmployee_POM_Script() {
		
		//ESTO SON SOLO LLAMADAS:

		// STEP 1 - Open Browser "OrangeHRM" web page
		login.setup(GlobalVariables.QA_URL);

		// STEP 2 -
		login.loginOrange(username, password);

		// STEP 3 -
		um.validateLoginSuccesfully();

		// STEP 4 -
		um.clickAdmin();

		// STEP 5 - STEP 6
		um.searchUser(username, true);

		// STEP 7
		um.validateUserTable(username);

		// STEP 8
		login.logoutOrange();

	}
	
	
	

	@AfterTest
	public void afterTest() {
		// STEP 9
		login.closeBrowser();
	}

}
