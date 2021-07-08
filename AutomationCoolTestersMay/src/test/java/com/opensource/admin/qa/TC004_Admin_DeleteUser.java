package com.opensource.admin.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC004_Admin_DeleteUser extends TC003_Admin_AddNewUser{
	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void TC004_Admin_DeleteUse_Script() throws InterruptedException {

		// DATA
		String username = "Admin";
		String password = "admin123";
		String employee = "Aaliyah Haq";
	//	int random = (int) (Math.random() * 100);
		String newUser = getnewUser();
		String newPass = "Korali___a123";

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
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
// sincronizamos:
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule\']")));
		System.out.print("TC004");
		
// STEP 4 - Click Admin - Go to the admin page
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='searchSystemUser_userName']")));

// STEP 5 - Click Add
		Reporter.log("Click Add");
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();

// STEP 6 - Enter valid Employee Name
		Reporter.log("Enter valid Employee Name");
		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys(employee);

// STEP 7 - Enter valid username
		Reporter.log("Enter valid username");
		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(newUser);

//  - Enter new password and confirm
		Reporter.log("Enter new password and confirm");
		driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys(newPass);
		driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys(newPass);

//  - Click Save
		Reporter.log("Click Save");		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='btnSave']")));
		Thread.sleep(1000);
	    WebElement buttSave = driver.findElement(By.xpath("//input[@id='btnSave']"));
	    System.out.println(buttSave.toString());
	    System.out.println(buttSave.getAttribute("id"));
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		
		
// - Search username in field "Username"
		Reporter.log("Search username in field \"Username");
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='btnAdd']")));
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(newUser);

// - Click Search
		Reporter.log("Click Search",true);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// - Verify username exist in table
		Reporter.log("Verify username exist in table");
		String getUsername = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		System.out.print(getUsername);
		Assert.assertEquals(getUsername, getnewUser());
	//	WebElement chkFBPersist = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
	//		    System.out.println(chkFBPersist.toString());
	//		    System.out.println(chkFBPersist.getAttribute("id"));
		

// STEP 8 - Select User
		Reporter.log("Select User", true);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='chkSelectRow[]']")).click();
	//	chkFBPersist = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input")); 
	
	//	    System.out.println(chkFBPersist.toString());
	//	    System.out.print(chkFBPersist.getAttribute("id"));
	    /*
	    boolean isSelected = chkFBPersist.isSelected();
	    if (isSelected == true) {
	    System.out.println(" is selected ");
	    }
	    else {
	    	   System.out.println(" is not selected ");
	    }
	    //Actions actions = new Actions(driver);
	    //actions.click(chkFBPersist).perform();
	    */
	
	    /*isSelected = chkFBPersist.isSelected();
	    if (isSelected == true) {
	    System.out.println(" is selected ");
	    }
	    else {
	    	   System.out.println(" is not selected ");
	    }
		*/
		//input[@id='ohrmList_chkSelectRecord_75']

// STEP 9 - Click Delete
	    Reporter.log("Click Delete", true);
	    driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
	//	WebElement buttDelete = driver.findElement(By.xpath("//input[@id='btnDelete']"));
	//		    System.out.println(buttDelete.toString());
	//		    System.out.println(buttDelete.getAttribute("id"));
	    
		
		//input[@id='btnDelete']

// STEP 10 - Validate pop-window is displayed: "Delete Records?"
	    Reporter.log("Validate pop-window is displayed: \"Delete Records?");
	    Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"deleteConfModal\"]")));
		//*[@id="deleteConfModal"]

// STEP 11 - Click Ok to confirm delete user
		Reporter.log("Click Ok to confirm delete user");
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		
		//input[@id='dialogDeleteBtn']

// STEP 12 - Validate in table that user was deleted successfully
		Reporter.log("Validate in table that user was deleted successfully",true);	
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
	    driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(newUser);
	    driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	    String newUser1 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
	    Assert.assertEquals(newUser1, "No Records Found");

// STEP 13 - Log out
	    Reporter.log("Log out");
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id=\"welcome\"]")));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
	    driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	    

// STEP 14 - Close Browser
	    Reporter.log("Close Browser");
	    driver.close();
	}

	@AfterTest
	public void afterTest() {
	}

}
