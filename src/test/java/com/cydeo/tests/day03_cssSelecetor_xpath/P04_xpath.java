package com.cydeo.tests.day03_cssSelecetor_xpath;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P04_xpath {

    @Test
    public void test() {

        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
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

        //Locating loginButton using xpath using class attribute's value
        String locator1="//input[@class='login-btn']";

        //Locating loginButton using xpath using value attribute's value
        String locator2="//input[@value='Log In']";

        //Locating loginButton using xpath using type attribute's value
        String locator3="//input[@type='submit']";

        ElementHandle loginButton = page.querySelector(locator3);


        String actualLoginText = loginButton.getAttribute("value");

        System.out.println("actualLoginText = " + actualLoginText);


        Assertions.assertEquals(expectedLoginText,actualLoginText);



        page.close();

        browser.close();

        playwright.close();
    }
}
