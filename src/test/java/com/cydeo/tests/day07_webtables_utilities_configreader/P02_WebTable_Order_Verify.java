package com.cydeo.tests.day07_webtables_utilities_configreader;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.WebOrderUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P02_WebTable_Order_Verify {

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
        //2. Go to: https://practice.cydeo.com/web-tables
        page.navigate("https://practice.cydeo.com/web-tables");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.sleep(3);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void order_verify_name_test(){

        //2. VerifyBob’s name is listed as expected.
        //below locator is locating me the Bob Martin's cell as where it is currently stored.
        //table[@class='SampleTable']/tbody/tr[7]/td[2]

        //locate Bob's cell using its name as the text.
        String locator = "//table[@class='SampleTable']//td[.='Bob Martin']";
        ElementHandle bobsCell = page.querySelector(locator);

        System.out.println("bobsCell.getText() = " + bobsCell.innerText());

        //Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName = bobsCell.innerText();

        Assertions.assertEquals(expectedName, actualName, "Names are not matching!");

        //3. VerifyBobMartin’s order date is as expected.
        //WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        ElementHandle bobsOrderDate =
                page.querySelector("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]");

        //Expected: 12/31/2021
        String expectedDate = "12/31/2021";
        String actualDate = bobsOrderDate.innerText();

        Assertions.assertEquals(expectedDate, actualDate);



    }

    @Test
    public void test2_use_order_verify_method(){

        //call the utility method we created
        String alexandraGray = WebOrderUtils.returnOrderDate(page, "Alexandra Gray");
        System.out.println("alexandraGray = " + alexandraGray);

        String bartFisher = WebOrderUtils.returnOrderDate(page, "Bart Fisher");
        System.out.println("bartFisher = " + bartFisher);

    }

    @Test
    public void test3(){

        WebOrderUtils.orderVerify(page, "Bob Martin", "12/31/2021");

    }

}
