package com.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {
        	String reportPath = System.getProperty("user.dir")
        	        + "\\reports\\ExtentReport.html";

        	System.out.println("Report Path: " + reportPath);

        	ExtentSparkReporter spark =
        	        new ExtentSparkReporter(reportPath);

//            ExtentSparkReporter spark =
//                    new ExtentSparkReporter("reports/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Selenium Framework");

            extent.setSystemInfo("Tester", "Savita");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }

        return extent;
    }
}
