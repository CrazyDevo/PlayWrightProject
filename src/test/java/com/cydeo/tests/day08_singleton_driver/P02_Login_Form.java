package com.cydeo.tests.day08_singleton_driver;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_Login_Form {


    @BeforeEach
    public void setupMethod(){
        //1- Open a Chrome browser

        //2- Go to: https://practice.cydeo.com/login
        Driver.getPage().navigate(ConfigurationReader.getProperty("registration.login.url"));

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }


    @Test
    public void login_test(){
        BrowserUtils.sleep(3);
        //write tomsmith as username
        Driver.getPage().querySelector("input[name=username]").fill("tomsmith");
        //3- Write SuperSecretPassword as password
        BrowserUtils.sleep(3);
        //locate the search box
        ElementHandle searchBox = Driver.getPage().querySelector("input[name=password]");
        searchBox.fill("SuperSecretPassword");
        BrowserUtils.sleep(1);
        Driver.getPage().getByRole(AriaRole.BUTTON).click();

        //4- Verify title:
        String actualTitle = Driver.getPage().title();

        //String expectedTitle = "apple - Search";
        //We are just making the expectedTitle dynamic based on the text we are searching.
        String expectedTitle = "Secure Area";

        Assertions.assertTrue(actualTitle.equals(expectedTitle));


    }



}
