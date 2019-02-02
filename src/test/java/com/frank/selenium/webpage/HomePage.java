package com.frank.selenium.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.frank.selenium.driver.BaseDriver;
import com.frank.selenium.utils.GetByLocator;

public class HomePage extends BasePage {

	public HomePage(BaseDriver driver) {
		super(driver);
		if (elementLocator == null)
			elementLocator = new GetByLocator("\\src\\test\\properties\\home_page_element.properties");
	}

	public WebElement getAccountElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("personal_info");
		return element(by);
	}

	public boolean isLogoutDisplayed() {
		return assertExisted(getLogoutElement());
	}

	public WebElement getLogoutElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("logout");
		return element(by);
	}

	public boolean isPersonalInfoDisplayed() {
		return assertExisted(getAccountElement());
	}
}
