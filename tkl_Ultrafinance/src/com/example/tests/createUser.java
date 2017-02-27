package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createUser {
	private WebDriver driver;
	public void createUserTest(){
	login("admin", "123456");
	driver.findElement(By.linkText("Система")).click();
	driver.findElement(By.cssSelector("li.ng-scope.active > a.ng-binding")).click();
	driver.findElement(By.linkText("Додати користувача")).click();
	driver.findElement(By.id("user.UserName")).clear();
	driver.findElement(By.id("user.UserName")).sendKeys("alex");
	driver.findElement(By.id("user.Password")).clear();
	driver.findElement(By.id("user.Password")).sendKeys("123456");
	driver.findElement(By.id("user.FirstName")).clear();
	driver.findElement(By.id("user.FirstName")).sendKeys("Александр");
	driver.findElement(By.id("user.LastName")).clear();
	driver.findElement(By.id("user.LastName")).sendKeys("Науменко");
	driver.findElement(By.id("user.Email")).clear();
	driver.findElement(By.id("user.Email")).sendKeys("test@test.ua");
	driver.findElement(By.name("phoneInput")).clear();
	driver.findElement(By.name("phoneInput")).sendKeys("+38(027) 837-47-24");
	for (int i=4;i<10;i++){
	driver.findElement(By.xpath("(//input[@type='checkbox'])["+i+"]")).click();
	}
	driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
	
	//accesTrue("",driver.findElements(By.className("ng-binding")).equals()>0);
	
	logOff();

	}
	protected void logOff() {
		driver.findElement(By.linkText("Вихід")).click();
	}
	protected void login(String username, String password) {
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys(username);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
	}
}
