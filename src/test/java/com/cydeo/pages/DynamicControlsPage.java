package com.cydeo.pages;

import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class DynamicControlsPage {


    private final Locator removeButton;

    private final Locator loadingBar;
    private final Locator checkbox;
    private final Locator message;
    private final Locator inputBox;
    private final Locator enableButton;

    public DynamicControlsPage() {

        removeButton = Driver.getPage().locator("//button[text()='Remove']");
        loadingBar=Driver.getPage().locator("#loading");
        checkbox=Driver.getPage().locator("input[type='checkbox']");
        message=Driver.getPage().locator("#message");
        inputBox=Driver.getPage().locator("//input[@type='text']");
        enableButton=Driver.getPage().locator("//button[.='Enable']");


    }
}
