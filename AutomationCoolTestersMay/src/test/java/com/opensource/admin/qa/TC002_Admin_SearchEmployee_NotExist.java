package com.opensource.admin.qa;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TC002_Admin_SearchEmployee_NotExist {
	
	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void TC001_Admin_SearchEmployee_Script() { //lo llamamos igual que la clase pero con _Script para que no lo tome como construtor
		//crear nuestro objeto tipo webdriver:
		
		  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe"); //se llama al driver y se pone la ruta donde se encuentra dicho driver
		  WebDriver driver = new ChromeDriver();
		  
		//STEP 1 - Open Browser "OrangeHRM" web page
		Reporter.log("Open Browser \"OrangeHRM\" web page");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//STEP 2 - Enter Username and Password
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//STEP 3 - Validate that you have logged in successfully
		Reporter.log("Validate that you have logged in successfully");
		//ahora sincronizamos:
		WebDriverWait wait = new WebDriverWait(driver, 30); //aqui me dio error y di crtl+shift+ o para que me importe lo que necesito
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule\']")));
		
		// STEP 4 - Click Admin - Go to the admin page
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='searchSystemUser_userName']")));
		
		//STEP 5 - Search username in field "Username"
		
		Reporter.log("Search username in field \"Username\"");
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("XYZ");
		
		
		//STEP 6
		Reporter.log("Click Search");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		//STEP 7 - Verify username is not exist in table
		Reporter.log("Verify username is not exist in table");
		String username = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		Assert.assertEquals(username, "No Records Found");
		
		
		
		//STEP 8 - Log out
		Reporter.log("Log out");
		driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//STEP 9 - close Browser
		Reporter.log("Close Browser");
		driver.close();
		
		//softAssert.assertAll();
		
	}

	@AfterTest
	public void afterTest() {
		
		
	}
}
