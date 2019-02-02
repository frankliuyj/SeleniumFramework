package com.frank.selenium.webpagehandler;

import com.frank.selenium.driver.BaseDriver;
import com.frank.selenium.webpage.HomePage;

public class HomePageHandler {

	public BaseDriver driver = null;
	public HomePage homePage = null;

	public HomePageHandler(BaseDriver baseDriver) {
		this.driver = baseDriver;
		homePage = new HomePage(driver);
	}

	public boolean isPersonalInfoDisplayed() {

		return homePage.isPersonalInfoDisplayed();
	}

	public boolean isLogputDisplayed() {

		return homePage.isLogoutDisplayed();
	}

}
