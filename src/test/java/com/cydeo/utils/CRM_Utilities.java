package com.cydeo.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class CRM_Utilities {

    public static void login_crm(Page page){
        //3. Enter valid username
        ElementHandle inputUsername = page.querySelector("//input[@name='USER_LOGIN']");
        inputUsername.fill("helpdesk1@cydeo.com");

        //4. Enter valid password
        ElementHandle inputPassword = page.querySelector("//input[@name='USER_PASSWORD']");
        inputPassword.fill("UserUser");

        //5. Click to`LogIn`button
        ElementHandle loginButton = page.querySelector("//input[@value='Log In']");
        loginButton.click();
    }



    public static void login_crm(Page page, String username, String password){

        //3. Enter valid username
        ElementHandle inputUsername = page.querySelector("//input[@name='USER_LOGIN']");
        inputUsername.fill(username);

        //4. Enter valid password
        ElementHandle inputPassword = page.querySelector("//input[@name='USER_PASSWORD']");
        inputPassword.fill(password);

        //5. Click to`LogIn`button
        ElementHandle loginButton = page.querySelector("//input[@value='Log In']");
        loginButton.click();

    }
}
