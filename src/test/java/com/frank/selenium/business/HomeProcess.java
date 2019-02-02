package com.frank.selenium.business;

import com.frank.selenium.driver.BaseDriver;
import com.frank.selenium.webpagehandler.HomePageHandler;

public class HomeProcess {

	BaseDriver driver = null;
	HomePageHandler homeHandler = null;

	public HomeProcess(BaseDriver baseDriver) {
		this.driver = baseDriver;
		homeHandler = new HomePageHandler(baseDriver);
	}

	public boolean verifyUserLoginState() {
		return homeHandler.isPersonalInfoDisplayed() && homeHandler.isLogputDisplayed();
	}

}
