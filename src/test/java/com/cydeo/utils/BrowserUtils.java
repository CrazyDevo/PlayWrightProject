package com.cydeo.utils;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class BrowserUtils {

    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){

        }
    }

    public static void verifyTitle(Page page, String expectedTitle) {
        Assertions.assertEquals(expectedTitle,page.title());
    }
}
