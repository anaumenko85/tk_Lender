package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.example.pages.LoginPage;
import com.example.pages.MyPageFactory;

import ru.esteru.selenium.factory.WebDriverFactory;

public class TestBase {

  protected WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public LoginPage goToMainPage() {
    driver.get(baseUrl + "/php4dvd/");
    return MyPageFactory.getPage(driver, LoginPage.class);
  }

}
