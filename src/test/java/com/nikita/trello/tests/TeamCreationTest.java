package com.nikita.trello.tests;
import com.nikita.trello.models.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTest extends TestBase{
    @DataProvider
    public Iterator<Object[]> validTeams(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name DP","description"});
        list.add(new Object[]{"DPn",""});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validTeamsCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/teamsPositiveCsv.csv")));
        String line = reader.readLine();
        while(line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new TeamData().setTeamName(split[0]).setTeamDesc(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            appMan.getHelperbase().pause(5000);
        }
    }

    @Test(dataProvider = "validTeams")
    public void teamCreationTestFromHeaderWithDP(String teamName, String teamDesc) throws InterruptedException {
        int teamCountBefore =  appMan.getTeamHelper().getTeamsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getTeamHelper().selectCreateTeamFromDropDown();
        appMan.getTeamHelper().fillTeamCreationForm(new TeamData().setTeamName(teamName).setTeamDesc(teamDesc));
        appMan.getTeamHelper().submitTeamCreation();
        appMan.getTeamHelper().clickLaterButton();
        appMan.getSessionHelper().returnToHomePage();
        int teamCountAfter = appMan.getTeamHelper().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
        appMan.getSessionHelper().returnToHomePage();
    }

    @Test(dataProvider = "validTeamsCSV")
    public void teamCreationTestFromHeaderWithDPCSV(TeamData team) throws InterruptedException {
        int teamCountBefore =  appMan.getTeamHelper().getTeamsCount();
        appMan.getBoardHelper().clickOnPlusButton();
        appMan.getTeamHelper().selectCreateTeamFromDropDown();
        appMan.getTeamHelper().fillTeamCreationForm(team);
        appMan.getTeamHelper().submitTeamCreation();
        appMan.getTeamHelper().clickLaterButton();
        appMan.getSessionHelper().pause(3000);
        appMan.getSessionHelper().returnToHomePage();
        int teamCountAfter = appMan.getTeamHelper().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
        appMan.getSessionHelper().returnToHomePage();
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
