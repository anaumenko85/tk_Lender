package com.tklender.java;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.example.java.WebDriverFactory;
import com.tklender.pages.AddUserPage;
import com.tklender.pages.BackFirsPage;
import com.tklender.pages.LoginPage;
import com.tklender.pages.SystemPage;

public class tklTestPage extends BasicTestCase{
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(),LoginPage.class);
	private BackFirsPage backFirsPage;
	private AddUserPage addUserPage;
	private SystemPage systemPage;
	
	
  
  //private StringBuffer verificationErrors = new StringBuffer();

  
//-----------------------------------------------------
/*  @Test
public void faileLogin(){
	LoginPage login = new LoginPage(driver);
	login.enterUserName("admin");
	login.enterPassword("123123");
	login.submit();
	assertEquals("Invalid username or password.",login.loginError());
	/*username.sendKeys(username);
    userPassword.sendKeys(password);
    submit.click();
}
  @Test
public void lockUser(){
	LoginPage login = new LoginPage(driver);
	login.enterUserName("admin");
	login.enterPassword("123123");
	login.submit();
	try{
	assertEquals("Your account has been locked out until 2/23/2017 11:04:14 AM because of several consecutive failed login attempts.",login.loginError());
	} 
	catch(AssertionError e){
		System.out.println(e.getMessage());
	}
	/*username.sendKeys(username);
    userPassword.sendKeys(password);
    submit.click();
}*/
  @Test
  public void correctlogin() {
	// LoginPage login = new LoginPage(driver);
	//StringBuilder result = new StringBuilder();
  	//LoginPage login = new LoginPage(driver);
  	loginPage.open();
  	backFirsPage = loginPage.loginAs(admin);
  	assertTrue(backFirsPage.isLoggedIn());
  	systemPage = backFirsPage.goToLynkSystem();
  	assertTrue(systemPage.isAddUser());
  	systemPage.btnAddUser.click();
  	backFirsPage.logout();
  	assertTrue(backFirsPage.isLoggedOut());
  	
  	}
  	
  /*	BackFirsPage originator = new BackFirsPage(driver);
  	//driver.findElement(By.linkText("Underwriting")).click();
  	try {
  	assertEquals("rgba(189, 30, 30, 1)", originator.getColorOriginator());
  	}
  	catch (NoSuchElementException e) {
  		fail("Element not found!!");
  		e.printStackTrace();
  		}*/
  		
   
  /*public SystemPage systemPageInitialization() throws Exception{
	  SystemPage system = new SystemPage(driver);
	  //PageFactory.initElements(driver, system);
	  PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), system);
	  return system;
  } */
 /* @Test 
  public void testAddCustomer() {
	  loginPage.open();
	  backFirsPage = loginPage.loginAs(admin);
	  assertTrue(backFirsPage.isLoggedIn());
	  backFirsPage.goToLynkSystem();
	  //systemPage.btnAddUser();
	  //if()	
	    
  }*/
//------------------------------------------------------
    
}
