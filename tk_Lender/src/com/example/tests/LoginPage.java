package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void enterUserName(String username) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("UserName")).sendKeys(username);
	}

	public void enterPassword(String password) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("Password")).sendKeys(password);
	}

	public void submit() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	public String loginError() {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//section[@id='loginForm']/form/div/div/div/ul/li")).getText();
	}

}