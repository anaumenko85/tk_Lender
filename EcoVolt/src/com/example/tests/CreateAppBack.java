package com.example.tests;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAppBack{
   private String baseUrl;
	private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
	  System.setProperty("webdriver.chrome.driver", "D:\\AutomationTesting\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
    baseUrl = "http://vm-elender:9905/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateAppBack() throws Exception {
	driver.get(baseUrl + "Account/Login");
    driver.findElement(By.id("cd.FirstName")).clear();
    driver.findElement(By.id("cd.FirstName")).sendKeys("Alex");
    driver.findElement(By.id("cd.MiddleName")).clear();
    driver.findElement(By.id("cd.MiddleName")).sendKeys("Nest");
    driver.findElement(By.id("cd.LastName")).clear();
    driver.findElement(By.id("cd.LastName")).sendKeys("Rest");
    new Select(driver.findElement(By.id("cd.Suffix"))).selectByVisibleText("Jr.");
    driver.findElement(By.id("cd.Email")).clear();
    driver.findElement(By.id("cd.Email")).sendKeys("hfyaqezv@yomail.info");
    driver.findElement(By.id("_int")).clear();
    driver.findElement(By.id("_int")).sendKeys("10000");
    new Select(driver.findElement(By.xpath("//ng-form[@id='cd.originationPart']/eco-volt-edit-offer/div/div/div[2]/select"))).selectByVisibleText("Initial");
    driver.findElement(By.name("Term")).clear();
    driver.findElement(By.name("Term")).sendKeys("1");
    driver.findElement(By.name("StartingPriceForElectricity")).clear();
    driver.findElement(By.name("StartingPriceForElectricity")).sendKeys("11.1");
    new Select(driver.findElement(By.id("cd.CustomerType"))).selectByVisibleText("Residential");
    new Select(driver.findElement(By.id("cd.CusomerCurrentElectricUtilityDict_int"))).selectByVisibleText("Southern California Edison");
    new Select(driver.findElement(By.id("CashBank"))).selectByVisibleText("5%");
    driver.findElement(By.id("cd.CustomerDownPayment_int")).clear();
    driver.findElement(By.id("cd.CustomerDownPayment_int")).sendKeys("1000");
    driver.findElement(By.id("SystemConnectToCell")).click();
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
