package com.dataDrivenTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener
{

	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	public void onStart(ITestContext context)
	{
		extent=new ExtentReports();
		  
		  //path of the report
		 spark=new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//HRMLogin.html");
		  
		  //cofiguration
		  spark.config().setDocumentTitle("HRM Login Report");
		  spark.config().setReportName("Test report");
		  spark.config().setTheme(Theme.DARK);
		  
		  //attached the report to spark reporter
		  
		  extent.attachReporter(spark);
		  
	
		
	}
	
	
	
	public void onTestSuccess(ITestResult result)
	{
		//create a test
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test Pass: "+result.getName());
		System.out.println("Test Pass: "+result.getName()+" Got successfully Executed");
		
	}
	

	public void onTestFailure(ITestResult result)
	{
		
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test Fail: "+result.getName());
	    test.log(Status.INFO,result.getThrowable().getMessage());
		System.out.println("Test Fail"+result.getName());
		
	}
	

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"Test Skipped: "+result.getName());
		System.out.println("Test Skipped"+result.getName());
		
	}
	public void onFinish(ITestContext context)
	{
		extent.flush();

	}
	
	

}
