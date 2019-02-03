package com.frank.selenium.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerListener implements IRetryAnalyzer{

	int maxRetry = 2;
	int retryCount = 0;
	public boolean retry(ITestResult result) {

		if(retryCount < maxRetry)
		{
			retryCount++;
			System.out.println("This is "+retryCount+" try");
			return true;
		}
		return false;
	}
}
