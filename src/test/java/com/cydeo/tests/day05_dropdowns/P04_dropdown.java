package com.cydeo.tests.day05_dropdowns;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P04_dropdown {

    @Test
    void test1() {

        //TC #4: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();


        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));

        Page page = browser.newContext().newPage();


        //2. Go to https://practice.cydeo.com/dropdown
        page.navigate("https://practice.cydeo.com/dropdown");

        //3. Select “December 1st, 1933” and verify it is selected.
        //Locate dropdowns and pass them in Select object constructors
        ElementHandle yearDropdown = page.querySelector("//select[@id='year']");
        ElementHandle monthDropdown = page.querySelector("//select[@id='month']");
        ElementHandle dayDropdown = page.querySelector("//select[@id='day']");

        //Select year using : visible text
        BrowserUtils.sleep(3);
        //yearDropdown.selectOption("1933");
        yearDropdown.selectOption(new SelectOption().setLabel("1933"));

        //Select month using : value attribute
        BrowserUtils.sleep(3);
      //  monthDropdown.selectOption("11");
        monthDropdown.selectOption(new SelectOption().setValue("11"));

        //Select day using : index number
        BrowserUtils.sleep(3);
        dayDropdown.selectOption(new SelectOption().setIndex(0));

        //create expected values
        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from browser
        String actualYear = yearDropdown.evaluate("ev=>ev.selectedOptions[0].text").toString();
        System.out.println("actualYear = " + actualYear);
        String actualMonth = monthDropdown.evaluate("ev=>ev.selectedOptions[0].text").toString();
        System.out.println("actualMonth = " + actualMonth);
        String actualDay = dayDropdown.evaluate("ev=>ev.selectedOptions[0].text").toString();
        System.out.println("actualDay = " + actualDay);

        //create assertions
        Assertions.assertTrue(actualYear.equals(expectedYear), "ACTUAL YEAR NOT EQUAL EXPECTED YEAR!");
        Assertions.assertEquals(expectedMonth, actualMonth);
        Assertions.assertEquals(expectedDay, actualDay);



        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();


    }
}
