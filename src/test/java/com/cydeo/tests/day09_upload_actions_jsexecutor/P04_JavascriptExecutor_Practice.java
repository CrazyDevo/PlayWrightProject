package com.cydeo.tests.day09_upload_actions_jsexecutor;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P04_JavascriptExecutor_Practice {

    @BeforeEach
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getPage().navigate("https://practice.cydeo.com/infinite_scroll");

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }


    @Test
    public void infinite_scroll_test_using_JSExecutor(){
        //a. 750 pixels down 10 times.
        //JavaScript method to use : window.scrollBy(0,0)
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            Driver.getPage().evaluate("window.scrollBy(0,750)");
        }

        //b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy(0,0)
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            Driver.getPage().evaluate("window.scrollBy(0,-750)");
        }
    }

}
