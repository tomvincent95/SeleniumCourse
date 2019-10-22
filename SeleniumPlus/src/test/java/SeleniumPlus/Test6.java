package SeleniumPlus;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Test6 {
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void beforeTest(){
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-ms");
		String fpath=System.getProperty("user.dir")+"/report/"+sdf.format(new Date())+".html";
		reporter=new  ExtentHtmlReporter(fpath);
		reports=new ExtentReports();
		reports.attachReporter(reporter);

	}
	@AfterTest	
	public void afterTest(){
		reports.flush();
	}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result){
		test= reports.createTest(result.getMethod().getMethodName());
	}
	@AfterMethod
	public void afterMethod(ITestResult result){
		if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS, result.getMethod().getMethodName()+"is passed");
		}
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, result.getMethod().getMethodName()+"is failure");
		}
		if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");
		}
	}
	@Test
	public void testPass(){
		test=reports.createTest("Pass");
		test.log(Status.PASS,"test pass");
		Assert.assertTrue(true);
	}
	@Test
	public void testFail(){
		
		Assert.assertTrue(false);
	}
	@Test
	public void testSkip(){
		throw new SkipException("Skippedd");
	}
}
