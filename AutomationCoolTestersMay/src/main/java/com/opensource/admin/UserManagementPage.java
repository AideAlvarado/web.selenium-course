package com.opensource.admin;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Reporter;

import com.opensource.base.SeleniumWrapper;

//Capa 2

public class UserManagementPage extends SeleniumWrapper {

//necesito el constructor:
	public UserManagementPage(WebDriver driver) {
		super(driver);

	}

	// objetos:
	By linkUM = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txtUsername = By.xpath("//input[@id='searchSystemUser_userName']");
	By txtSearchUser = By.xpath("//input[@id='searchSystemUser_userName']");
	By btnSearch = By.xpath("//input[@id='searchBtn']");
	By tblUsername = By.xpath("//tbody/tr[1]/td[2]");
	By tblUsername1 = By.xpath("//tbody/tr[1]/td[1]");
	By btnAdd = By.xpath("//input[@id='btnAdd']");
	By txtEmployeeName = By.xpath("//input[@id='systemUser_employeeName_empName']");
	By txtNewUsername = By.xpath("//input[@id='systemUser_userName']");
	By txtNewPassword = By.xpath("//input[@id='systemUser_password']");
	By txtConfPassword = By.xpath("//input[@id='systemUser_confirmPassword']");
	By btnSave = By.xpath("//input[@id='btnSave']");
	By linkWelcome = By.xpath("//a[@id=\"welcome\"]");
	By linkLogout = By.xpath("//a[contains(text(),'Logout')]");
	By chkSelect = By.xpath("//input[@name='chkSelectRow[]']");
	By btnDelete = By.xpath("//input[@id='btnDelete']");
	By txtPopUp = By.xpath("//*[@id=\"deleteConfModal\"]");
	By btnOk = By.xpath("//input[@id='dialogDeleteBtn']");
	By tblStatus = By.xpath("//tbody/tr[1]/td[5]");
	
	
	

	/**
	 * Validate Login success
	 * 
	 * @author aidea
	 */

	public void validateLoginSuccesfully() {
		reportLog("Validate that you have logged in successfully");
		waitForElementPresent(linkUM);
	}
	


	/**
	 * Click Admin
	 * 
	 * @author aidea
	 */
	public void clickAdmin() {
		reportLog("Click Admin - Go to the admin page");
		click(linkUM);
		waitForElementPresent(txtUsername);
	}
	
	
	/**
	 * Click Select
	 * 
	 * @author aidea
	 */
	public void clickSelect() {
		reportLog("Select User");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click(chkSelect);
		
	}
	
	
	/**
	 * Delete
	 * 
	 * @author aidea
	 */
	public void clickDelete() {
		reportLog("Click Delete");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click(btnDelete);
	}
	
	
	/**
	 * Click Add
	 * @author aidea
	 * @return 
	 */
	public void clickAdd() {
		reportLog("Click Add");
		click(btnAdd);
	}
	
	/**
	 * Click OK
	 * @author aidea
	 * @return 
	 */
	public void clickOk() {
		reportLog("Click ok");
		click(btnOk);
	}
	

	/**
	 * Search username
	 * @author aidea
	 */
	public void searchUser(String username, boolean clickSearch) {
		reportLog("Search username in field 'Username'");
		type(username, txtSearchUser);
			if(clickSearch) {
				click(btnSearch);
			}
			
		}
	

	
	/**
	 * New User
	 * @author aidea
	 */
	
	public void newUser(String employee, String newUser, String newPass) {
		reportLog("Enter valid Employee Name");
		type(employee, txtEmployeeName);
		type(newUser, txtNewUsername);
		type(newPass, txtNewPassword);
		type(newPass, txtConfPassword);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click(btnSave);
		
	}
	
	
	/**
	 * New User Disable
	 * @author aidea
	 */
	
	public void newUserDisable(String employee, String newUser, String newPass) {
		reportLog("Enter valid Employee Name");
		type(employee, txtEmployeeName);
		type(newUser, txtNewUsername);
		getDisable();
		type(newPass, txtNewPassword);
		type(newPass, txtConfPassword);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click(btnSave);
		
	}
		
		
		/**
		 * Validate user exists in table
		
		 */
	public void validateUserTable(String expectedUser) {
		Reporter.log("Verify username exist in table");
		String actualUser = getText(tblUsername);
		assertEquals(actualUser, expectedUser);
		
	}
	
	/**
	 * Validate user not exists in table
	
	 */
	
	public void validateNotUserTable(String expectedResult) {
		Reporter.log("Verify username not exist in table");
		String actualUser = getText(tblUsername1);
		assertEquals(actualUser, expectedResult);
		
	}
	
	
	/**
	 * Validate status
	
	 */
	
	public void validateStatus(String status) {
		Reporter.log("Verify username is Disabled Status in table");
		String actualStatus = getText(tblStatus);
		assertEquals(actualStatus, status);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		waitForElementPresent(linkWelcome);
		
	}
	
	
	/**
	 * Validate confirm pop-up
	 * 
	
	 */
	
	public void validatePopUp() {
		Reporter.log("Validate pop-window is displayed: \\\"Delete Records?");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		waitForElementPresent(txtPopUp);
	}
		
	
	

}
