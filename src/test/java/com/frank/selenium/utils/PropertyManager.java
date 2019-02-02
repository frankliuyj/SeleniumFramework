package com.frank.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private String path = null;
	private Properties prop = null;

	public PropertyManager(String filePath) {
		path = filePath;
		readProperties();
	}

	private void readProperties() {
		prop = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(path);
			prop.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Property file '" + path + "' doesn't exist.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO error with Property file '" + path + "'");
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {

		if (prop.containsKey(key)) {
			return (String) prop.get(key);
		} else {
			return "";
		}
	}

	public void writeNewProperty(String key, String value) {

		try {
			FileOutputStream outputStream = new FileOutputStream(path);
			prop.setProperty(key, value);
			prop.store(outputStream, "Update new Property");
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Property file '" + path + "' doesn't exist.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO error with Property file '" + path + "'");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String fullPath = System.getProperty("user.dir") + "/src/test/properties/login_page.properties";
		System.out.println(fullPath);
		PropertyManager manager = new PropertyManager(fullPath);
		manager.writeNewProperty("mobile", "10086");
	}

}
