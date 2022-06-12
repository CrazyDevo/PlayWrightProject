package org.example.day1_navigate_locator_click_fill;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InsertValue {
    Page page;
    Browser browser;
    @BeforeEach
    void setUp() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
     browser  = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void insertValue() throws InterruptedException {

        page.navigate("https://practice.cydeo.com/login");
        Locator username = page.locator("(//input)[1]");
        username.fill("Test");
        Locator password = page.locator("(//input)[2]");
        password.fill("Test");
        Locator loginButton = page.locator("#wooden_spoon");
        loginButton.click();


    }


}
