package com.nikita.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
        }
    }

    @Test
    public void testBoardNameModification() throws InterruptedException {
        appMan.getBoardHelper().clickOnBoard();
        String name = appMan.getHelperbase().getText(By.cssSelector(".js-board-editing-target.board-header-btn-text"));
        appMan.getBoardHelper().changeBoardName();
        Assert.assertEquals(appMan.getBoardHelper().getBoardsList().get(0).getText(),name + "/changed/");
    }
}
