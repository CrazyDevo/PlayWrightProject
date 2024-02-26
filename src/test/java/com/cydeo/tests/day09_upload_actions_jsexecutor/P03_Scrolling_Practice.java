package com.cydeo.tests.day09_upload_actions_jsexecutor;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P03_Scrolling_Practice {

    @BeforeEach
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getPage().navigate("https://practice.cydeo.com/");

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

    @Test
    public void scrolling_practices() {

        //3- Scroll down to “Powered by CYDEO”
        //Locate the "CYDEO" link
        ElementHandle cydeoLink = Driver.getPage().querySelector("text=CYDEO");


        BrowserUtils.sleep(3);
        // Scroll down
        Driver.getPage().evaluate("() => { window.scrollBy(0, window.innerHeight); }");
        BrowserUtils.sleep(2); // Wait for 2 seconds

        // Scroll up
        Driver.getPage().evaluate("() => { window.scrollBy(0, -window.innerHeight); }");

        // Scroll down using mouse wheel
        BrowserUtils.sleep(2); // Wait for 2 seconds
        Driver.getPage().mouse().wheel(0, 300);

        // Scroll up using mouse wheel
        BrowserUtils.sleep(2); // Wait for 2 seconds
        Driver.getPage().mouse().wheel(0, -300);

       
    }



}
