package com.frank.selenium.webpagehandler;

import com.frank.selenium.driver.BaseDriver;
import com.frank.selenium.webpage.LoginPage;

public class LoginPageHandler {

	public BaseDriver driver = null;
	public LoginPage loginPage = null;

	public LoginPageHandler(BaseDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(driver);
	}

	public boolean isUsernameDisplayed() {
		return loginPage.assertExisted(loginPage.getUsernameElement());
	}

	public boolean isPasswordDisplayed() {
		return loginPage.assertExisted(loginPage.getPasswordElement());
	}

	public boolean isSubmitButtonDisplayed() {
		return loginPage.assertExisted(loginPage.getSubmitButtonElement());
	}

	public void inputUsername(String username) {
		loginPage.sendKeys(loginPage.getUsernameElement(), username);
	}

	public void clearUsername() {
		loginPage.clear(loginPage.getUsernameElement());
	}

	public void inputPassword(String password) {
		loginPage.sendKeys(loginPage.getPasswordElement(), password);
	}

	public void clearPassword() {
		loginPage.clear(loginPage.getPasswordElement());
	}

	public void clickSubmitBtn() {
		loginPage.click(loginPage.getSubmitButtonElement());
	}

	public boolean isErrorMsgDisplayed() {

		return loginPage.assertExisted(loginPage.getErrorMsgElement());
	}

}
