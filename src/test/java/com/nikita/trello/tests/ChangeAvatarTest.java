package com.nikita.trello.tests;

import com.nikita.trello.utils.Listener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            appMan.getHelperbase().pause(5000);
        }
    }

    @Test
    public void testChangeAvatar() throws InterruptedException {
        logger.info("avatar before");
        Listener.takeScreenshot();
        appMan.getHeaderHelper().clickOnAvatar();
        appMan.getSessionHelper().openUserProfileFromDropDown();
        appMan.getSessionHelper().goToAtlassianAccount();
        appMan.getSessionHelper().addAvatarImage();
        logger.info("avatar after:");
        Listener.takeScreenshot();

    }

}
