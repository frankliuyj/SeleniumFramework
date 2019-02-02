package com.frank.selenium.testcase;

import com.frank.selenium.driver.BaseDriver;

public class BaseCase {

	BaseDriver baseDriver = null;

	public void initDriver(String browerName) {
		if (baseDriver == null) {
			baseDriver = new BaseDriver(browerName);
		}
	}

	public void setDriverImplicitWait(int i) {
		baseDriver.setDriverImplicitWait(i);
	}

	public void NavigateTo(String url) {
		baseDriver.get(url);
	}

	public BaseDriver getDriver() {
		return baseDriver;
	}

	public String getUrl() {
		return baseDriver.getUrl();
	}

	public void stopDriver() {
		baseDriver.stop();
	}

}
