package com.tklender.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tklender.staticdata.PageUrl;

public class SystemPage extends Page {
	//private WebDriver driver;
		
	@FindBy(linkText = "ADD USER")
    public WebElement btnAddUser;
	
    @FindBy(css="button[ng-click=\"remove()\"]")
    public WebElement btnDeleteUser;

    @FindBy(css="input[placeholder=\"Search\"]")
    public WebElement serchUser;

    @FindBy(css="#usersGrid_grid")
    public WebElement listOfUser;
	
	public SystemPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	public boolean isAddUser(){
		if(isElementPresent(btnAddUser)){
			return true;
		}
		else {
			return false;
			}
		}
	public AddUserPage btnAddUsers(){
			btnAddUser.click();
		return PageFactory.initElements(driver, AddUserPage.class);
	}
}
