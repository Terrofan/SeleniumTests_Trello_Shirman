package com.nikita.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            clickLoginLink();
            fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            pause(5000);
        }
    }

    @Test
    public void createPrivateBoardTest() throws InterruptedException {
        String boardName = "QA22" + System.currentTimeMillis();
        int before = getBoardsCount();
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm(boardName);
        confirmCreation();
        pause(5000);
        Assert.assertEquals(ApplicationManager.wd.findElement(By.xpath("//div/span[@dir='auto']")).getText(),boardName);
        returnToHomePage();
        int actualResult = getBoardsCount();
        Assert.assertEquals(actualResult,before + 1);
    }

    @Test
    public void createPublicBoardTest() throws InterruptedException {
        String boardName = "QA22" + System.currentTimeMillis();
        int before = getBoardsCount();
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm(boardName);
        selectPublicBoardType();
        confirmCreation();
        pause(5000);
        Assert.assertEquals(ApplicationManager.wd.findElement(By.xpath("//div/span[@dir='auto']")).getText(),boardName);
        returnToHomePage();
        int actualResult = getBoardsCount();
        Assert.assertEquals(actualResult,before + 1);
    }

}
