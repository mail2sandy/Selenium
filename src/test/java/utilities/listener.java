package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import testCases.BaseClass;

public class listener implements ITestListener{
	
	public ExtentSparkReporter extentSparkReporter;
	public ExtentReports extentReports;
	public ExtentTest test;
	
	
	
	public void onTestStart(ITestResult result) {
	    // not implemented
		System.out.println("Test Execution Started.");

	  }
	
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		System.out.println("Test Execution Passed.");
		test = extentReports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Testcase passed " + result.getName());

	  }
	
	public void onTestFailure(ITestResult result) {
	    // not implemented
		System.out.println("Test Execution Failed.");
		test = extentReports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Testcase Failed " + result.getThrowable());
		
		try {
			String path = new BaseClass().takeScreenShot(result.getName());
			
			test.addScreenCaptureFromPath(path);
		}catch (Exception e) {
			test.log(Status.WARNING, "Erroring in capturing the screen print" + e.getMessage());
		}

	  }
	
	public void onTestSkipped(ITestResult result) {
	    // not implemented
		System.out.println("Test Execution Skipped.");
		System.out.println("Test Execution Failed.");
		test = extentReports.createTest(result.getName());
		test.log(Status.SKIP, "Testcase Skipped " + result.getName());
	  }
	
	public void onStart(ITestContext context) {
	    // not implemented
        String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        
		System.out.println("Application Execution Started.");
		   extentSparkReporter  = new ExtentSparkReporter(".\\test-output\\extent\\extentReport"+timeStamp+".html");
	       extentReports = new ExtentReports();
	       extentReports.attachReporter(extentSparkReporter);



	       //configuration items to change the look and feel
	       //add content, manage tests etc
	       extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
	       extentSparkReporter.config().setReportName("Test Report");
	       extentSparkReporter.config().setTheme(Theme.STANDARD);
	       extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	       String OS = context.getCurrentXmlTest().getParameter("os");
	       String browser = context.getCurrentXmlTest().getParameter("browser");
	       List<String> group = context.getCurrentXmlTest().getIncludedGroups();
	       
	       extentReports.setSystemInfo("OS", OS);
	       extentReports.setSystemInfo("Browser", browser);
	       extentReports.setSystemInfo("Groups", group.isEmpty()? "No Groups Assigned" : group.toString());
		
		
	  }
	
	public void onFinish(ITestContext context) {
	    // not implemented
		System.out.println("Application Execution Ended.");
		extentReports.flush();
	  }
	

}
