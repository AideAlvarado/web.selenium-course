package com.opensource.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.support.ui.Select;

//CAPA 1 aqui van todas las acciones

/**
 * Selenium wrapper class Base Class
 * 
 * @author aidea
 *
 */

public class SeleniumWrapper {
	
	//variable de instancia:
	private WebDriver driver; // hicimos ctrl+shift+o para que java importe la libreria webdriver
	

	/**Esto es un header
	 * Constructor Selenium wrapper 
	 * @autor aidea 
	 * @param driver 
	 * @return @throws
	 */

	// vamos a crear un constructor, el nombre del constructor es el mismo que la clase:
	// cada clase tiene un constructor por defecto. Cuando se instancia una clase forzosamente se debe de tener una variable de instancia que nos ayuda a generar ese objeto de tipo Webdriver para que nos ayude a interaturar con las alplicaciones y diferentes tipos de browser 

	public SeleniumWrapper(WebDriver driver) {
		this.driver = driver; //este objeto driver nos va a ayudar en todas las clases que va a heredar o componer nuestros scripts
	}

	
	/** Esto es un header
	 * Chrome driver connection
	 * 
	 * @autor aidea *
	 */
	//STEP 1 
	// vamos a generar otro metodo para establecer el ambiente
	//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
	public WebDriver chromeDriverConnection() { // aqui fallaba porque faltaba el return
		System.setProperty(GlobalVariables.CHROME_DRIVER_NAME, GlobalVariables.CHROME_DRIVER_PATH); // aqui nada puede ir hardcodeado
		driver = new ChromeDriver();
		return driver;
	}

	
	/**
	 * Reporter log
	 * 
	 * @author aidea
	 */
	//metodo de tipo reporte, genera el reporte y lo interpreta con el Reporter de testNG
	public void reportLog(String log) {
		Reporter.log(log);
	}

	
	/**
	 * Implicit wait
	 * 
	 * @author aidea
	 */
	//metodo que hace un implicitwait:
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	
	/**
	 * Launch Browser
	 * 
	 * @author aidea
	 */
	//parte del STEP 1- para lanzar el browser
	
	public void launchBrowser(String url) {
		//esto es una excepcion try-catch que es basicamente el reporte de lo que pasa en la ejecucion
		try {
			reportLog("Launch... " + url + " application"); //aqui llamamos a reportlog
			driver.get(url);
			driver.manage().window().maximize();
			implicitWait(5);
		} catch (Exception e) {
			e.printStackTrace(); //para imprimir el error
		}
	}

	
	/**
	 * Find element
	 * 
	 * @author aidea
	 */
	//metodo para encontrar un elemento
	public WebElement findElement(By locator) { // metodo para identificar los objetos web & recibe un locator
		return driver.findElement(locator);
	}

	
	/**
	 * Type text
	 * 
	 * @author aidea
	 */

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);


	}

	
	/**
	 * Click
	 * 
	 * @author aidea
	 */

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	
	/**
	 * ExplicitWait --> Wait for element present
	 * 
	 * @author aidea
	 */

	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Get Text
	 * 
	 * @author aidea
	 */
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	/**
	 * @author aidea
	 */
	
	public void getDisable() {
		Select drpStatus = new Select (driver.findElement(By.id("systemUser_status")));
        drpStatus.selectByVisibleText("Disabled");
	}
	


	
	/**
	 * Hard Assertion
	 * 
	 * @author aidea
	 * @param
	 */

	public void AssertEquals(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) { 
			Assert.fail("Not able to assert actual value <" + actualValue + "> with expected value " + expectedValue + ">");
		}

	}

	/**
	 *  Assertion
	 * 
	 * @author aidea
	 * @param
	 */

	public void AssertNotEquals(String actualValue, String expectedValue) {
		try {
			Assert.assertNotEquals(actualValue, null);
		} catch (AssertionError e) { 
			Assert.fail("Not able to assert actual value <" + actualValue + "> with expected value " + null + ">");
		}

	}

	/**
	 * Close Browser
	 * @author aidea
	 */
		
	public void closeBrowser() {
		try {
			reportLog("Closing Browser...");
			driver.close();
		}catch(NoSuchSessionException e) {
			Assert.fail("Not able to close browser");
		}
	}

	
	/*
	 * Get Value from Excel
	 * 
	 * @author Ricardo Avalos
	 * 
	 * @date 02/18/2019
	 */
	public String getCellData(String excelName, int row, int column) {
		try {
			// Reading Data
			FileInputStream fis = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA + excelName + ".xlsx");
			// Constructs an XSSFWorkbook object
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	/**
	 * * Get Data from JSON file (1 Node)
	 * 
	 * /** Get Data from JSON file (1 Node)
	 *
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonObjName, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFile, String jsonObjName, String jsonKey) {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFile + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonObjName).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

	/**
	 * Get Data from JSON file (Directly)
	 *
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey)  {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

}
