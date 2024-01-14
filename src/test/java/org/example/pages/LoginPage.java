package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    By usernameBy = By.name("username");
    By passwordBy = By.name("password");
    By loginButtonBy = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {

        this.driver  = driver;
    }

    public void login(String username, String password){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
    }

}
