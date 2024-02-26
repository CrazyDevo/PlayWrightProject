package com.cydeo.tests.day09_upload_actions_jsexecutor;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class P01_Upload_Practice {

    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //2. Go to https://practice.cydeo.com/upload
        Driver.getPage().navigate("https://practice.cydeo.com/upload");

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

    @Test
    public void uploading_test() throws URISyntaxException {

        //2. Find some small file from your computer, and get the path of it.
        String path = System.getProperty("user.dir")+"/src/test/resources/files/file.txt";

        System.out.println("path = " + path);

        //3. Find the element to upload
        ElementHandle chooseFileButton = Driver.getPage().querySelector("#file-upload");
        BrowserUtils.sleep(2);
/*
        // Select multiple files
        page.getByLabel("Upload files").setInputFiles(new Path[] {Paths.get("file1.txt"), Paths.get("file2.txt")});

// Remove all the selected files
page.getByLabel("Upload file").setInputFiles(new Path[0]);
 */


        //This is the line that is passing the path of the file to website
        chooseFileButton.setInputFiles(Paths.get(path));
        BrowserUtils.sleep(2);

        ElementHandle uploadButton = Driver.getPage().querySelector("#file-submit");

        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        ElementHandle fileUploadedHeader = Driver.getPage().querySelector("//h3");
        Assertions.assertTrue(fileUploadedHeader.isVisible(), "Header text is not displayed!!!");
    }



}
