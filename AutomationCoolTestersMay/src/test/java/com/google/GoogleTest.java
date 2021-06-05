package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
  
  @BeforeTest //esto es lo que se ejecuta antes del codigo
  public void beforeTest() {
  }
  
  @Test   // esto es el test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe"); //se llama al driver y se pone la ruta donde se encuentra dicho driver
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest //lo que se ejecuta después
  public void afterTest() {
  }

}
