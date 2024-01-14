package org.example.tests.workflows;

import org.example.tests.BaseTest;
import org.example.utils.ScreenShotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import static com.aventstack.extentreports.Status.*;


public class InvalidLoginTest extends BaseTest {
    private WebDriver driver;

    @AfterMethod
    public void afMethod(ITestResult result) throws IOException {
        ScreenShotUtils.captureSSAsBase64(driver, extentTest);
        System.out.println("Status of execution is:" + result.getStatus());
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                System.out.println("Test case execution status is SUCCESS");
                extentTest.log(PASS, "Test PASS");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                ScreenShotUtils.captureSS(driver, extentTest);
                // Do something here
                System.out.println("Test case execution status is FAILURE");
                extentTest.log(FAIL, "Test Failed");
            } else if (result.getStatus() == ITestResult.SKIP) {
                System.out.println("Test case execution status is SKIP");
                extentTest.log(SKIP, "Test Skipped");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
        extentReports.flush();
        flushTestReports();
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        initializeReport("testLoginExtentSS");
    }



    @Test
    public void testLoginExtentSS() throws InterruptedException, IOException {
        driver.get("https://testng.org/doc/documentation-main.html");
        Assert.assertTrue(true);


//

//        Thread.sleep(7000);
//        loginPage.login("Admin", "admin123");
//        Thread.sleep(2000);
//        HomePage homePage = new HomePage(driver);
//        String actualResult = homePage.getDashboardText();
//        System.out.println("actualResult = " + actualResult);
//
//        LoginAssertions loginAssertions = new LoginAssertions();
//        loginAssertions.assertionLoginSuccess("1" + actualResult);


    }





    @Test
    public void testLoginExtentSSTwo() throws InterruptedException, IOException {
        driver.get("https://testng.org/");
        Assert.assertTrue(false);




//        extentTest.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));

//        Thread.sleep(7000);
//        loginPage.login("Admin", "admin123");
//        Thread.sleep(2000);
//        HomePage homePage = new HomePage(driver);
//        String actualResult = homePage.getDashboardText();
//        System.out.println("actualResult = " + actualResult);
//
//        LoginAssertions loginAssertions = new LoginAssertions();
//        loginAssertions.assertionLoginSuccess("1" + actualResult);


    }

}
