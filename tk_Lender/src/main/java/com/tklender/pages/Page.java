package com.tklender.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
	protected WebDriver driver;
	
	public Page(WebDriver driver){
		this.driver = driver;
	}
	public boolean isElementPresent(WebElement element) {
	    try {
	      element.isDisplayed();
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}