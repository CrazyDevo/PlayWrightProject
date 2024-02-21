package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_checkboxes_radiobuttons {

    @Test
    void test1() {


        //TC#3: Checkboxes
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();


        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));

        Page page = browser.newContext().newPage();



        //2. Go to https://practice.cydeo.com/checkboxes
        page.navigate("https://practice.cydeo.com/checkboxes");


        //Locate checkbox #1, and #2.
        ElementHandle checkbox1 = page.querySelector("//input[@name='checkbox1']");
        ElementHandle checkbox2 = page.querySelector("//input[@name='checkbox2']");

        //2. Confirm checkbox #1 is NOT selected by default
        System.out.println("checkbox1.isChecked(), expecting false = " + checkbox1.isChecked());

        //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkbox2.isChecked(), expecting true = " + checkbox2.isChecked());


        //4. Click checkbox #1 to select it.
        BrowserUtils.sleep(2);
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
       BrowserUtils.sleep(2);
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isChecked(), expecting true = " + checkbox1.isChecked());

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isChecked(), expecting false = " + checkbox2.isChecked());


        BrowserUtils.sleep(5);

        page.close();
        browser.close();
        playwright.close();

    }
}
