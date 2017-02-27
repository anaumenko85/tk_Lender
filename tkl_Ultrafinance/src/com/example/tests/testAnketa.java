package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testAnketa extends TestBase{
 
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 

  @Test
  public void testUntitled() throws Exception {
    goToMainPage();
    driver.findElement(By.id("cd.LastName")).clear();
    driver.findElement(By.id("cd.LastName")).sendKeys("���������");
    driver.findElement(By.id("cd.FirstName")).clear();
    driver.findElement(By.id("cd.FirstName")).sendKeys("���������");
    driver.findElement(By.id("cd.MiddleName")).clear();
    driver.findElement(By.id("cd.MiddleName")).sendKeys("��������");
    driver.findElement(By.id("cd.Email")).clear();
    //Enter birthday date
    setDatepicker(driver, "#datepicker", "01/01/1985");
    
    driver.findElement(By.id("cd.Email")).sendKeys("djpushko@mail.ru");
    new Select(driver.findElement(By.id("cd.Gender"))).selectByVisibleText("�������");
    new Select(driver.findElement(By.id("cd.MaritalStatus"))).selectByVisibleText("��������� / ������");
    new Select(driver.findElement(By.id("cd.Education"))).selectByVisibleText("���������� �������");
    new Select(driver.findElement(By.id("cd.Citizenship"))).selectByVisibleText("���");
    driver.findElement(By.id("cd.NumberOfDependents")).clear();
    driver.findElement(By.id("cd.NumberOfDependents")).sendKeys("1");
    new Select(driver.findElement(By.id("cd.LivingAddress_region"))).selectByVisibleText("���");
    driver.findElement(By.id("cd.LivingAddress_house")).clear();
    driver.findElement(By.id("cd.LivingAddress_house")).sendKeys("1");
    new Select(driver.findElement(By.id("cd.LivingAddress_settlement"))).selectByVisibleText("������ ������� ����");
    new Select(driver.findElement(By.id("cd.LivingAddress_settlement"))).selectByVisibleText("̳���");
    new Select(driver.findElement(By.id("1_StreetType"))).selectByVisibleText("���.");
    driver.findElement(By.id("cd.LivingAddress_street")).clear();
    driver.findElement(By.id("cd.LivingAddress_street")).sendKeys("������ �����");
    driver.findElement(By.id("cd.LivingAddress_zip")).clear();
    driver.findElement(By.id("cd.LivingAddress_zip")).sendKeys("12312");
    new Select(driver.findElement(By.id("model.ResidentialMatchesRegistration"))).selectByVisibleText("���");
    driver.findElement(By.id("cd.SocialSecurityNumber")).clear();
    driver.findElement(By.id("cd.SocialSecurityNumber")).sendKeys("1234567890");
    driver.findElement(By.name("phoneInput")).clear();
    driver.findElement(By.name("phoneInput")).sendKeys("+38(025) 345-34-53");
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.id("cd.GrossMonthlyIncome_int")).clear();
    driver.findElement(By.id("cd.GrossMonthlyIncome_int")).sendKeys("1000");
    driver.findElement(By.id("cd.GrossMonthlyExpenses_int")).clear();
    driver.findElement(By.id("cd.GrossMonthlyExpenses_int")).sendKeys("100");
    new Select(driver.findElement(By.id("cd.RealEstate"))).selectByVisibleText("�������� ��������");
    new Select(driver.findElement(By.id("cd.CarOwner"))).selectByVisibleText("���");
    new Select(driver.findElement(By.id("cd.BusynessType"))).selectByVisibleText("�������� ���������");
    driver.findElement(By.id("cd.CompanyName")).clear();
    driver.findElement(By.id("cd.CompanyName")).sendKeys("��������");
    driver.findElement(By.id("cd.WorkAddress")).clear();
    driver.findElement(By.id("cd.WorkAddress")).sendKeys("�����������");
    new Select(driver.findElement(By.id("_int"))).selectByVisibleText("������� �� �������������� / ��������� �����");
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.id("cd.CurrentExperience")).clear();
    driver.findElement(By.id("cd.CurrentExperience")).sendKeys("2");
    driver.findElement(By.name("cd.OverallExperience")).clear();
    driver.findElement(By.name("cd.OverallExperience")).sendKeys("2");
    new Select(driver.findElement(By.cssSelector("dictionary[name=\"PositionType\"] > ng-form[name=\"dictForm\"] > #_int"))).selectByVisibleText("������� ���� ����� (��������, ��������� ���������, ������� ��, �������� ���������)");
    driver.findElement(By.id("cd.Passport")).clear();
    driver.findElement(By.id("cd.Passport")).sendKeys("123456789");
    driver.findElement(By.id("cd.PassportIssuedBy")).clear();
    driver.findElement(By.id("cd.PassportIssuedBy")).sendKeys("���");
    driver.findElement(By.name("file_source")).click();
    driver.findElement(By.name("file_source")).clear();
    driver.findElement(By.name("file_source")).sendKeys("C:\\Users\\anaumenko\\Downloads\\ticket.pdf");
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.name("cd.AgreeWithTerms")).click();
    //driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
  }
  public void setDatepicker(WebDriver driver, String cssSelector, String date) {
	  new WebDriverWait(driver, 30000).until(
	    (WebDriver d) -> d.findElement(By.cssSelector(cssSelector)).isDisplayed());
	  JavascriptExecutor.class.cast(driver).executeScript(
	    String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
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
