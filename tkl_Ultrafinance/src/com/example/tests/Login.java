package com.example.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.bcel.generic.Select;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;
import ru.esteru.selenium.factory.WebDriverFactory;

public class Login {
  private WebDriver driver;
  private String baseUrl;
  private WebDriverWait wait;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:\\AutomationTesting\\chromedriver_win32\\chromedriver.exe");
	driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
	driver.manage().window().maximize();
	wait = new WebDriverWait(driver,10);
    baseUrl = "http://vm-elender:1212/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
	 // readFromExcel("D:\\Projects\\Ultrafinance\\Localization.xls");
	  goToMainPage("back"); 
	  enterLogin("alex", "123456");

  }

private void enterLogin(String username, String password) throws InterruptedException {
	driver.findElement(By.id("UserName")).clear();
    driver.findElement(By.id("UserName")).sendKeys(username);
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys(password);
    wait.until(visibilityOfElementLocated(By.cssSelector("input.btn.btn-default"))).click();
   
    //testNewApplication();
    //testAnketa();
}

private void goToMainPage(String envir) {
	if(envir=="back") {
	driver.get(baseUrl + "Account/Login");
	} else 
    if  (envir=="front"){
	driver.get(baseUrl + "Lending#/");
    }
	

}
	  
   //readFromExcel("D:\\Projects\\Ultrafinance\\Localization.xls");
	
		public static void readFromExcel(String file) throws IOException{
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
      HSSFSheet myExcelSheet = myExcelBook.getSheet("Sheet1");
      HSSFRow row = myExcelSheet.getRow(0);
      
      if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
          String name = row.getCell(0).getStringCellValue();
          System.out.println("name : " + name);
      }
      
      if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
          Date birthdate = row.getCell(1).getDateCellValue();
          System.out.println("birthdate :" + birthdate);
      }
      
      myExcelBook.close();
	}
private void createAppFront(String username, String password) throws InterruptedException {
	driver.findElement(By.cssSelector("button.btn-credit")).click();
	Thread.sleep(3000);
	assertTrue(driver.findElements(By.cssSelector("div.ng-scope")).size()>0);	
	driver.findElement(By.id("u.username")).clear();
	driver.findElement(By.id("u.username")).sendKeys(username);
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("confirmPassword")).clear();
	driver.findElement(By.name("confirmPassword")).sendKeys(password);
	driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	
	
	if(driver.findElements(By.className("modal-content")).size()>0){
	Thread.sleep(3000);
    //assertTrue(driver.findElements(By.className("modal-content")).size()>0);
	driver.findElement(By.xpath("html/body/div[3]/div/div/div[3]/button")).click();
	driver.findElement(By.id("loginLink")).click();
	driver.findElement(By.id("UserName")).clear();
    driver.findElement(By.id("UserName")).sendKeys(username);
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Вхід']")).click();
    newRepeatLoan();

	} else
    //-------------------------------
	{
		driver.findElement(By.xpath("//a[4]/img")).click();
		testAnketa();
	}
	//driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	
	//if(driver.findElement(By.cssSelector("div.modal-footer.ng-scope")).isDisplayed()){
		//wait.until(visibilityOfElementLocated(By.cssSelector("button.btn.btn-default"))).click();
		//driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		
	//}
	
	/*for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (driver.isElementPresent(By.cssSelector("div.modal-footer.ng-scope"))) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	*/


}

private void newRepeatLoan() {
	assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Активні позики')]")).getText().equalsIgnoreCase("Активні позики"));
	    driver.findElement(By.xpath("//a[contains(text(),'Нова позика')]")).click();
	    driver.findElement(By.cssSelector("button.btn-credit")).click();
	    if(driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/form/div/strong")).getText().equalsIgnoreCase("Заявка вже знаходиться на розгляді"))
	    {
	    	System.out.println("Заявка вже знаходиться на розгляді");
	    	driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	    	
	    } else 
	    	if(driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/form/div/strong")).getText().equalsIgnoreCase("Заявку на отримання позики відправлено.")){
	    		System.out.println("Заявку на отримання позики відправлено."); 
	    		driver.findElement(By.cssSelector("button.btn.btn-success")).click();  	 		
	    	}
}

private void testNewApplication() throws InterruptedException{
	    //goToMainPage();
	    //enterLogin("alex", "123456");
	//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	//wait.until(visibilityOfElementLocated(By.className("container body-content"))).isEnabled();
	    assertTrue("Нет кнопки Новая заявка!",driver.findElements(By.partialLinkText("Нова заявка")).size()>0);
	    //assertTrue("Нет кнопки Новая заявка!",wait.until(visibilityOfElementLocated(By.partialLinkText("Нова заявка"))).getSize()>0);
	    //wait.until();
	   
	    //driver.findElement(By.linkText("Нова заявка")).click();

	    wait.until(visibilityOfElementLocated(By.linkText("Нова заявка"))).click();
	    //driver.findElement(By.linkText("Нова заявка")).click();
	   // assertTrue("Нет кнопки Новая заявка!",driver.findElements(By.Text("Нова заявка на кредит")).size()>0);
	    //assertTrue("Не открылась форма создания заявки!",driver.findElements(By.name(name)).size()>0);
	   //Assert.assertTrue("Не открылась форма создания заявки!",driver.findElement(By.xpath("html/body/div[1]/elmenu/div[2]/div/ng-view/div/div/h3")).getText().contains("Нова заявка на кредит"));
	    assertTrue("Не открылось окно Новая заявка",driver.findElement(By.className("panel-heading")).findElement(By.tagName("h3")).getText().equals("Нова заявка на кредит"));
	   
	    //driver.findElement(By.id("_int")).clear();
	    //driver.findElement(By.id("_int")).sendKeys("1000");
	    new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("Payday");
	    
	    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
	    driver.findElement(By.name("Term")).clear();
	    driver.findElement(By.name("Term")).sendKeys("6");
	    driver.findElement(By.xpath("//div[2]/button")).click();
	    driver.findElement(By.xpath("//div[3]/button")).click();
	  


	   // driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	   // driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
}

private void testAnketa() throws InterruptedException{
	 WebElement clientLastName = wait.until(visibilityOfElementLocated(By.id("cd.LastName")));
	 WebElement clientFirstName = wait.until(visibilityOfElementLocated(By.id("cd.FirstName")));
	 WebElement clientMiddleName = wait.until(visibilityOfElementLocated(By.id("cd.MiddleName")));
	 WebElement clientEmail = wait.until(visibilityOfElementLocated(By.id("cd.Email")));
	    clientLastName.clear();
	    clientLastName.sendKeys("Напуменко");
		clientFirstName.clear();
	    clientFirstName.sendKeys("Александр");
		clientMiddleName.clear();
	    clientMiddleName.sendKeys("Игоревич");
		clientEmail.clear();
	    clientEmail.sendKeys("test24@test.ru");
	    //Enter birthday date---------------------------------------
	    //driver.findElement(By.id("cd.BirthDate_int")).click();
	    //driver.switchTo().activeElement();// (driver.findElement(By.cssSelector("cd.BirthDate_int")));
	    //setDatepicker(driver, "#cd.BirthDate_int", "01/01/1985");
	    driver.findElement(By.cssSelector("i.glyphicon.glyphicon-calendar")).click();
	    driver.findElement(By.xpath("//th[2]/button")).click();
	    for(int i=0;i<31;i++){
	    	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    }
	    driver.findElement(By.xpath("//td/button")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
	    //--------------------------------
	    
	    new Select(driver.findElement(By.id("cd.Gender"))).selectByVisibleText("Чоловіча");
	    new Select(driver.findElement(By.id("cd.MaritalStatus"))).selectByVisibleText("Одружений / заміжня");
	    new Select(driver.findElement(By.id("cd.Education"))).selectByVisibleText("Незакінчена середня");
	    new Select(driver.findElement(By.id("cd.Citizenship"))).selectByVisibleText("Так");
	    driver.findElement(By.id("cd.NumberOfDependents")).clear();
	    driver.findElement(By.id("cd.NumberOfDependents")).sendKeys("1");
	    new Select(driver.findElement(By.id("cd.LivingAddress_region"))).selectByVisibleText("Київ");
	    driver.findElement(By.id("cd.LivingAddress_house")).clear();
	    driver.findElement(By.id("cd.LivingAddress_house")).sendKeys("1");
	    new Select(driver.findElement(By.id("cd.LivingAddress_settlement"))).selectByVisibleText("Селище міського типу");
	    new Select(driver.findElement(By.id("cd.LivingAddress_settlement"))).selectByVisibleText("Місто");
	    new Select(driver.findElement(By.id("_StreetType"))).selectByVisibleText("вул.");
	    driver.findElement(By.id("cd.LivingAddress_street")).clear();
	    driver.findElement(By.id("cd.LivingAddress_street")).sendKeys("Героев Труда");
	    driver.findElement(By.id("cd.LivingAddress_zip")).clear();
	    driver.findElement(By.id("cd.LivingAddress_zip")).sendKeys("12312");
	    new Select(driver.findElement(By.id("model.ResidentialMatchesRegistration"))).selectByVisibleText("Так");
	    driver.findElement(By.id("cd.SocialSecurityNumber")).clear();
	    driver.findElement(By.id("cd.SocialSecurityNumber")).sendKeys("1234567890");
	    driver.findElement(By.xpath("//phone[@id='cd.AlternativePhone']/div/ng-form/input")).clear();
	    driver.findElement(By.xpath("//phone[@id='cd.AlternativePhone']/div/ng-form/input")).sendKeys("+38(012) 342-34-23");
	    driver.findElement(By.xpath("//phone[@id='cd.Phone']/div/ng-form/input")).clear();
	    driver.findElement(By.xpath("//phone[@id='cd.Phone']/div/ng-form/input")).sendKeys("+38(035) 345-34-53");
	    driver.findElement(By.xpath("//phone[@id='cd.WorkPhone']/div/ng-form/input")).clear();
	    driver.findElement(By.xpath("//phone[@id='cd.WorkPhone']/div/ng-form/input")).sendKeys("+38(024) 234-23-42");

	    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
	    driver.findElement(By.id("cd.GrossMonthlyIncome_int")).clear();
	    driver.findElement(By.id("cd.GrossMonthlyIncome_int")).sendKeys("1000");
	    driver.findElement(By.id("cd.GrossMonthlyExpenses_int")).clear();
	    driver.findElement(By.id("cd.GrossMonthlyExpenses_int")).sendKeys("100");
	    new Select(driver.findElement(By.id("cd.RealEstate"))).selectByVisibleText("Придбана власність");
	    new Select(driver.findElement(By.id("cd.CarOwner"))).selectByVisibleText("Так");
	    new Select(driver.findElement(By.id("cd.BusynessType"))).selectByVisibleText("Найманий працівник");
	    driver.findElement(By.id("cd.CompanyName")).clear();
	    driver.findElement(By.id("cd.CompanyName")).sendKeys("Тестовая");
	    driver.findElement(By.id("cd.WorkAddress")).clear();
	    driver.findElement(By.id("cd.WorkAddress")).sendKeys("Ярославская");
	    new Select(driver.findElement(By.id("_int"))).selectByVisibleText("Послуги та обслуговування / Готельний бізнес");
	    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
	    driver.findElement(By.id("cd.CurrentExperience")).clear();
	    driver.findElement(By.id("cd.CurrentExperience")).sendKeys("2");
	    driver.findElement(By.name("cd.OverallExperience")).clear();
	    driver.findElement(By.name("cd.OverallExperience")).sendKeys("2");
	    new Select(driver.findElement(By.cssSelector("dictionary[name=\"PositionType\"] > ng-form[name=\"dictForm\"] > #_int"))).selectByVisibleText("Керівник вищої ланки (директор, начальник управління, власник ПП, головний бухгалтер)");
	    driver.findElement(By.id("cd.Passport")).clear();
	    driver.findElement(By.id("cd.Passport")).sendKeys("123456789");
	    //Enter birthday date---------------------------------------
	    driver.findElement(By.xpath("//div[@id='cd.PassportRegistration']/ng-form/span/i")).click();
	    driver.findElement(By.xpath("//div[@id='cd.PassportRegistration']/ng-form/ul/li/div/table/thead/tr/th[2]/button")).click();
	    for(int j=0;j<16;j++){
	    	driver.findElement(By.xpath("(//button[@type='button'])[47]")).click();	
	    }
	    driver.findElement(By.xpath("(//button[@type='button'])[50]")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[56]")).click();
	    //--------------------------------
	    driver.findElement(By.id("cd.PassportIssuedBy")).clear();
	    driver.findElement(By.id("cd.PassportIssuedBy")).sendKeys("Тим");
	    //---Upload file----------
	    //uploadFile("1","D:\\OpenDialog.exe","OpenDialog.exe");
	    driver.findElement(By.linkText("Паспорт")).click();

//	    driver.findElement(By.xpath("//input[@name='file_source']")).click();
	     uploadFile(); 
	    // assertTrue(FindElements(By.xpath("(//input[@name='file_source'])[2]")).size()>0);
//	    driver.findElement(By.xpath("(//input[@name='file_source'])[2]")).click();
	    driver.findElement(By.linkText("ІП код")).click();


	     uploadFile();    
	//    driver.findElement(By.xpath("(//input[@name='file_source'])[3]")).click();
		    driver.findElement(By.linkText("Фото")).click();
	     uploadFile();    
	    //----------
	     driver.findElement(By.xpath("//input[@name='cd.AgreeWithTerms']")).click();
	     driver.findElement(By.xpath("//input[@value='Зберегти']")).click();
}

private void uploadFile() {
	String jacobDllVersionToUse;
	  if (jvmBitVersion().contains("32"))
	   jacobDllVersionToUse = "jacob-1.18-x86.dll"; 
	  else 
	   jacobDllVersionToUse = "jacob-1.18-x64.dll";
	 File file = new File("lib", jacobDllVersionToUse);
	  System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

	    AutoItX x = new AutoItX();
	     x.winWaitActive("Open");
	     x.send("D:\\Задвоенные платежи.txt");
	     //x.send("{ENTER}");
	     x.controlClick("Open", "", "1");
	     //x.processWaitClose("Open");
}
public
static String jvmBitVersion(){
 return System.getProperty("sun.arch.data.model");
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
