package com.cydeo.tests.day10_actions_pom_explicit_waits;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
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

    @Test
    public void email_format_error_message_test(){
        //TC #8: Invalid email format error message test

        //3- Enter invalid email format
        loginPage.getEmailInput().fill("username");
        loginPage.getSignInButton().click();
        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assertions.assertTrue(loginPage.getEnterValidEmailErrorMessage().isVisible());
    }


    @Test
    public void wrong_email_or_password_error_message(){
        //TC #9: Library negative login

        //3- Enter incorrect username or incorrect password
        loginPage.getEmailInput().pressSequentially("username@wrongsomething.com",
                new Locator.PressSequentiallyOptions().setDelay(100));
        BrowserUtils.sleep(1);
        loginPage.getPasswordInput().fill("somethingIncorrect");
        loginPage.getSignInButton().click();

        //4- Verify expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        BrowserUtils.sleep(1);
        Assertions.assertTrue(loginPage.getWrongEmailOrPasswordErrorMessage().isVisible());
    }

}
