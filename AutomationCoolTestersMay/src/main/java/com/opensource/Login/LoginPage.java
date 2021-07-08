package com.opensource.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

// esto es una POC (Page Object Class)- Aqui solo va a vivir los metodos exclusivos de esta pantalla (login)

//CAPA 2 HABRA MTTO A NIVEL OBJETO

public class LoginPage extends SeleniumWrapper { //heredamos de SeleniumWrapper

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// objetos. El nombre de los objetos se escriben asi en POM.
	
	By txtUsername = By.xpath("//input[@id='txtUsername']");
	By txtPassword = By.xpath("//input[@id='txtPassword']");
	By btnLogin = By.xpath("//input[@id='btnLogin']");
	By btnWelcome = By.xpath("//a[@id=\"welcome\"]");
	By btnLogout = By.xpath("//a[contains(text(),'Logout')]");

	// metodos

	/**
	 * Set up environment
	 * 
	 * @author aidea
	 */
//AQUI VAMOS A REUTILIZAR EL METODO LAUNCHBROwser
	public void setup(String url) {
		launchBrowser(url); // SE PONE DE ESTA MANERA PARA RESPETAR LOS NIVEL. SE PUDO HABER PUESTO DIRECTAMENTE EN EL TC001 PERO NO RESPETARIA LSO NIVELES
	}

	/**
	 * Login Orange App
	 * 
	 * @author aidea
	 */

	public void loginOrange(String username, String password) {
		// aqui solo se van a hacer llamadas:
		reportLog("Open Browser OrangeHRM web page");
		type(username, txtUsername);
		type(password, txtPassword);
		click(btnLogin);
		implicitWait(5);
	}
	
	

	/**
	 * Logout Orange
	 * 
	 * @author aidea
	 */
	public void logoutOrange() {
		reportLog("Logout Orange web page...");
		click(btnWelcome);
		click(btnLogout);
		implicitWait(5);
	}

}
