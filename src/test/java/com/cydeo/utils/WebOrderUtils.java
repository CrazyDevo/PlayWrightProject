package com.cydeo.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class WebOrderUtils {

    public static String returnOrderDate(Page page, String customerName){

        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";

        ElementHandle customerDateCell = page.querySelector(locator);

        return customerDateCell.innerText();

    }

    public static void orderVerify(Page page, String costumerName, String expectedOrderDate){

        String locator = "//td[.='"+ costumerName + "']/following-sibling::td[3]";

        ElementHandle customerDateCell = page.querySelector(locator);

        String actualOrderDate = customerDateCell.innerText();

        Assertions.assertEquals(expectedOrderDate, actualOrderDate);

    }
}
