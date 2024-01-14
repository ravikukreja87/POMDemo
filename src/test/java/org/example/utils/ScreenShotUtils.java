package org.example.utils;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtils {

    public static void captureSSAsBase64(WebDriver driver, ExtentTest extentTest){
        extentTest.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
    }

    public static void captureSS(WebDriver driver, ExtentTest extentTest) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pathOfSS = "Images/" + System.currentTimeMillis() + ".jpg";
        File Dest = new File(pathOfSS);
        FileUtils.copyFile(scrFile, Dest);
        extentTest.addScreenCaptureFromPath(pathOfSS);
    }
}
