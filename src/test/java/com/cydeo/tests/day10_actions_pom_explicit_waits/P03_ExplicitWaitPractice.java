package com.cydeo.tests.day10_actions_pom_explicit_waits;

import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.options.ElementState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P03_ExplicitWaitPractice {

    DynamicLoad7Page dynamicLoad7Page;

    @BeforeEach
    public void setupMethod() {
        //1- Open a Chrome browser
        //2- Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getPage().navigate("https://practice.cydeo.com/dynamic_loading/7");
        dynamicLoad7Page = new DynamicLoad7Page();

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }


    @Test
    public void test10_wait_until_title_changes() {

        //2. Wait until title is “Dynamic title”
        Driver.getPage().waitForFunction("document.title === 'Dynamic title'");
        Assertions.assertTrue(dynamicLoad7Page.getDoneMessage().isVisible());

        //wait for visibility
        dynamicLoad7Page.getSpongeBobImage().elementHandle().waitForElementState(ElementState.VISIBLE);
        //4. Assert: Image is displayed.

        Assertions.assertTrue(dynamicLoad7Page.getSpongeBobImage().isVisible());
    }
}
