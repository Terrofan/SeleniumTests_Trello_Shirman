package com.nikita.trello.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(appMan.getSessionHelper().isAvatarPresentOnHeader()){
            appMan.getSessionHelper().logout();
        }
    }

    @Test
    public void testLogInAtlassian() throws InterruptedException {
        // Atlassian login
        appMan.getSessionHelper().clickLoginLink();
        appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
        appMan.getHelperbase().pause(7000);
        Assert.assertTrue(appMan.getSessionHelper().isAvatarPresentOnHeader());
    }

    @Test(enabled = false)
    public void testLogInOld() throws InterruptedException {
        // Old login
        appMan.getSessionHelper().clickLoginLink();
        appMan.getSessionHelper().fillLoginFormOld("shirmannik@gmail.com", "5457den5457");
        appMan.getHelperbase().pause(5000);
        Assert.assertTrue(appMan.getSessionHelper().isAvatarPresentOnHeader());
    }


}
