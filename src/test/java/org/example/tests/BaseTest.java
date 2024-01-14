package org.example.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static WebDriver driver;

    public void initializeReport(String testName) {
        extentSparkReporter = new ExtentSparkReporter("extentReport.html");
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentReports = new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);
        extentTest = extentReports.createTest(testName);
    }

    public static String captureScreenshot(WebDriver driver) throws IOException {
        String FileSeparator = System.getProperty("file.separator");
        String Extent_report_path = "." + FileSeparator + "Reports";
        String ScreenshotPath = Extent_report_path + FileSeparator + "screenshots";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = "screenshot" + Math.random() + ".png";
        String screenshotpath = ScreenshotPath + FileSeparator + screenshotName;

        FileUtils.copyFile(src, new File(screenshotpath));
        return "." + FileSeparator + "screenshots" + FileSeparator + screenshotName;
    }

    public void flushTestReports(){
        extentReports.flush();
    }
}
