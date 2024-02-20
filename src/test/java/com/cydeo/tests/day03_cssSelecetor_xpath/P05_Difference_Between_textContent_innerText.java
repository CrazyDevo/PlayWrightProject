package com.cydeo.tests.day03_cssSelecetor_xpath;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P05_Difference_Between_textContent_innerText {

    @Test
    void test1(){

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();



        //2- Go to: https://login1.nextbasecrm.com/
        page.navigate("http://localhost:63342/PlayWrightProject/src/test/resources/getText.html?_ijt=l9kuv9p6g8a4baoflj3ri2lsv4");
        //wait for page load
        page.waitForLoadState();

        ElementHandle divElement = page.locator("#example").elementHandle();

        System.out.println("Text Content "+divElement.textContent());
        System.out.println("Inner Text "+divElement.innerText());


        BrowserUtils.sleep(3);
        page.close();
        browser.close();
        playwright.close();


    }
}
