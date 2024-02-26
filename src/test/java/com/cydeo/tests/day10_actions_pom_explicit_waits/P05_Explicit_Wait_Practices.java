package com.cydeo.tests.day10_actions_pom_explicit_waits;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.pages.W3Page;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class P05_Explicit_Wait_Practices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeEach
    public void setupMethod() {
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getPage().navigate("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);

    }


    @Test
    public void t2_remove_checkbox_test(){
        //TC #2: Explicit wait practice


        //3- Click to “Remove” button

        dynamicControlsPage.getRemoveButton().click();

        //4- Wait until “loading bar disappears”
        //Using the custom utility method 'waitForInvisibilityOf' to wait loadingBar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.getLoadingBar());

        //5- Verify:
        //a. Checkbox is not displayed
        // dynamicControlsPage.checkbox.isVisible() --> if displayed, returns true;
        // dynamicControlsPage.checkbox.isVisible() --> if not displayed, returns false;


        try{
            //assertFalse method is expecting a "false" boolean value to PASS the test.
            Assertions.assertFalse(dynamicControlsPage.getCheckbox().isVisible());

        }catch (NoSuchElementException n){

            System.out.println("NoSuchElementException is thrown. It means that the Checkbox is not on the page.");
            Assertions.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assertions.assertTrue(dynamicControlsPage.getMessage().isVisible());
    }

}
