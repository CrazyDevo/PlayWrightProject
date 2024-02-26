package com.cydeo.pages;

import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class DynamicLoad7Page {

    private final Locator doneMessage;

    private final Locator spongeBobImage;


    public DynamicLoad7Page() {

        doneMessage = Driver.getPage().locator("//strong[.='Done!']");
        spongeBobImage=Driver.getPage().locator("img[alt='square pants']");


    }
}
