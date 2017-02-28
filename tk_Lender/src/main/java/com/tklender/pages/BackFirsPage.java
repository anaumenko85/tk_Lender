package com.tklender.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackFirsPage {
	
	private WebDriver driver;

	public BackFirsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public Object getOriginator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getColorOriginator() {
		// TODO Auto-generated method stub
		return driver.findElement(By.linkText("System")).getCssValue("background-color").toString();
		
	}

}
