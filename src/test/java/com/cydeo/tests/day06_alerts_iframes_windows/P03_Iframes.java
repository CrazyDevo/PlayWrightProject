package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_Iframes {

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
        //2. Go to website: https://practice.cydeo.com/iframe
        page.navigate("https://practice.cydeo.com/iframe");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void iframe_test(){
        //TC #4: Iframe practice
        //we have to switch to iframe to be able to locate the web elements in there.
        //option#1- switch "id" attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option#2- switch using "index" number
        //driver.switchTo().frame(0);

        //option#3- switch using WebElement
        ElementHandle iframeElement = page.querySelector("//iframe[@id='mce_0_ifr']");
        Frame iframeContent = iframeElement.contentFrame();
        BrowserUtils.sleep(3);



        ElementHandle paragraphText= iframeContent.querySelector("//p");
        System.out.println("paragraphText.innerText() = " + paragraphText.innerText());
        //paragraphText.evaluate("el=>el.innerText=''");

        BrowserUtils.sleep(3);

        paragraphText.evaluate("el=>el.innerText='Hey my name is Adam'");


        BrowserUtils.sleep(3);

        System.out.println("elementHandle.innerText() = " + paragraphText.innerText());

        //4. Assert: “Your content goes here.” Text is displayed.
        Assertions.assertTrue(paragraphText.isVisible());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        page.bringToFront();
        ElementHandle h3 = page.querySelector("h3");
        Assertions.assertTrue(h3.isVisible());
    }



}
