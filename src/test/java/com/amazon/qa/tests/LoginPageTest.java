/**
 * Author Tejaswini
 */
package com.amazon.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.Utility;

public class LoginPageTest extends BaseClass {
	
	HomePage homePage;
	LoginPage loginPage;
	Utility util;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage(driver);
		homePage.clickSignIn();
	}
	
	/*@Test(priority=1)
	public void validateLogo() {
		System.out.println("logo is present : " + homePage.checkLogo());
	}*/
	
	@DataProvider
	public Object[] getTestData() {
		Object[][] data=Utility.getTestData("userDetails");
		return data;
	}
	@Test(priority=1,dataProvider="getTestData")
	public void testLogin(String username,String password) throws InterruptedException {
		loginPage=new LoginPage(driver);
		
		
		homePage=loginPage.logIn(username,password);
		}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
