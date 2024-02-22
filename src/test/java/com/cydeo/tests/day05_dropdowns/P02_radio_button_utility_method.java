package com.cydeo.tests.day05_dropdowns;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P02_radio_button_utility_method {


    @Test
    void test() {

        // TC#2: Radiobutton handling
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();


        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));

        Page page = browser.newContext().newPage();


        //2. Go to https://practice.cydeo.com/radio_buttons
        page.navigate("https://practice.cydeo.com/radio_buttons");

       //3. Click to “Hockey” radio button
        clickAndVerifyRadioButton(page, "id", "hockey");

        //4. Click to “Football” radio button
        clickAndVerifyRadioButton(page, "id", "football");
        //5. Click to “Red” radio button
        clickAndVerifyRadioButton(page, "id", "red");


        BrowserUtils.sleep(3);

        page.close();

        browser.close();

        playwright.close();

    }

    private void clickAndVerifyRadioButton(Page page, String attribute, String value) {

        //Find the element
        ElementHandle hockeyRadioBtn = page.querySelector("//input[@"+attribute+"='"+value+"']");

        BrowserUtils.sleep(2);
        hockeyRadioBtn.click();

        // Verify radio button is selected after clicking.

        Assertions.assertTrue(hockeyRadioBtn.isChecked());

    }
}
