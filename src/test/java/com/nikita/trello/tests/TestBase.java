package com.nikita.trello.tests;
import com.nikita.trello.fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    public static ApplicationManager appMan = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTestLog(Method m, Object[] parameter){
        logger.info("Start test : " + m.getName() + " with parameters " + Arrays.asList(parameter));
    }

    @AfterMethod
    public void stopTestLog(Method m){
        logger.info("Stop test : " + m.getName());
    }

    @BeforeSuite
    public void setUp() {
        appMan.init();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        appMan.stop();
    }

}
