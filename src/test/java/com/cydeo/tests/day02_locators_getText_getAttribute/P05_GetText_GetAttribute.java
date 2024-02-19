package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P05_GetText_GetAttribute {

    @Test
    void test1() {

        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();



        //2- Go to: https://practice.cydeo.com/registration_form
        page.navigate("https://practice.cydeo.com/registration_form");
        //wait for page load
        page.waitForLoadState();

        //3- Verify header text is as expected:
        //Expected: Registration form

        ElementHandle header = page.querySelector("h2");
        String expectedHeaderText="Registration form";
        BrowserUtils.sleep(2);
        String actualHeaderText=header.textContent();
        System.out.println("actualHeaderText = " + actualHeaderText);
        System.out.println("expectedHeaderText = " + expectedHeaderText);
        Assertions.assertEquals(expectedHeaderText,actualHeaderText);


        //4- Locate “First name” input box

        ElementHandle firstNameInput = page.querySelector(".form-control");

        //5- Verify placeholder attribute’s value is as expected:
        // Expected: first name
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        System.out.println("expectedPlaceHolder = " + expectedPlaceHolder);
        System.out.println("actualPlaceHolder = " + actualPlaceHolder);

        Assertions.assertEquals(expectedPlaceHolder,actualPlaceHolder);

        page.close();
        browser.close();
        playwright.close();

    }
}
