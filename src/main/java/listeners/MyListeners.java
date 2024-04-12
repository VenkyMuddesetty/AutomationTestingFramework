package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReporter;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("test Case execution started!!!");
		extentReport = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCaseName = result.getName();
		//System.out.println(testCaseName + " - started executing");
		extentTest = extentReport.createTest(testCaseName);
		extentTest.log(Status.INFO, testCaseName + " - started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCaseName = result.getName();
		//System.out.println(testCaseName + " - got executed successfully");
		extentTest.log(Status.PASS, testCaseName + " - got executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getName();
		//System.out.println(testCaseName + " got Failed");
		//System.out.println("Log is :" + result.getThrowable());
		extentTest.log(Status.FAIL, testCaseName + " - got Failed");
		extentTest.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCaseName = result.getName();
		//System.out.println(testCaseName + " - got Skipped");
		extentTest.log(Status.SKIP, testCaseName + " - got Skipped");
		extentTest.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		//System.out.println("All the test Cases executed Successfully");
		extentTest.log(Status.INFO, "All the test Cases executed Successfully");
		extentReport.flush();
	}

}
