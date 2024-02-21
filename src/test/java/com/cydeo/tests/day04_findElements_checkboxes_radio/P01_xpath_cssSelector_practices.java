package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P01_xpath_cssSelector_practices {


    @Test
    void test1() {

        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();



        //2. Go to https://practice.cydeo.com/forgot_password
        page.navigate("https://practice.cydeo.com/forgot_password");

        //wait for page load
        page.waitForLoadState();




        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        //Locate "Home" link, using cssSelector, syntax #1, class attribute value
        //            tagName[attribute='value']
        ElementHandle homeLink_ex1 = page.querySelector("a[class='nav-link']");

        //Locate "Home" link, using cssSelector, syntax #2 (tagName.classValue), class attribute value
        ElementHandle homeLink_ex2 = page.querySelector("a.nav-link");

        //Locate "Home" link, using cssSelector, syntax #1, href attribute value
        ElementHandle homeLink_ex3 = page.querySelector("a[href='/']");

        //b. “Forgot password” header
        //Locate header, using xpath, using text of h2
        ElementHandle header_ex1 = page.querySelector("//h2[.='Forgot Password']");

        //Locate header, using cssSelector, syntax #1, locate parent element and move down to h2
        ElementHandle header_ex2 = page.querySelector("div[class='example'] > h2");

        //Locate header, using cssSelector, syntax #2, locate parent element and move down to h2
        ElementHandle header_ex3 = page.querySelector("div.example > h2");

        //c. “E-mail” text
        // locate the 'email' label using xpath
        ElementHandle emailLabel_ex1 = page.querySelector("//label[@for='email']");
        ElementHandle emailLabel_ex2 = page.querySelector("//label[.='E-mail']");

        //d. E-mail input box
        // locate the 'email' input box using xpath
        ElementHandle emailInput_ex1 = page.querySelector("//input[@name='email']");

        // locate the 'email' input box using xpath contains method
        //tagName[contains(@attribute, 'value')]
        ElementHandle emailInput_ex2 = page.querySelector("//input[contains(@pattern, 'a-z')]");

        //e. “Retrieve password” button
        // locate it using xpath
        ElementHandle retrievePasswordButton = page.querySelector("//button[@id='form_submit']");

        //f. "Powered by Cydeo" text

        ElementHandle poweredByCydeoText = page.querySelector("//div[@style='text-align: center;']");

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isVisible() = " + homeLink_ex1.isVisible());
        System.out.println("header_ex1.isVisible() = " + header_ex1.isVisible());
        System.out.println("emailLabel_ex1.isVisible() = " + emailLabel_ex1.isVisible());
        System.out.println("emailInput_ex1.isVisible() = " + emailInput_ex1.isVisible());
        System.out.println("retrievePasswordButton.isVisible() = " + retrievePasswordButton.isVisible());
        System.out.println("poweredByCydeoText.isVisible() = " + poweredByCydeoText.isVisible());


        //wait 2 seconds before closing the browser.
        BrowserUtils.sleep(2);


        page.close();
        browser.close();
        playwright.close();

    }
}
