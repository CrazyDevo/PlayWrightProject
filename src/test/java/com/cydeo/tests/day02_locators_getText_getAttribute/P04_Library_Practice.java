package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P04_Library_Practice {

    @Test
    void test1() {
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();
        page.setDefaultTimeout(10000);
        //2. Go to http://library2.cybertekschool.com/login.html

        page.navigate("https://library2.cybertekschool.com/login.html");
        //wait for page load
        page.waitForLoadState();

        //3. Enter username: “incorrect@email.com”
        //Locate username input box using : class locator
         BrowserUtils.sleep(3);
        ElementHandle emailInput = page.getByPlaceholder("Email address").elementHandle();
        emailInput.fill("incorrect@email.com");

        BrowserUtils.sleep(3);
        //4. Enter password: “incorrect password”
        //Locate password input box using : id locator
        ElementHandle passwordInput = page.querySelector("#inputPassword");
        passwordInput.fill("incorrect password");

        BrowserUtils.sleep(3);
        //5.Locate Sign in button using : type

        ElementHandle signInButton = page.querySelector("button[type='submit']");
        signInButton.click();

        //6. Verify: visually “Sorry, Wrong Email or Password” displayed
        //VERIFIED.
        BrowserUtils.sleep(1);
        String errorMessage = page.querySelector("div[role='alert']").textContent();

        Assertions.assertEquals("Sorry, Wrong Email or Password",errorMessage);

        BrowserUtils.sleep(4);
        page.close();
        browser.close();
        playwright.close();


    }
}
