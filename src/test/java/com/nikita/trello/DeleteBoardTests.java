package com.nikita.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteBoardTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            clickLoginLink();
            fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
        }
    }

    @Test
    public void deleteBoardTest() throws Exception {
        int nBoardsBefore = getBoardsCount();
        if (nBoardsBefore > 1) {
            deleteBoard();
        } else
            throw new Exception("No existing boards were found");
        returnToHomePage();
        int nBoardsAfter = getBoardsCount();
        Assert.assertEquals(nBoardsAfter, nBoardsBefore - 1);
    }

    @Test (enabled = false)// deletes all existing boards
    public void deleteAllBoardsTest() throws Exception {
        if (getBoardsCount() <= 1) {
            throw new Exception("No existing boards were found");
        }
        while (getBoardsCount() > 1) {
            deleteBoard();
            returnToHomePage();
        }
        Assert.assertTrue(getBoardsCount() == 1);
    }


}
