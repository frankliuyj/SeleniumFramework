package com.frank.selenium.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.frank.selenium.driver.BaseDriver;
import com.frank.selenium.utils.GetByLocator;

public class LoginPage extends BasePage {

	public LoginPage(BaseDriver driver) {
		super(driver);
		if (elementLocator == null)
			elementLocator = new GetByLocator("\\src\\test\\properties\\login_page_element.properties");
	}

	public WebElement getUsernameElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("username");
		return element(by);
	}

	public WebElement getPasswordElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("password");
		return element(by);
	}

	public WebElement getSubmitButtonElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("submit_button");
		return element(by);
	}

	public WebElement getErrorMsgElement() {
		By by = elementLocator.getLocator("login_fail");
		WebElement element = element(by);
		if (element != null) {
			System.out.println("Error Message: " + element.getText());
		}
		return element;
	}

}
