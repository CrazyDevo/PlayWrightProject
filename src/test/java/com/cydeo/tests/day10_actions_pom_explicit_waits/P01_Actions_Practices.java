package com.cydeo.tests.day10_actions_pom_explicit_waits;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class P01_Actions_Practices {

    @BeforeEach
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getPage().navigate("https://practice.cydeo.com/drag_and_drop_circles");

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }



    @Test
    public void test1_default_value_verification(){
        //TC1 #: Drag and drop default value verification

        //2. Verify big circle default text is as below.
        ElementHandle bigCircle = Driver.getPage().querySelector("#droptarget");

        //3. Assert:
        //-Text in big circle by default is: “Drag the small circle here.”
        String expectedText = "Drag the small circle here.";
        String actualBigCircleText = bigCircle.innerText();

        assertTrue(actualBigCircleText.equals(expectedText));
    }


    @Test
    public void test2_drop_into_the_big_circle(){
        //TC2 #: Drag and drop into the big circle

        //Locating the circle web elements
        Locator bigCircle = Driver.getPage().locator("#droptarget");
        Locator smallCircle = Driver.getPage().locator("#draggable");


        //2. Drag and drop the small circle to bigger circle.

        smallCircle.dragTo(bigCircle);

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String expectedText = "You did great!";
        String actualBigCircleText = bigCircle.innerText();

        assertTrue(actualBigCircleText.equals(expectedText));
    }




    @Test
    public void test3_click_and_hold_small_circle(){
        //TC2 #: Drag and drop into the  cydeo link
        // Find the elements smallCircle and bigCircle
        Locator smallCircle = Driver.getPage().locator("#draggable");
        Locator bigCircle = Driver.getPage().locator("#droptarget");


        //2. Drag and drop the small circle to bigger circle.
       // smallCircle.dragTo(bigCircle);
        Locator cydeoLink = Driver.getPage().locator("text=CYDEO");

        // Simulate click and hold on smallCircle
        smallCircle.hover();
        Driver.getPage().mouse().down();
        BrowserUtils.sleep(1); // Pause for 1 second

        // Move to bigCircle
        cydeoLink.hover();
        BrowserUtils.sleep(1); // Pause for 1 second


        //3. Assert:
        //-Text in big circle changed to: "Now drop..."

        String actualBigCircleText = bigCircle.innerText();
        System.out.println("actualBigCircleText = " + actualBigCircleText);
        BrowserUtils.sleep(3);

        //3. Assert:
        //-Text in big circle changed to: ““Drop here.”
        String expectedText = "Drop here.";
        assertTrue(actualBigCircleText.equals(expectedText));

    }


    @Test
    public void test4_drop_outside_of_big_circle(){
        //TC4 #: Click and hold

        //Locating the circle web elements
        Locator bigCircle = Driver.getPage().locator("#droptarget");
        Locator smallCircle = Driver.getPage().locator("#draggable");



        //2. Drag and drop the small circle to bigger circle.
       // smallCircle.dragTo(bigCircle);


        Locator cydeoLink = Driver.getPage().locator("text=CYDEO");

        smallCircle.dragTo(cydeoLink);


        //3. Assert:
        //-Text in big circle changed to: ““Drop here.”
        String expectedText = "Try again!";
        String actualBigCircleText = bigCircle.innerText();
        System.out.println("expectedText = " + expectedText);
        System.out.println("actualBigCircleText = " + actualBigCircleText);

        assertTrue(actualBigCircleText.equals(expectedText));
    }

    @Test
    public void test5_big_circle_hovering_text_verify(){
        //TC5 #:

        // Find the elements smallCircle and bigCircle
        Locator smallCircle = Driver.getPage().locator("#draggable");
        Locator bigCircle = Driver.getPage().locator("#droptarget");

        if (smallCircle == null || bigCircle == null) {
            System.out.println("Elements not found.");
            return;
        }

        // Simulate click and hold on smallCircle
        smallCircle.hover();
        Driver.getPage().mouse().down();
        BrowserUtils.sleep(1); // Pause for 1 second

        // Move to bigCircle
        bigCircle.hover();
        BrowserUtils.sleep(1); // Pause for 1 second


        //3. Assert:
        //-Text in big circle changed to: "Now drop..."

        String actualBigCircleText = bigCircle.innerText();
        System.out.println("actualBigCircleText = " + actualBigCircleText);
        BrowserUtils.sleep(3);

        // Release the mouse button
        Driver.getPage().mouse().up();

        String expectedText = "Now drop...";


        assertTrue(actualBigCircleText.equals(expectedText));
    }
}
