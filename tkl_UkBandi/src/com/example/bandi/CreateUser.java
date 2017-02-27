package com.example.bandi;

import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import com.codeborne.selenide.Selectors.ByText;

public class CreateUser {
	@Test
	//Создание пользователя
	public void createUser() {	
		$(By.linkText("System")).click();
	    $(By.linkText("Users")).click();
	    $(By.xpath("//a[contains(text(),'Add User')]")).click();
		$(By.id("user.UserName")).setValue("alex");
		$(By.id("user.Password")).setValue("123456");
		$(By.id("user.FirstName")).setValue("First");
		$(By.id("user.LastName")).setValue("Last");
		$(By.id("user.Email")).setValue("alex@mail.ru");
		$(By.id("user.PhoneNumber_int")).setValue("123-45-6789");
	    $(By.xpath("//input[@type='checkbox']")).click();
	    //for(int i=2;i<8;i++){
	    $(By.xpath("(//input[@type='checkbox'])[3]")).click();
	    $(By.xpath("(//input[@type='checkbox'])[5]")).click();
	    $(By.xpath("(//input[@type='checkbox'])[7]")).click();
	    $(By.xpath("(//input[@type='checkbox'])[2]")).click();
	    $(By.xpath("(//input[@type='checkbox'])[4]")).click();
	    $(By.xpath("(//input[@type='checkbox'])[6]")).click();
	    
	    $(By.xpath("//div[3]/button")).click();
	    checkCreatedUser();
	}
	@Test
    //Удаление пользователя
	public void deleteUser() throws InterruptedException{
	    $(By.xpath("//input[@type='text']")).sendKeys("TestUser");
	    Thread.sleep(2000);
	    $(By.xpath("//td/input")).click();
	    $(By.xpath("//form/button")).click();
	    $(By.cssSelector("button.btn.btn-success")).click();
	}
	//Проверка существующего пользователя 
	public void checkCreatedUser() {
		$(byText("The customer with this login already exists.")).shouldBe(visible);
		//String s = $(By.className("modal-contens")).getText();
		if($(byText("The customer with this login already exists.")).isDisplayed()){
		System.out.println("Пользователь уже существует!!!") ;
		$(By.cssSelector("button.btn.btn-default")).click();
	    $(By.xpath("//button[2]")).click();	}
			else
			System.out.println("Пользователя в системе нет!!!");
		//$(byText("The customer with this login already exists.")).shouldBe(visible);
		//$(By.xpath("html/body/div[1]/div/div/div[2]/form/div/strong")).shouldHave(exactText("The customer with this login already exists."));

		//System.out.println(s);
	   
	}
}
