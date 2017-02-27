package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


import ru.esteru.selenium.factory.WebDriverFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class tklTestPage extends BasePage{
  private WebDriver driver;
  private String baseUrl;

/*
              @FindBy(how=How.ID, using="UserName")
              private WebElement username;
          
          
              @FindBy(how=How.ID, using="Password")
              private WebElement password;
          
          
              @FindBy(how=How.XPATH, using="//input[@type='submit']")
              private WebElement submit;
  */        
  
  
  
  //private StringBuffer verificationErrors = new StringBuffer();

  
  /*public tklTestPage(WebDriver driver) {
      PageFactory.initElements(driver, this);
      this.driver = driver;
  }*/
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
  public void correctlogin() {
	//StringBuilder result = new StringBuilder();
  	//LoginPage login = new LoginPage(driver);
  	login.enterUserName("admin");
  	login.enterPassword("123456");
  	login.submit();
  /*	BackFirsPage originator = new BackFirsPage(driver);
  	//driver.findElement(By.linkText("Underwriting")).click();
  	try {
  	assertEquals("rgba(189, 30, 30, 1)", originator.getColorOriginator());
  	}
  	catch (NoSuchElementException e) {
  		fail("Element not found!!");
  		e.printStackTrace();
  		}*/
  		
   }
  public SystemPage systemPageInitialization() throws Exception{
	  SystemPage system = new SystemPage(driver);
	  //PageFactory.initElements(driver, system);
	  PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), system);
	  return system;
  } 
   @Test
  public void testAddCustomer() throws InterruptedException {
	  // SystemPage system = new SystemPage(driver);
	  // LoginPage login = new LoginPage(driver);
	  	login.enterUserName("admin");
	  	login.enterPassword("123456");
	  	login.submit();
	    	
	   //correctlogin();
	   
  try{
	  //driver.findElement(By.xpath("//form/a")).click();	  
  system.btnAddUser();
  }
  catch(NoSuchElementException e) {
	  fail("Element not found!!");
	  e.printStackTrace();	  
  }
  
  
  userpage.fFirstName.sendKeys("Test");
  userpage.fLastName.sendKeys("Alex");
  }
//------------------------------------------------------
  
}
