package com.amazon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseClass;

public class HomePage extends BaseClass{
	Actions action;
	
	
	@FindBy(xpath=".//*[@id='nav-logo']/a[1]")
	WebElement logo;
	
	@FindBy(xpath=".//*[@id='nav-link-accountList']")
	WebElement loginbtn;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		//this init will create all webelements
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkLogo() {
		return logo.isDisplayed();
		
	}
	
	public LoginPage clickSignIn() {
		loginbtn.click();		
		return new LoginPage(driver);
		
	
	}

}
