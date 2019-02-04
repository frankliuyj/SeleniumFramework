package com.frank.selenium.utils.datasource;

public interface IDataSource {

	public String getProperty(String key);
	
	public void writeNewProperty(String key, String value);
	
}
