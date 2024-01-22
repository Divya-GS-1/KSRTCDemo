package Libraries;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ReportingGenerator implements ITestListener {
	
	ExtentReports report;
	ExtentTest report_logger;
	
	public void onStart(ITestContext context) {
	    String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    String ReportName="./test-output/Test-"+timestamp+".html";
	    
	    report=new ExtentReports();  
	    ExtentSparkReporter spark=new ExtentSparkReporter(ReportName);
	    report.attachReporter(spark);
	    spark.config().setDocumentTitle("Automation");
	    spark.config().setReportName("KSRTC Page Testing");
	    report.setSystemInfo("OS", System.getenv("OS"));	    
	    
	  }

	public void onTestStart(ITestResult result) {
		report_logger=report.createTest(result.getName());
		report_logger.log(Status.INFO, result.getName()+" Testcase started");
	    
	  }

	 
	public void onTestSuccess(ITestResult result) {
		report_logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" test case is PASSED" , ExtentColor.GREEN));
	    	  }

	  
	public void onTestFailure(ITestResult result) {
		report_logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" test case is FAILED. Please check below error", ExtentColor.RED));
		report_logger.log(Status.INFO, result.getThrowable().getMessage());
	}

	  
	  
	public void onFinish(ITestContext context) {
		report.flush();
	   
	  }
	}


