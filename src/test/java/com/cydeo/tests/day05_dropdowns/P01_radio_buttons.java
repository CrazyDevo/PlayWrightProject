package com.cydeo.tests.day05_dropdowns;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P01_radio_buttons {


    @Test
    void test1() {

       // TC #1: Radiobutton handling
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();


        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));

        Page page = browser.newContext().newPage();



        //2. Go to https://practice.cydeo.com/radio_buttons
        page.navigate("https://practice.cydeo.com/radio_buttons");



        //3. Click to “Hockey” radio button
        ElementHandle hockeyRadioBtn = page.querySelector("//input[@id='hockey']");

        BrowserUtils.sleep(2);
        hockeyRadioBtn.click();

        //4. Verify “Hockey” radio button is selected after clicking.

        Assertions.assertTrue(hockeyRadioBtn.isChecked());

        BrowserUtils.sleep(3);

        page.close();

        browser.close();

        playwright.close();



    }
}
