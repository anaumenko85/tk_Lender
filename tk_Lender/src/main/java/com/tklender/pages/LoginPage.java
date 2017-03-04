package com.tklender.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.java.ConfigProperties;
import com.tklender.data.UserData;

public class LoginPage extends Page{

	//private WebDriver driver;
	@FindBy(linkText = "Login")
	public WebElement linkLogIn;
	@FindBy(id = "UserName")
	public WebElement username;
	@FindBy(id = "Password")
	public WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submit;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	public void open() {
		//driver.get(ConfigProperties.getProperty("login.url"));
		driver.get("http://vm-elender:9288/Account/Login");
		
	}
	
	public BackFirsPage loginAs(UserData admin){
		linkLogIn.click();
		type(username, admin.name);
		type(password, admin.password);
		submit.click();
		return PageFactory.initElements(driver, BackFirsPage.class);
	}

}
