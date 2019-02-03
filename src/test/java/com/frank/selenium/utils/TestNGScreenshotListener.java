package com.frank.selenium.utils;

import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.frank.selenium.testcase.BaseCase;

public class TestNGScreenshotListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result);

		BaseCase base = (BaseCase) result.getInstance();
		base.getDriver().takeScreenShot();

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {

		Iterator<ITestResult> iterator = context.getFailedTests().getAllResults().iterator();
		
		while(iterator.hasNext()) {
			ITestResult failedTest = iterator.next();
			ITestNGMethod method = failedTest.getMethod();
			if(context.getFailedTests().getResults(method).size() > 1) {
				iterator.remove();
			}else if(context.getPassedTests().getResults(method).size() > 0) {
				iterator.remove();
			}
		}

	}
}
