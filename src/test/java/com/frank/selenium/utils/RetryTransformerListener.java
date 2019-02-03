package com.frank.selenium.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;



public class RetryTransformerListener implements IAnnotationTransformer{

	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		/*
		if(testClass != null)
			System.out.println(testClass.getName());
		if(testMethod != null)
			System.out.println(testMethod.getName());
		
		if(condition on names)
		{
			//change annotation
		}
		*/
		
		IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();

		if(retryAnalyzer == null) {
			annotation.setRetryAnalyzer(RetryAnalyzerListener.class);
		}

	}
}
