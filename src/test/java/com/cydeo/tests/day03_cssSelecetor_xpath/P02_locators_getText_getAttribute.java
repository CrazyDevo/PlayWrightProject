package com.cydeo.tests.day03_cssSelecetor_xpath;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P02_locators_getText_getAttribute {

    @Test
    void test1() {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
        Page page = browser.newPage();



        //2- Go to: https://login1.nextbasecrm.com/
        page.navigate("https://login1.nextbasecrm.com/");
        //wait for page load
        page.waitForLoadState();

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedLabelText = "Remember me on this computer";
        String actualLabelText = page.querySelector(".login-item-checkbox-label").innerText();

        Assertions.assertEquals(expectedLabelText,actualLabelText);

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedForgotPasswordText = "FORGOT YOUR PASSWORD?";

        ElementHandle forgotPasswordLink = page.querySelector(".login-link-forgot-pass");

        String actualForgotPasswordText = forgotPasswordLink.innerText();


        Assertions.assertEquals(expectedForgotPasswordText,actualForgotPasswordText);

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualHrefValue = forgotPasswordLink.getAttribute("href");

        Assertions.assertTrue(actualHrefValue.contains(expectedInHref));


        BrowserUtils.sleep(4);
        page.close();
        browser.close();
        playwright.close();











    }
}
