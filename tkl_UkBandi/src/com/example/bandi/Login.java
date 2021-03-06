package com.example.bandi;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;


public class Login {
  private WebDriver driver;
  private String baseUrl = "http://vm-elender:9544/";
  private StringBuffer verificationErrors = new StringBuffer();
/*
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:\\AutomationTesting\\chromedriver_win32\\chromedriver.exe");
    driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
    baseUrl = "http://vm-elender:9544/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
*/
  @Test
  public void mainTest() throws Exception {
	CreateUser newUser = new CreateUser();
	startBrowser();
	open(baseUrl+"/Account/Login");
	login("admin", "123456");
	newUser.createUser();
	newUser.deleteUser();
     logoff();

	 
	 //------------New Application----------------
	/* 
	 $(By.xpath("//a[contains(@href, '#/origination/newapp')]")).click();
	 $(By.xpath("//div[4]/div/p/select")).selectOptionContainingText("Initial");
	 $(By.xpath("//div[2]/button")).click();*/
	    //driver.findElement(By.xpath("//div[2]/button")).click();
	   // driver.findElement(By.linkText("New Application")).click();
	    //driver.findElement(By.xpath("//a[contains(@href, '#/origination/newapp')]")).click();


	   // new Select(driver.findElement(By.xpath("//div[4]/div/p/select"))).selectByVisibleText("Initial");

	 
	    /*driver.get(baseUrl + "Account/Login");
	    driver.findElement(By.id("UserName")).clear();
	    driver.findElement(By.id("UserName")).sendKeys("alex");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("123456");
	    driver.findElement(By.cssSelector("input.btn.btn-default")).click();*/
	 
    // driver.findElement(By.cssSelector("input.btn.btn-default")).click();
  }
private void logoff() {
	$(By.linkText("Log off")).click();
}
private void login(String username, String password) {

	$(By.id("UserName")).setValue(username);
	 $(By.id("Password")).setValue(password);
	 $(By.cssSelector("input.btn.btn-default")).click();
}
private void startBrowser() {
	System.setProperty("webdriver.chrome.driver", "D:\\AutomationTesting\\chromedriver_win32\\chromedriver.exe");
	Configuration.browser = "chrome";
}

}

