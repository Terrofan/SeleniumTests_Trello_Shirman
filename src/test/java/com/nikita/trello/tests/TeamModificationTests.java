package com.nikita.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            appMan.getHelperbase().pause(5000);
        }
    }

    @Test
    public void modificationTeamName() throws Exception {
        if(appMan.getTeamHelper().getTeamsCount() == 0){
            throw new Exception("No existing teams were found");
        }
        appMan.getTeamHelper().clickOnFirstTeam();
        appMan.getTeamHelper().clickOnSettingsButton();
        appMan.getTeamHelper().clickEditTeamProfileButton();
        String nameBefore = appMan.getHelperbase().getText(By.cssSelector("[type='text'][name='displayName']"));
        String newName = nameBefore + "/changed/";
        appMan.getHelperbase().type(By.cssSelector("[type='text'][name='displayName']"), newName);
        appMan.getTeamHelper().clickSaveButton();
        appMan.getHelperbase().returnToHomePage();
        appMan.getTeamHelper().clickOnFirstTeam();
        String nameAfter = appMan.getHelperbase().getText(By.xpath("(//*[@data-test-id='home-team-tab-name'])[1]"));
        Assert.assertEquals(nameAfter, newName);





    }
}
