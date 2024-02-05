package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
	public static ExtentReports getreport() {
		String opencartdir=System.getProperty("user.dir");
		String path=opencartdir+"ereport1.html";
		System.out.println(path);
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Opencart Automation");
		report.config().setDocumentTitle("Automation report");
		ExtentReports ereport=new ExtentReports();
		ereport.attachReporter(report);
		/*ereport.setSystemInfo("Operating", "window");
		ereport.setSystemInfo("Selenium", "4.4");*/
		ereport.setSystemInfo("User Name", "Harshvardhan");
		System.out.println("harshtest");
		return ereport;
	}
}
