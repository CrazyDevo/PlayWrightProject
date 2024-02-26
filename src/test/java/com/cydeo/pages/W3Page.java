package com.cydeo.pages;

import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class W3Page {

    private final Locator paragraph;

    public W3Page() {
        this.paragraph = setParagraph();
    }

    public Locator setParagraph() {
      return   Driver.getPage().frame("iframeResult").locator("#demo");
    }
}
