package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P02_FindElements {

    @Test
    void test1() {

        //TC #2: FindElements Task
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();



        //2- Go to: https://practice.cydeo.com/abtest
        page.navigate("https://practice.cydeo.com/abtest");

        //3- Locate all the links in the page.
        List<ElementHandle> listOfLinks =  page.querySelectorAll("a");

        //4- Print out the number of the links on the page.
        System.out.println("listOfLinks.size() = " + listOfLinks.size());

        //5- Print out the texts of the links.
        //6- Print out the HREF attribute values of the links

        for (ElementHandle each : listOfLinks) {

            System.out.println("Text of links: " + each.innerText());
            System.out.println("HREF attributes' values: " + each.getAttribute("href"));

        }
        BrowserUtils.sleep(2);
        page.close();
        browser.close();
        playwright.close();

    }
}
