package org.example.tests.assertions;

import org.testng.Assert;

public class LoginAssertions {

    public void assertionLoginSuccess(String actualResult) {
        System.out.println("Inside Assertions");
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println("Completed Assertions");


    }
}
