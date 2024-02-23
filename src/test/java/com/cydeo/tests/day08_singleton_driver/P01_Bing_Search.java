package com.cydeo.tests.day08_singleton_driver;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P01_Bing_Search {


    @BeforeEach
    public void setupMethod(){
        //1- Open a Chrome browser

        //2- Go to: https://bing.com
        Driver.getPage().navigate(ConfigurationReader.getProperty("bingURL"));

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

    @Test
    public void bing_search_test(){
        BrowserUtils.sleep(3);
        //click accept
        Driver.getPage().querySelector("#bnp_btn_accept").click();
        //3- Write “apple” in search box
        BrowserUtils.sleep(3);
        //locate the search box
        ElementHandle searchBox = Driver.getPage().querySelector("textarea[name='q']");
        searchBox.fill(ConfigurationReader.getProperty("searchValue"));
        BrowserUtils.sleep(1);
        searchBox.press("Enter");

        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search
        String actualTitle = Driver.getPage().title();

        //String expectedTitle = "apple - Search";
        //We are just making the expectedTitle dynamic based on the text we are searching.
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Search";

        Assertions.assertTrue(actualTitle.equals(expectedTitle));


    }
}
