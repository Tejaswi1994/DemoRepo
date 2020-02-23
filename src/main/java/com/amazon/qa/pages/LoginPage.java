package com.amazon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseClass;

public class LoginPage extends BaseClass{


	@FindBy(xpath=".//*[@id='ap_email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath=".//*[@id='signInSubmit']")
	WebElement logInBtn;
	
	@FindBy(xpath=".//*[@id='continue']")
	WebElement cntinue;
	
	@FindBy(name="password")
	WebElement pwd;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public HomePage logIn(String uname,String pswd) {
		try {
			email.sendKeys(uname);
			Thread.sleep(1000);
			cntinue.click();
			System.out.println("after contnue");
			Thread.sleep(2000);
			pwd.sendKeys(pswd);
			logInBtn.click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new HomePage(driver);		
	}
}
