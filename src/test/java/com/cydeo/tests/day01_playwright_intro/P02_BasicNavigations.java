package com.cydeo.tests.day01_playwright_intro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class P02_BasicNavigations {

    //mvn compile exec:java -D exec.mainClass="org.example.App"
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        //navigate the url
        page.navigate("https://practice.cydeo.com");
        Thread.sleep(3000);
        //navigate the url
        page.navigate("https://google.com");
        Thread.sleep(3000);
        //navigate back
        page.goBack();


        Thread.sleep(3000);
        //navigate forward
        page.goForward();
        //close the page

        page.close();

        browser.close();

        playwright.close();



    }
}
