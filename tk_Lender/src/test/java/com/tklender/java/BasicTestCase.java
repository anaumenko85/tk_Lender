package com.tklender.java;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.example.java.ConfigProperties;
import com.example.java.WebDriverFactory;
import com.tklender.data.UserData;

public class BasicTestCase {
	protected static WebDriver driver;
	//SystemPage system = new SystemPage(driver);
	//AddUserPage userpage = new AddUserPage(driver);
	
	public UserData admin = new UserData("alex","123456");

	protected WebDriver getWebDriver(){
		if(driver==null){
			System.setProperty("webdriver.chrome.driver", "D:\\AutomationTesting\\chromedriver_win32\\chromedriver.exe");
		    driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
		    driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		}
		return driver;
	}
	@After
	  public void tearDown()  {
	  	   driver.quit();
	  }
}
