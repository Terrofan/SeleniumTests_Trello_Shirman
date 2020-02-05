package com.nikita.trello.tests;

import com.nikita.trello.models.BoardData;
import com.nikita.trello.models.TeamData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            appMan.getHelperbase().pause(5000);
        }
    }

    @Test (enabled = false, dataProvider = "validBoardsCSV", dataProviderClass = DataProviders.class)
    public void createPrivateBoardTestCSV(BoardData board) throws InterruptedException {
        int before = appMan.getBoardHelper().getBoardsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getBoardHelper().selectCreateBoardFromDropDown();
        appMan.getBoardHelper().fillBoardForm(board);
        appMan.getBoardHelper().selectNoTeamType();
        appMan.getBoardHelper().confirmCreation();
        appMan.getHelperbase().pause(5000);
        Assert.assertEquals(appMan.getHelperbase().getText(By.xpath("//div/span[@dir='auto']")),board.getBoardName());
        appMan.getSessionHelper().returnToHomePage();
        int actualResult = appMan.getBoardHelper().getBoardsCount();
        Assert.assertEquals(actualResult,before + 1);
    }

    @Test
    public void createPrivateBoardTest() throws InterruptedException {
        String boardName = "QA22" + System.currentTimeMillis();
        int before = appMan.getBoardHelper().getBoardsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getBoardHelper().selectCreateBoardFromDropDown();
        appMan.getBoardHelper().fillBoardForm(new BoardData().setBoardName(boardName));
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
        appMan.getBoardHelper().fillBoardForm(new BoardData().setBoardName(boardName));
        appMan.getBoardHelper().selectPublicBoardType();
        appMan.getBoardHelper().confirmCreation();
        appMan.getHelperbase().pause(5000);
        Assert.assertEquals(appMan.getHelperbase().getText(By.xpath("//div/span[@dir='auto']")),boardName);
        appMan.getSessionHelper().returnToHomePage();
        int actualResult = appMan.getBoardHelper().getBoardsCount();
        Assert.assertEquals(actualResult,before + 1);
    }

}
