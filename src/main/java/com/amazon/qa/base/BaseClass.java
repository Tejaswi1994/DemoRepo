package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.util.Utility;
import com.amazon.qa.util.WebEventListener;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;

	public BaseClass() {
		try {

		prop=new Properties();
		FileInputStream ip=new FileInputStream("C://Users//Tejaswi//MyWorkspace//AmazonTest//src//main//java//com//amazon//qa//config//config.properties");
		prop.load(ip);		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		/*e_driver=new EventFiringWebDriver(driver);
		//now create obj for EventListenerHandler to register it with EventFiringWebDriver
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;*/
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
