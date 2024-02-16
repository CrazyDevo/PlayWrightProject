package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_Click_Link_With_Text {

    @Test
    public void test1() {


        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(1024, 760);

        page.navigate("https://practice.cydeo.com");

        BrowserUtils.sleep(3);

        //click A/B Testing with link text

        page.click("text=A/B Testing");
        BrowserUtils.sleep(3);

        String expectedTitle = "No A/B Test";
        String actualTitle = page.title();

        Assertions.assertEquals(expectedTitle, actualTitle);
        //close current page
        page.close();
        //close browser
        browser.close();
        //close playwright at the end we  will do
        playwright.close();
    }


    @Test
    public void test2() {


        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(1024, 760);

        page.navigate("https://practice.cydeo.com");

        BrowserUtils.sleep(3);

        //click A/B Testing with link text

        page.click("text=Drag and Drop");
        BrowserUtils.sleep(3);

        String expectedTitle = "Drag and Drop";
        String actualTitle = page.title();

        Assertions.assertEquals(expectedTitle, actualTitle);
        //close current page
        page.close();
        //close browser
        browser.close();
        //close playwright at the end we  will do
        playwright.close();
    }
}
