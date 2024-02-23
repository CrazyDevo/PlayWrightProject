package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P04_WindowsPractice {

    Page page;
    Playwright playwright;
    Browser browser;


    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //1. Open Chrome browser
        playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        page = browser.newContext().newPage();
        //2. Go to website: https://practice.cydeo.com/windows
        page.navigate("https://practice.cydeo.com/windows");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void multiple_windows_test(){
        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = page.title();

        Assertions.assertEquals(expectedTitle, actualTitle);


        System.out.println("Title before click: " + page.title());

        //5. Click to: “Click Here” link
        ElementHandle clickHereLink = page.querySelector("text=Click Here");
        clickHereLink.click();

        Page secondPage = page.waitForPopup(() -> {});

        System.out.println("Title after click: " + secondPage.title());


        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = secondPage.title();

        Assertions.assertEquals(actualTitle, expectedTitleAfterClick);

        //if we have to go back to main page to continue our test case,
        // we can use page.bringToFront()
       // secondPage.close();
        BrowserUtils.sleep(3);
        page.bringToFront();
        BrowserUtils.sleep(3);
        page.querySelector("text=Home").click();

        BrowserUtils.sleep(3);

        System.out.println("After Click Home = " + page.title());

        BrowserUtils.sleep(3);
        //code
    }



}
