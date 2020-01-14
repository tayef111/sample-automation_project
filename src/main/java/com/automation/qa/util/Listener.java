package com.automation.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.qa.base.TestBase;

public class Listener extends TestBase implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("Failed Test: " + Result.getName() );
	}

	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("Skipped Test: " + Result.getName() );
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult Result) {
		
		System.out.println("Passed Test: " + Result.getName() );
	}

	
	
	
}
