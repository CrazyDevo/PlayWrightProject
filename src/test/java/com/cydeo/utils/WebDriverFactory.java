package com.cydeo.utils;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;


public class WebDriverFactory {
    public static BrowserType getDriver(String browserType, Playwright playwright){

        if (browserType.equalsIgnoreCase("chrome")){
           return playwright.chromium();

        }else if(browserType.equalsIgnoreCase("firefox")){
          return   playwright.firefox();

        }else{
            System.out.println("Given string doesn't represent any browser.");
            System.out.println("Either that browser does not exist or not currently supported.");
            System.out.println("driver = null");
            return null;
        }
    }
}
