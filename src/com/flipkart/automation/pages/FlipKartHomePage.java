package com.flipkart.automation.pages;

import org.openqa.selenium.WebDriver;

import com.flipkart.automation.pagesobjects.FlipKartHomePageObjects;

public class FlipKartHomePage extends BasePage{
	
	FlipKartHomePageObjects homepageObjects = new FlipKartHomePageObjects();

	public void openURL(){
		driver.get("http://www.flipkart.com");
	}
	
	public void clickLogin() {
		driver.findElement(homepageObjects.getTxtLogin()).click();
	}

}
