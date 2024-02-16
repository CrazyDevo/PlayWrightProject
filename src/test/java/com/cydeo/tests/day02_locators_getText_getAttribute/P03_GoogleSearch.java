package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_GoogleSearch {


    @Test
  public   void test1() {


        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US","--force-english-ui")));
        Page page = browser.newPage();

        page.navigate("https://google.com");

        page.waitForLoadState();
        //find search area with name

        ElementHandle searchArea = page.querySelector("textarea[name='q']");

        if (searchArea!=null){

            //use the fill method to type into textarea
            searchArea.fill("Selenium");
        }


        //hit the enter

        //create keyboard object
        Keyboard keyboard = page.keyboard();

        //press Enter
        keyboard.press("Enter");

        BrowserUtils.sleep(5);

        page.reload();


        String expectedInUrl="q=Selenium";

        page.waitForLoadState();
        String actualURL= page.url();

        System.out.println("actualURL = " + actualURL);
        System.out.println("expectedInUrl = " + expectedInUrl);

        BrowserUtils.sleep(1);

        Assertions.assertTrue(actualURL.contains(expectedInUrl));

    }
}
