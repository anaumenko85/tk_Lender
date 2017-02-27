package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class createCreditProduct extends createUser {
	private WebDriver driver;
	
	@Test
	public void createCreditProductTest() throws Exception{
		login("alex","123456");
		logOff();
	}

}
