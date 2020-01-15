package com.nikita.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            appMan.getHelperbase().pause(5000);
        }
    }

    @Test
    public void createPrivateBoardTest() throws InterruptedException {
        String boardName = "QA22" + System.currentTimeMillis();
        int before = appMan.getBoardHelper().getBoardsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getBoardHelper().selectCreateBoardFromDropDown();
        appMan.getBoardHelper().fillBoardForm(boardName);
        appMan.getBoardHelper().selectNoTeamType();
        appMan.getBoardHelper().confirmCreation();
        appMan.getHelperbase().pause(5000);
        Assert.assertEquals(appMan.getHelperbase().getText(By.xpath("//div/span[@dir='auto']")),boardName);
        appMan.getSessionHelper().returnToHomePage();
        int actualResult = appMan.getBoardHelper().getBoardsCount();
        Assert.assertEquals(actualResult,before + 1);
    }

    @Test
    public void createPublicBoardTest() throws InterruptedException {
        String boardName = "QA22" + System.currentTimeMillis();
        int before = appMan.getBoardHelper().getBoardsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getBoardHelper().selectCreateBoardFromDropDown();
        appMan.getBoardHelper().fillBoardForm(boardName);
        appMan.getBoardHelper().selectPublicBoardType();
        appMan.getBoardHelper().confirmCreation();
        appMan.getHelperbase().pause(5000);
        Assert.assertEquals(appMan.getHelperbase().getText(By.xpath("//div/span[@dir='auto']")),boardName);
        appMan.getSessionHelper().returnToHomePage();
        int actualResult = appMan.getBoardHelper().getBoardsCount();
        Assert.assertEquals(actualResult,before + 1);
    }

}
