package com.nikita.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
        }
    }

    @Test
    public void deleteBoardTest() throws Exception {
        int nBoardsBefore = appMan.getBoardHelper().getBoardsCount();
        if (nBoardsBefore > 1) {
            appMan.getBoardHelper().deleteBoard();
        } else
            throw new Exception("No existing boards were found");
        appMan.getSessionHelper().returnToHomePage();
        int nBoardsAfter = appMan.getBoardHelper().getBoardsCount();
        Assert.assertEquals(nBoardsAfter, nBoardsBefore - 1);
    }

    @Test (enabled = false)// deletes all existing boards
    public void deleteAllBoardsTest() throws Exception {
        if (appMan.getBoardHelper().getBoardsCount() <= 1) {
            throw new Exception("No existing boards were found");
        }
        while (appMan.getBoardHelper().getBoardsCount() > 1) {
            appMan.getBoardHelper().deleteBoard();
            appMan.getBoardHelper().returnToHomePage();
        }
        Assert.assertTrue(appMan.getBoardHelper().getBoardsCount() == 1);
    }


}
