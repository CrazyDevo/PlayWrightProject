package com.cydeo.tests.day07_webtables_utilities_configreader;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.WebDriverFactory;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_use_config_reader {

     Page page;
    Playwright playwright;
    Browser browser;


    @BeforeEach
    public void setupMethod() {
        //1. Open browser
        //1. Open Chrome browser

        String browserType = ConfigurationReader.getProperty("browser");

        playwright = Playwright.create();

        BrowserType browserType1 = WebDriverFactory.getDriver(browserType, playwright);
        browser = browserType1.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US",
                "--force-english-ui")));
        page = browser.newContext().newPage();
        //2. Go to: https://google.com
        page.navigate(ConfigurationReader.getProperty("googleURL"));
        BrowserUtils.sleep(3);
    }

    @AfterEach
    public void tearDownMethod() {

        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void google_search_test() {

        // 3- Write “apple” in search box or get the value from config file
        ElementHandle searchBox = page.querySelector("textarea[name='q']");
        searchBox.fill(ConfigurationReader.getProperty("searchValue"));
        searchBox.press("Enter");

        // 4- Verify title:
        //Expected: apple - Google Search
        String expectedTitleIn = ConfigurationReader.getProperty("searchValue");
        BrowserUtils.sleep(2);
        String actualTitle = page.title();

        Assertions.assertTrue( actualTitle.contains(expectedTitleIn));

    }

}
