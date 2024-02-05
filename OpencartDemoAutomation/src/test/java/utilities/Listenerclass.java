package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listenerclass implements ITestListener {
	public ExtentReports ereport=Extentreport.getreport();
	public ExtentTest etest;
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started : "+result.getName());
	     etest=Extentreport.getreport().createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {  
		System.out.println("Success of test cases and its details are : "+result.getName());  
		etest.log(Status.PASS, "Test PASS");
		}  
		    
	public void onTestFailure(ITestResult result) {  
		System.out.println("Failure of test cases and its details are : "+result.getName()); 
		etest.log(Status.FAIL, "Test failed");
		}  
		   
	public void onTestSkipped(ITestResult result) {   
		System.out.println("Skip of test cases and its details are : "+result.getName());  
		etest.log(Status.SKIP, "Test failed");
		
		} 
	public void onFinish(ITestResult result) {
		Extentreport.getreport().flush();
	}

}
