package com.cydeo.tests.day10_actions_pom_explicit_waits;

import com.cydeo.pages.W3Page;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P04_DoubleClick_Practice {


    W3Page w3Page;

    @BeforeEach
    public void setupMethod() {
        //1- Open a Chrome browser
        //2- Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getPage().navigate("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        w3Page = new W3Page();

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);

    }

    @Test
    public void t1_double_click_test() {

        //2. get element from iframe.
        Locator paragraph = w3Page.getParagraph();

        //3. Double-click on the text “Double-click me to change my text color.”
        paragraph.dblclick();

        //4. Assert:Text’s “style” attribute value contains “red”.
        // style="color: red;" --> "color: red;"
        String actualStyleAttributeValue = w3Page.getParagraph().getAttribute("style");
        String expectedInAttributeValue = "red";

        Assertions.assertTrue(actualStyleAttributeValue.contains(expectedInAttributeValue));
    }


}
