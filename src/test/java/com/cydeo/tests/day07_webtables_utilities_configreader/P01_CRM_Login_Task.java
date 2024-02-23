package com.cydeo.tests.day07_webtables_utilities_configreader;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.CRM_Utilities;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P01_CRM_Login_Task {


    Page page;
    Playwright playwright;
    Browser browser;


    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //1. Open Chrome browser
        playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        page = browser.newContext().newPage();
        //2. Go to: https://login1.nextbasecrm.com/
        page.navigate("https://login1.nextbasecrm.com/");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void test1_crm_login(){
        //3. Enter valid username
        ElementHandle inputUsername = page.querySelector("//input[@name='USER_LOGIN']");
        inputUsername.fill("helpdesk1@cydeo.com");

        //4. Enter valid password
        ElementHandle inputPassword = page.querySelector("//input[@name='USER_PASSWORD']");
        inputPassword.fill("UserUser");

        //5. Click to`LogIn`button
        ElementHandle loginButton = page.querySelector("//input[@value='Log In']");
        loginButton.click();

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(page, "Portal");

    }

    @Test
    public void test2_crm_login(){

        //Logging in using the utility method we created in CRM_Utilities class
        CRM_Utilities.login_crm(page);

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(page, "Portal");

    }


    @Test
    public void test3_crm_login(){

        //Logging in using the utility method we created in CRM_Utilities class
        //CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");
        CRM_Utilities.login_crm(page, "helpdesk2@cydeo.com", "UserUser");

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(page, "(6) Portal");

    }
}
