package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.Login.LoginPage;
import com.opensource.admin.UserManagementPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC002_Admin_SearchEmployee_NotExist_POM {
	
	WebDriver driver; 
	SeleniumWrapper seleniumWrapper;
	LoginPage login; 
	UserManagementPage um;
	String username, password;
	private String username1;
	
	
	
	@BeforeTest
  public void beforeTest() {
		seleniumWrapper = new SeleniumWrapper(driver);
		driver = seleniumWrapper.chromeDriverConnection(); 
		login = new LoginPage(driver); 
		um = new UserManagementPage(driver);

		
		// SETUP DATA		
		this.username = "Admin";
		this.username1 = "xyz";
		this.password = "admin123";
  }
	
	
	
  @Test
  public void TC002_Admin_SearchEmployee_NotExist_POM_Script() {
	  
		

		// STEP 1 - Open Browser "OrangeHRM" web page
		login.setup(GlobalVariables.QA_URL);

		// STEP 2 - Enter Username and Password
		login.loginOrange(username, password);

		// STEP 3 - Validate that you have logged in successfully
		um.validateLoginSuccesfully();

		// STEP 4 - Click Admin - Go to the admin page
		um.clickAdmin();

		// STEP 5 STEP 5 - Search username in field "Username"
		um.searchUser(username1, true);

	
		//STEP 7 - Verify username is not exist in table
		um.validateNotUserTable("No Records Found");

		// STEP 8
		login.logoutOrange();
  }
  

  @AfterTest
  public void afterTest() {
	// STEP 9
			login.closeBrowser();
		}
  }


