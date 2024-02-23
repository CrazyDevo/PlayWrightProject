package com.cydeo.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Driver {

    static private Playwright playwright;

    static private Browser browser;

    static private  Page page;


    public  static Page getPage(){
        String browserFromConfig=ConfigurationReader.getProperty("browser");

        if (page==null){

            switch (browserFromConfig.toLowerCase()){
                case "chrome":
                    playwright=Playwright.create();
                    BrowserType chromium = playwright.chromium();
                    browser=chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page= browser.newPage();
                    break;


                case "firefox":
                    playwright=Playwright.create();
                    BrowserType firefox = playwright.firefox();
                    browser=firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page= browser.newPage();
                    break;

                default:
                    playwright=Playwright.create();
                    BrowserType defaultChrome= playwright.chromium();
                    browser=defaultChrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page= browser.newPage();
                    break;

            }

        }

        return page;

    }


    public static void closeDriver(){

        if (page!=null){
            page.close();
            page=null;
            browser.close();
            browser=null;
            playwright=null;
        }

    }


}
