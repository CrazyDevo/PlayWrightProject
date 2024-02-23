package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

public class P02_Alert_Practices {

    Page page;
    Playwright playwright;
    Browser browser;


    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //1. Open Chrome browser
        playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        page = browser.newContext().newPage();
        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void confirmation_alert_test2(){
        //TC #2: Confirmation alert practice

        //3. Click to “Click for JS Confirm” button
        ElementHandle confirmationAlert = page.locator("//button[.='Click for JS Confirm']").elementHandle();
        confirmationAlert.click();

        //4. Click to OK button from the alert
        //Thread.sleep(1000);
        page.onceDialog(Dialog::accept);

        //5. Verify “You clicked: Ok” text is displayed.
        ElementHandle resultText = page.querySelector("//p[@id='result']");
        Assertions.assertTrue(resultText.isVisible());
    }



}




