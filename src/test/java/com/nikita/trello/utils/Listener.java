package com.nikita.trello.utils;

import com.google.common.io.Files;
import com.nikita.trello.tests.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listener implements ITestListener {


    static Logger logger = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + " Passed successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getName() + " failed\n" + result.getThrowable().toString());
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    public static void takeScreenshot() {
        File tmp = ((TakesScreenshot) TestBase.appMan.wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test/screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("\nCreated screenshot : " + screenshot.getAbsolutePath());
    }
}
