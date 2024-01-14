package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    By dashboardLabelBy = By.xpath("//h6");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getDashboardText(){
        return  driver.findElement(dashboardLabelBy).getText();
    }
}
