package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.esteru.selenium.factory.WebDriverFactory;

public class BasePage {
	private WebDriver driver;
	SystemPage system = new SystemPage(driver);
	LoginPage login = new LoginPage(driver);
	AddUserPage userpage = new AddUserPage(driver);

	
	@Before
	  public void setUp()  {
	    System.setProperty("webdriver.chrome.driver", "D:\\AutomationTesting\\chromedriver_win32\\chromedriver.exe");
		driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
	    driver.get("http://vm-elender:8155/Account/Login");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  }
	@After
	  public void tearDown()  {
	   driver.close();
		  /* driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }*/
	  }
}
