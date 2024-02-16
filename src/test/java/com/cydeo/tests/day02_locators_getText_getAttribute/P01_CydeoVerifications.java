package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01_CydeoVerifications {

    @Test
    public void test1() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(1024, 760);

        page.navigate("https://practice.cydeo.com");

        String expectedInUrl = "cydeo";

        String currentUrl = page.url();

        BrowserUtils.sleep(3);

          //verify current url
        Assertions.assertTrue(currentUrl.contains(expectedInUrl));


        String expectedTitle="Practice";

        String actualTitle= page.title();

        //verify title

        Assertions.assertEquals(expectedTitle,actualTitle);


        page.close();

        browser.close();

        playwright.close();


    }
}
