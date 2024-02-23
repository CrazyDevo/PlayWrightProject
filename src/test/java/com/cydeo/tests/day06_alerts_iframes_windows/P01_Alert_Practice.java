package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P01_Alert_Practice {

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
    public void information_alert_test1(){
        //TC #1: Information alert practice

        //3. Click to “Click for JS Alert” button
        ElementHandle informationAlertButton = page.querySelector("//button[.='Click for JS Alert']");
        informationAlertButton.click();

        BrowserUtils.sleep(2);
        //4. Click to OK button from the alert
        page.onceDialog(Dialog::accept);


        //page.onceDialog(d->d.accept());
        //5. Verify “You successfully clicked an alert” text is displayed.
        ElementHandle resultText = page.querySelector("//p[@id='result']");
        BrowserUtils.sleep(2);
        //Failure message will only be displayed if assertion fails:
        Assertions.assertTrue(resultText.isVisible(), "Result text is NOT displayed!");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.innerText();

        Assertions.assertEquals(actualText, expectedText, "Actual result text is NOT as expected!");
    }
}
