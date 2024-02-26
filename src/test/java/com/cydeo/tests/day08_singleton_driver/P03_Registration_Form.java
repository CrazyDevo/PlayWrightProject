package com.cydeo.tests.day08_singleton_driver;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P03_Registration_Form {


    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration_form
        Driver.getPage().navigate(ConfigurationReader.getProperty("registration.form.url"));

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }


    @Test
    public void registration_form(){
        //3. Enter first name
        ElementHandle inputFirstName = Driver.getPage().querySelector("//input[@name='firstname']");
        inputFirstName.fill("JANE");

        //4. Enter last name
        ElementHandle inputLastName = Driver.getPage().querySelector("//input[@name='lastname']");
        inputLastName.fill("DOE");

        //5. Enter username
        ElementHandle inputUsername = Driver.getPage().querySelector("//input[@name='username']");
        inputUsername.fill("janedoe58");

        //6. Enter email address
        ElementHandle inputEmail = Driver.getPage().querySelector("//input[@name='email']");
        inputEmail.fill("janedoe@example.com");

        //7. Enter password
        ElementHandle inputPassword = Driver.getPage().querySelector("//input[@name='password']");
        inputPassword.fill("1234567890");

        //8. Enter phone number
        ElementHandle inputPhone = Driver.getPage().querySelector("//input[@name='phone']");
        inputPhone.fill("444-555-6666");

        //9. Select a gender from radio buttons
        ElementHandle radioButtonFemale = Driver.getPage().querySelector("//input[@value='female']");
        radioButtonFemale.click();

        //10.Enter date of birth
        ElementHandle inputBirthday = Driver.getPage().querySelector("//input[@name='birthday']");
        inputBirthday.fill("01/20/1980");

        //11.Select Department/Office
        ElementHandle departmentDropdown = Driver.getPage().querySelector("*[name='department']");
        //departmentDropdown.selectByVisibleText("Department of Engineering");
        departmentDropdown.selectOption(new SelectOption().setValue("DE"));

        //12.Select Job Title
        ElementHandle jobTitleDropdown = Driver.getPage().querySelector("*[name='job_title']");
        jobTitleDropdown.selectOption(new SelectOption().setLabel("SDET"));

        //13.Select programming language from checkboxes
        ElementHandle javaCheckbox = Driver.getPage().querySelector("//input[@value='java']");
        javaCheckbox.click();

        //14.Click to sign up button
        ElementHandle signUpButton = Driver.getPage().getByRole(AriaRole.BUTTON).elementHandle();
        signUpButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is displayed.
        ElementHandle successMessage = Driver.getPage().querySelector("//div[@role='alert']");
        Assertions.assertTrue(successMessage.isVisible());


    }



}
