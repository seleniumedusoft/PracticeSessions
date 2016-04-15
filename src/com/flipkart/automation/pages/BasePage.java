package com.flipkart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	protected static WebDriver driver ;
	
	public static void initChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\libs\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

}
