package com.frank.selenium.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frank.selenium.business.HomeProcess;
import com.frank.selenium.business.LoginProcess;
import com.frank.selenium.utils.GetTestcaseInputPara;

public class LoginTest extends BaseCase {

	GetTestcaseInputPara caseInput;
	LoginProcess lp;
	HomeProcess hp;

	@BeforeMethod
	public void preparePrecondtion() {
		initDriver("chrome");
		setDriverImplicitWait(10);
		caseInput = new GetTestcaseInputPara("\\src\\test\\properties\\login_page_data.properties");
		lp = new LoginProcess(baseDriver);
		hp = new HomeProcess(baseDriver);
		NavigateTo(caseInput.getProperty("url"));
	}

	@Test
	public void correctLoginTest() {
		String username = caseInput.getProperty("username");
		String password = caseInput.getProperty("password");
		String destinationKeywords = caseInput.getProperty("destination_keyword");

		if (lp.verifyPageLoadState()) {
			lp.login(username, password);
		} else {
			Assert.fail("Login page element is missing, test could be interrupted");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String newUrl = getUrl();
		if (newUrl.contains(destinationKeywords)) {
			Assert.assertTrue(hp.verifyUserLoginState());
		} else {
			Assert.fail("URL judgement has been failed!");
		}
	}

	@Test
	public void illegalLoginTest() {
		String username = caseInput.getProperty("wrong_username");
		String password = caseInput.getProperty("wrong_password");

		if (lp.verifyPageLoadState()) {
			lp.login(username, password);
		} else {
			Assert.fail("Login page element is missing, test could be interrupted");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String newUrl = getUrl();
		if (newUrl.contains(caseInput.getProperty("url"))) {
			Assert.assertTrue(lp.verifyFailureState());
		} else {
			Assert.fail("URL judgement has been failed!");
		}
	}

	@AfterMethod
	public void executePostcondition() {
		stopDriver();
	}

}
