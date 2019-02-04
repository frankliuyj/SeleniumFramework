package com.frank.selenium.utils;

import org.openqa.selenium.By;

import com.frank.selenium.utils.datasource.CaseInpurtDataManager;
import com.frank.selenium.utils.datasource.IDataSource;


public class GetByLocator {

	String filepath = "";;
	IDataSource prop = null;

	public GetByLocator(String filePath) {
		this.filepath = filePath;
		if (prop == null) {
			String args[] = new String[] {System.getProperty("user.dir") + filePath};
			prop = CaseInpurtDataManager.getDataSourceManager("properties", args);
		}
	}

	public By getLocator(String locatorName) {

		String value = prop.getProperty(locatorName);

		if (value == null || value.length() == 0)
			return null;

		String locatorType, locatorValue;
		String[] array = value.split(">");
		if (array.length < 2) {
			return null;
		} else {
			locatorType = array[0];
			locatorValue = array[1];
		}

		if (locatorType.equalsIgnoreCase("id")) {
			return new By.ById(locatorValue);
		} else if (locatorType.equalsIgnoreCase("class")) {
			return new By.ByClassName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			return new By.ByName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("tag")) {
			return new By.ByTagName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return new By.ByPartialLinkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("css")) {
			return new By.ByCssSelector(locatorValue);
		} else {
			return new By.ByXPath(locatorValue);
		}
	}

}
