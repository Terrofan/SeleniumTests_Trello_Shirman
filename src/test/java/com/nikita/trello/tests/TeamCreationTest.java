package com.nikita.trello.tests;

import com.nikita.trello.models.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            appMan.getHelperbase().pause(5000);
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int teamCountBefore =  appMan.getTeamHelper().getTeamsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getTeamHelper().selectCreateTeamFromDropDown();
        appMan.getTeamHelper().fillTeamCreationForm(new TeamData().setTeamName("teamName").setTeamDesc("teamDesc"));
        appMan.getTeamHelper().submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))) {
//            closeInviteToTheTeamForm();
//        }
        appMan.getTeamHelper().clickLaterButton();
        appMan.getSessionHelper().returnToHomePage();
        int teamCountAfter = appMan.getTeamHelper().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }

    @Test
    public void teamCreationTestFromHeaderWithNameOnly() throws InterruptedException {
        int teamCountBefore =  appMan.getTeamHelper().getTeamsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getTeamHelper().selectCreateTeamFromDropDown();
        appMan.getTeamHelper().fillTeamCreationForm(new TeamData().setTeamName("teamName"));
        appMan.getTeamHelper().submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))) {
//            closeInviteToTheTeamForm();
//        }
        appMan.getTeamHelper().clickLaterButton();
        appMan.getSessionHelper().returnToHomePage();
        int teamCountAfter = appMan.getTeamHelper().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }

}
