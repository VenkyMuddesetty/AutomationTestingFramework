package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	//write code to configure Extent report
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReports = new ExtentReports(); 
		
		File extentReportPath = new File("C:\\SeleniumFramework\\MavenFrameworkSeleniumBatch3\\test-output\\ExtentReport\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Selenium Project Report");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("Application URL", "https://tutorialsninja.com/demo/");
		extentReports.setSystemInfo("Browser Name", "Chrome");
		extentReports.setSystemInfo("Environment Used", "QA2");
		extentReports.setSystemInfo("Opertaing System", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReports;
	}
}
