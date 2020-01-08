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
        clickOnPlusButton();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("teamName", "teamDesc");
        submitTeamCreation();
        if(isElementPresent(By.cssSelector("[name='close']"))) {
            closeInviteToTheTeamForm();
        }
        Assert.assertTrue(isElementPresent(By.cssSelector("[data-test-id='home-team-tab-name']")));
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    private void closeInviteToTheTeamForm() {
        click(By.cssSelector("[name='close']"));
    }

    private void fillTeamCreationForm(String teamName, String teamDesc) throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
        type(By.cssSelector("[id$='description']"), teamDesc);
    }

    private void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id = 'header-create-team-button']"));

    }
}
