package com.frank.selenium.business;

import com.frank.selenium.driver.BaseDriver;
import com.frank.selenium.webpagehandler.LoginPageHandler;

public class LoginProcess {

	BaseDriver driver = null;
	LoginPageHandler loginHandler = null;

	public LoginProcess(BaseDriver baseDriver) {
		this.driver = baseDriver;
		loginHandler = new LoginPageHandler(baseDriver);
	}

	public boolean verifyPageLoadState() {
		return loginHandler.isUsernameDisplayed() && loginHandler.isPasswordDisplayed()
				&& loginHandler.isSubmitButtonDisplayed();
	}

	public void login(String username, String password) {
		loginHandler.clearUsername();
		loginHandler.inputUsername(username);
		loginHandler.clearPassword();
		loginHandler.inputPassword(password);
		loginHandler.clickSubmitBtn();
	}

	public boolean verifyFailureState() {

		return loginHandler.isErrorMsgDisplayed();
	}

}
