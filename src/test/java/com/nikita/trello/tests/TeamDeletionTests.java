package com.nikita.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!appMan.getSessionHelper().isAvatarPresentOnHeader()) {
            appMan.getSessionHelper().clickLoginLink();
            appMan.getSessionHelper().fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            appMan.getHelperbase().pause(5000);
        }
    }

    @Test
    public void teamDeletionTest() throws Exception {
      if(appMan.getTeamHelper().getTeamsCount() == 0){
          throw new Exception("No existing teams were found");
      }
      int nTeamsBefore = appMan.getTeamHelper().getTeamsCount();

      appMan.getTeamHelper().clickOnFirstTeam();
      appMan.getTeamHelper().clickOnSettingsButton();
      appMan.getTeamHelper().clickOnDeleteThisTeamButton();
      appMan.getTeamHelper().submitDeleteForever();
      appMan.getHelperbase().returnToHomePage();

      Assert.assertEquals(appMan.getTeamHelper().getTeamsCount(), nTeamsBefore - 1);

    }


}
