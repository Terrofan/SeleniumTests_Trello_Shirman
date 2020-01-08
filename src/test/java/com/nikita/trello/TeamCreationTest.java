package com.nikita.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            clickLoginLink();
            fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            pause(5000);
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int teamCountBefore =  getTeamsCount();
        clickOnPlusButton();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("teamName", "teamDesc");
        submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))) {
//            closeInviteToTheTeamForm();
//        }
        clickLaterButton();
        int teamCountAfter = getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }

}
