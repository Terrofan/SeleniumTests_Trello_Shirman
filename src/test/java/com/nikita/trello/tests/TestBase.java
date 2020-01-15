package com.nikita.trello.tests;
import com.nikita.trello.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager appMan = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        appMan.init();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        appMan.stop();
    }

}
