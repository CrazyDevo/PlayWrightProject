package com.cydeo.tests.day03_cssSelecetor_xpath;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_cssSelector {

    @Test
    void test1() {


        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();


        //2- Go to: https://login1.nextbasecrm.com/
        page.navigate("https://login1.nextbasecrm.com/");
        //wait for page load
        page.waitForLoadState();

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLoginText = "Log In";
        //Locating loginButton using class attribute's value
        ElementHandle loginButton = page.locator(".login-btn").elementHandle();




        String actualLoginText = loginButton.getAttribute("value");
        Assertions.assertEquals(expectedLoginText,actualLoginText);



        page.close();
        browser.close();
        playwright.close();
    }
}
