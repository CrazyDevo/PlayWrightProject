package com.cydeo.tests.day09_upload_actions_jsexecutor;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P05_JavascriptExecutor_Practice {

    @BeforeEach
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getPage().navigate("https://practice.cydeo.com/large");

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }


    @Test
    public void scroll_using_js_executor(){
        //Locating the links to be used later
        ElementHandle cydeoLink = Driver.getPage().querySelector("text=CYDEO");
        ElementHandle homeLink = Driver.getPage().querySelector("text=Home");


        BrowserUtils.sleep(3);
        cydeoLink.scrollIntoViewIfNeeded();

        BrowserUtils.sleep(3);
        homeLink.scrollIntoViewIfNeeded();


    }

}
