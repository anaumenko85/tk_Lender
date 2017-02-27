package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	  protected WebDriver driver;
	  private String baseUrl;
	 @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://vm-elender:9610/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 public void goToMainPage() {
			driver.get(baseUrl + "/lending#/");
		}
}
