package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBases.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter extentSpark;
	public ExtentReports extent;
	public ExtentTest test;
	
	public String RepName;
	
	@Override
	public void onStart(ITestContext result) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String TimeStamp=df.format(dt);
		
		RepName= "TestReports-"+TimeStamp+".html";
		
		extentSpark = new ExtentSparkReporter(".\\reports\\"+RepName);
		extentSpark.config().setDocumentTitle("OpenCartApplication");
		extentSpark.config().setReportName("OpenCart Application Report");
		extentSpark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(extentSpark);
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("UserName", System.getProperty("user.name"));
		extent.setSystemInfo("Module", "Application");
		extent.setSystemInfo("Sub Module", "Customer");
		
		String Browser = result.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", Browser);
		
		String OperatingSystem = result.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("OS:", OperatingSystem);
		
		List<String> IncludedGroups = result.getCurrentXmlTest().getIncludedGroups();
		if(!IncludedGroups.isEmpty())
		{
		     extent.setSystemInfo("IncludedGroups", IncludedGroups.toString());	
		}		
	}
	
	@Override
	public void onFinish(ITestContext result) {
		
		extent.flush();		
		String imgPath =System.getProperty("user.dir")+"//reports//"+RepName;
		File file = new File(imgPath);
		try
		{
			Desktop.getDesktop().browse(file.toURI());
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}



	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"Got Executed Successfully");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName());
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try
		{
			String imgPath=new BaseClass().CaptureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName());
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	

	

}
