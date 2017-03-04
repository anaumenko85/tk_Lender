package com.tklender.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackFirsPage extends Page{
	
	private WebDriver driver;
	@FindBy(linkText = "Log off")
	public WebElement linkLogOut;
	@FindBy(linkText = "Login")
	public WebElement linkLogIn;
	@FindBy(css = "div.navbar-collapse.collapse > ul li.active")
	public WebElement acliveLink;
    @FindBy(css = "div.navbar-collapse.collapse > ul")
    public List<WebElement> listOfMenu;
    @FindBy(linkText = "System")
    public WebElement linkSystem;

	public BackFirsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	public boolean isLoggedOut(){
		if(isElementPresent(linkLogIn)){
		return true;
	}
	else {
		return false;
		}
	}
	
	public boolean isLoggedIn(){
		if(isElementPresent(linkLogOut)) return true;
	else return false;
	}
	
	public void logout(){
		linkLogOut.click();
	}
	
	public Object getOriginator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getColorOriginator() {
		// TODO Auto-generated method stub
		return driver.findElement(By.linkText("System")).getCssValue("background-color").toString();
		
	}
	
	public SystemPage goToLynkSystem(){
		if(verifyEquals("System",acliveLink.getText())){
			linkSystem.click();	
			return PageFactory.initElements(driver, SystemPage.class);
		} else{
			linkSystem.click();
			return PageFactory.initElements(driver, SystemPage.class);
		}
		//return PageFactory.initElements(driver, SystemPage.class);
	}

}
