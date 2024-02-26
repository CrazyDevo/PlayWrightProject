package com.cydeo.tests.day09_upload_actions_jsexecutor;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class P02_Actions_Hover  {

    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //2. Go to https://practice.cydeo.com/hovers
        Driver.getPage().navigate("https://practice.cydeo.com/hovers");

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

    @Test
    public void hovering_test() {

        //Locate all the images here
        ElementHandle image1 = Driver.getPage().querySelector("(//img)[1]");
        Locator image2 = Driver.getPage().locator("(//img)[2]");
        Locator image3 = Driver.getPage().locator("(//img)[3]");

        //Locate all the "user" headers here
        ElementHandle user1 = Driver.getPage().querySelector("//h5[text()='name: user1']");
        ElementHandle user2 = Driver.getPage().querySelector("//h5[text()='name: user2']");
        ElementHandle user3 = Driver.getPage().querySelector("//h5[text()='name: user3']");


        //2. Hover over to first image
        BrowserUtils.sleep(2);
        image1.hover();


        //3. Assert:
        //a. “name: user1” is displayed
        Assertions.assertTrue(user1.isVisible());


        //4. Hover over to second image
        BrowserUtils.sleep(2);
        image2.hover();

        //5. Assert:
        //a. “name: user2” is displayed
        Assertions.assertTrue(user2.isVisible());

        //6. Hover over to third image
        BrowserUtils.sleep(2);
        image3.hover();

        //7. Assert:
        //a. “name: user3” is displayed
        Assertions.assertTrue(user3.isVisible());
       
    }



}
