package org.example.tests.workflows;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RangeTest {

    @DataProvider(name = "range",propagateFailureAsTestFailure = false)
    public Object[][] rangeDate() {
        int lower = 5;
        int upper = 10;
        return new Object[][] {

                //Excel code
                //Properties file

                {lower-1 , lower, upper, true} , {lower, lower, upper, true} , {lower + 1, lower, upper, true} ,
                {upper-1 , lower, upper, true} , {upper, lower, upper, true} , {upper + 1, lower, upper, false}


        };
    }

    @Test(dataProvider = "range",description = "Some description of test",priority = 0,singleThreaded = true)
    public void rangeTester(int n, int lower , int upper, boolean expected){
        System.out.println("n = " + n + ", lower = " + lower + ", upper = " + upper + ", expected = " + expected);
    }
}
