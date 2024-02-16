package com.cydeo.utils;

public class BrowserUtils {

    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){

        }
    }
}
