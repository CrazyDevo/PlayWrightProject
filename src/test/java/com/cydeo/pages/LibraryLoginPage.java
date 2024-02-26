package com.cydeo.pages;

import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;


@Getter
public class LibraryLoginPage {

    private final Locator emailInput;

    private final Locator passwordInput;
    private final Locator signInButton;
    private final Locator fieldRequiredErrorMessage;
    private final Locator enterValidEmailErrorMessage;
    private final Locator wrongEmailOrPasswordErrorMessage;

    public LibraryLoginPage() {

        emailInput = Driver.getPage().locator("#inputEmail");
        passwordInput=Driver.getPage().locator("#inputPassword");
        signInButton=Driver.getPage().locator("//button[.='Sign in']");
        fieldRequiredErrorMessage=Driver.getPage().locator("//div[.='This field is required.']/div");
        enterValidEmailErrorMessage=Driver.getPage().locator("//div[.='Please enter a valid email address.']/div");
        wrongEmailOrPasswordErrorMessage=Driver.getPage().locator("//div[.='Sorry, Wrong Email or Password']");


    }

}
