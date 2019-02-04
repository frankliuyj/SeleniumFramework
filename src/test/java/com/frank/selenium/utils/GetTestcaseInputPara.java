package com.frank.selenium.utils;

import com.frank.selenium.utils.datasource.CaseInpurtDataManager;
import com.frank.selenium.utils.datasource.IDataSource;

public class GetTestcaseInputPara {

	String filepath = "";
	IDataSource prop = null;

	public GetTestcaseInputPara(String filePath) {
		this.filepath = filePath;
		if (prop == null) {
			String args[] = new String[] {"third","test"};
			prop = CaseInpurtDataManager.getDataSourceManager("mongo", args);
		}
	}

	public String getProperty(String str) {
		return prop.getProperty(str);
	}

}
