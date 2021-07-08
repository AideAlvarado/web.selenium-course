package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.Login.LoginPage;
import com.opensource.admin.UserManagementPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC005_Admin_CreateUserDisabled_POM {
	
	WebDriver driver; 
	SeleniumWrapper seleniumWrapper;
	LoginPage login; 
	UserManagementPage um;
	String username, password;
	private String employee;
	int random = (int)(Math.random()*1000);
	String newUser = "sakura"+random;
	private String newPass;
	private String status;
	
	@BeforeTest
  public void beforeTest() {
		seleniumWrapper = new SeleniumWrapper(driver);
		driver = seleniumWrapper.chromeDriverConnection(); 
		login = new LoginPage(driver); 
		um = new UserManagementPage(driver);

		
		// SETUP DATA		
		this.username = "Admin";
		this.password = "admin123";
		this.employee = "Aaliyah Haq";
		this.newPass = "sakura123___";
		this.status = "Disabled";
  }
	
	
  @Test
  public void TC005_Admin_CreateUserDisabled_POM_Script() {
	  
	// STEP 1 - Open Browser "OrangeHRM" web page
	  login.setup(GlobalVariables.QA_URL);
	  
	// STEP 2 - Enter Username and Password
	  login.loginOrange(username, password);
	  
	// STEP 3 - Validate that you have logged in successfully
	  um.validateLoginSuccesfully();
	  
	// STEP 4 - Click Admin - Go to the admin page
	  um.clickAdmin();
	  
	// STEP 5 - Click Add
	  um.clickAdd();
	  
	// STEP 6, 7, 8, 9, 10 - Enter valid Employee Name
	  um.newUserDisable(employee,newUser, newPass);
	  

	//STEP 11 - Search username in field "Username"
	  um.searchUser(newUser, true);
	  
	//STEP 12 - Click Search
	  um.validateUserTable(newUser);
	  
	//STEP 13 - Verify username is Disabled Status in table
	  um.validateStatus(status);
	  
	// STEP 14 - Log out
	  login.logoutOrange();
	  
	  
  }
  

  @AfterTest
  public void afterTest() {
	// STEP 14
			login.closeBrowser();
		}
  

}
