package com.frank.selenium.utils;

public class GetTestcaseInputPara {

	String filepath = "";
	PropertyManager prop = null;

	public GetTestcaseInputPara(String filePath) {
		this.filepath = filePath;
		if (prop == null)
			prop = new PropertyManager(System.getProperty("user.dir") + filePath);
	}

	public String getProperty(String str) {
		return prop.getProperty(str);
	}

}
