package com.opensource.admin.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_Admin_AddNewUser {
	int random = (int)(Math.random()*100);
	String newUser = "sakura"+random;
	
	@BeforeTest
	public void beforeTest() {
	}

	@Test

	public void TC003_Admin_AddNewUser_Script() throws InterruptedException {
		//DATA
				String username = "Admin";
				String password = "admin123";
				String employee = "Aaliyah Haq";
								
				String newPass = "sakura123___";
				
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe"); // se 
																												// llama
																												// al
																												// driver
																												// y se
																												// pone
																												// la
																												// ruta
																												// donde
																												// se
																												// encuentra
																												// dicho
																												// driver
		
		
		
		WebDriver driver = new ChromeDriver();
		

		// STEP 1 - Open Browser "OrangeHRM" web page
		Reporter.log("Open Browser \"OrangeHRM\" web page");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// STEP 2 - Enter Username and Password
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// STEP 3 - Validate that you have logged in successfully
		Reporter.log("Validate that you have logged in successfully");
		// ahora sincronizamos:
		WebDriverWait wait = new WebDriverWait(driver, 30); // aqui me dio error y di crtl+shift+ o para que me importe
															// lo que necesito
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule\']")));
		System.out.print("TC003");
		
		// STEP 4 - Click Admin - Go to the admin page
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='searchSystemUser_userName']")));

		// STEP 5 - Click Add
		Reporter.log("Click Add");
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();

		// STEP 6 - Enter valid Employee Name
		Reporter.log("Enter valid Employee Name");
		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys(employee);

		// STEP 7 - Enter valid username
		Reporter.log("Enter valid username");
		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(getnewUser());
		

		// STEP 8 - Enter new password and confirm
		Reporter.log("Enter new password and confirm");
		driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys(newPass);
		driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys(newPass);

		// STEP 9 - Click Save
		Reporter.log("Click Save");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='btnSave']")));
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();


		// STEP 10 - Search username in field "Username"
		Reporter.log("Search username in field \"Username");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(getnewUser());

		// STEP 11 - Click Search
		Reporter.log("Click Search");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// STEP 12 - Verify username exist in table
		Reporter.log("Verify username exist in table");
		Thread.sleep(1000);
		String getUsername = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(getUsername, getnewUser());

		// STEP 13 - Log out
		Reporter.log("Log out");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id=\"welcome\"]")));
		driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		

		// STEP 14- Close Browser
		Reporter.log("Close Browser");
		driver.close();
	}
	
	

	public String getnewUser() {
		return this.newUser;
	}

	@AfterTest
	public void afterTest() {
	}

}
