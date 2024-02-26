package com.cydeo.tests.day10_actions_pom_explicit_waits;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_POM_Practice {

LibraryLoginPage loginPage;
    @BeforeEach
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getPage().navigate("https://library1.cydeo.com");
        loginPage=new LibraryLoginPage();

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }


    @Test
    public void field_required_error_message_test(){
        //TC #7: Required field error message test

        //3- Do not enter any information

        //4- Click to “Sign in” button
        loginPage.getSignInButton().click();
        BrowserUtils.sleep(3);

        //5- Verify expected error is displayed:
        Assertions.assertTrue(loginPage.getFieldRequiredErrorMessage().isVisible());


    }

}
