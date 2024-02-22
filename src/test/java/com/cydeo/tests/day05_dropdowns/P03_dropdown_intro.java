package com.cydeo.tests.day05_dropdowns;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_dropdown_intro {

    @Test
    void test() {


        //TC#3: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();


        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));

        Page page = browser.newContext().newPage();


        //2. Go to https://practice.cydeo.com/dropdown
        page.navigate("https://practice.cydeo.com/dropdown");

        //3. Verify “Simple dropdown” default selected value is correct
        //Locating the dropdown as a web element
        ElementHandle simpleDropdown = page.querySelector("//select[@id='dropdown']");


        //Expected: “Please select an option”
        String expectedDefaultValue = "Please select an option";
        BrowserUtils.sleep(3);
        String actualDefaultValue = simpleDropdown.evaluate("el=>el.selectedOptions[0].text").toString();

        System.out.println("expectedDefaultValue = " + expectedDefaultValue);

        System.out.println("defaultSelected = " + actualDefaultValue);

        Assertions.assertEquals(expectedDefaultValue, actualDefaultValue);

        //=====================================================
        //4. Verify “State selection” default selected value is correct

        //Create Select object, and also locate the dropdown itself in my constructor
        ElementHandle stateDropdown = page.querySelector("//select[@id='state']");

        // Expected: “Select a State”
        String expectedDefaultStateValue = "Select a State";
        String actualDefaultStateValue = stateDropdown.evaluate("el=>el.selectedOptions[0].text").toString();


        System.out.println("expectedDefaultStateValue = " + expectedDefaultStateValue);
        System.out.println("actualDefaultStateValue = " + actualDefaultStateValue);
        Assertions.assertEquals(expectedDefaultStateValue,actualDefaultStateValue);

        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();

    }
}
