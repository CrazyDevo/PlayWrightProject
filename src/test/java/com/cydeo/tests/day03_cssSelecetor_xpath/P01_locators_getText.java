package com.cydeo.tests.day03_cssSelecetor_xpath;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P01_locators_getText {

    @Test
    void test1() {


        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();



        //2- Go to: https://login1.nextbasecrm.com/
        page.navigate("https://login1.nextbasecrm.com/");
        //wait for page load
        page.waitForLoadState();

        //3- Enter incorrect username: “incorrect”
        ElementHandle inputUsername = page.querySelector(".login-inp");
        inputUsername.fill("incorrect");

        //4- Enter incorrect password: “incorrect”
        ElementHandle inputPassword = page.querySelector("*[name='USER_PASSWORD']");
        inputPassword.fill("incorrect");

        //5- Click to the login button.
        ElementHandle loginButton = page.querySelector(".login-btn");
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorText = "Incorrect login or password";
        String actualErrorText = page.querySelector(".errortext").textContent();

        System.out.println("expectedErrorText = " + expectedErrorText);
        System.out.println("actualErrorText = " + actualErrorText);

        Assertions.assertEquals(expectedErrorText,actualErrorText);


        page.close();
        browser.close();
        playwright.close();



    }
}
