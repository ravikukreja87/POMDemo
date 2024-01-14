package org.example.tests.workflows;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.tests.BaseTest;
import org.example.tests.assertions.LoginAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.TestNG;
import org.testng.TestNGUtils;
import org.testng.annotations.*;

public class LoginWorkflowTest extends BaseTest {
    private WebDriver driver;


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        initializeReport("TestName");
    }

    @Test
    @Parameters({"username","password"})
    public void testLoginValidDuplicate(String username, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(7000);
        loginPage.login(username, password);
        Thread.sleep(2000);
        HomePage homePage = new HomePage(driver);
        String actualResult = homePage.getDashboardText();
        System.out.println("actualResult = " + actualResult);

        LoginAssertions loginAssertions = new LoginAssertions();
        loginAssertions.assertionLoginSuccess(actualResult);

    }

    @Test
    public void testLoginValid() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(7000);
        loginPage.login("Wrong", "admin123");
        Thread.sleep(2000);
        HomePage homePage = new HomePage(driver);
        String actualResult = homePage.getDashboardText();
        System.out.println("actualResult = " + actualResult);

        LoginAssertions loginAssertions = new LoginAssertions();
        loginAssertions.assertionLoginSuccess(actualResult);

    }



    @AfterMethod
    public void logOut(){
        WebElement profileDropDown = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        Actions actions = new Actions(driver);
        actions.click(profileDropDown).build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement logOutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
        actions.click(logOutLink).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
        extentReports.flush();
    }
//    @Test
    public void testLoginInvalid() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(7000);
        loginPage.login("Admin", "admin123");
        Thread.sleep(2000);
        HomePage homePage = new HomePage(driver);
        String actualResult = homePage.getDashboardText();
        System.out.println("actualResult = " + actualResult);

        LoginAssertions loginAssertions = new LoginAssertions();
        loginAssertions.assertionLoginSuccess("1" + actualResult);


    }
}
