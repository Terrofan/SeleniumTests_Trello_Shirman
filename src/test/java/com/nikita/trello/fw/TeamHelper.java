package com.nikita.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TeamHelper extends Helperbase{
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void clickLaterButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='show-later-button']"));
        pause(1000);
    }

    public int getTeamsCount() {
        int nTeams = getTeamsArray().size();
        return nTeams;
    }

    public List<WebElement> getTeamsArray() {
        return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]"));
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void closeInviteToTheTeamForm() {
        click(By.cssSelector("[name='close']"));
    }

    public void fillTeamCreationForm(String teamName, String teamDesc) throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("[id$='description']"), teamDesc);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id = 'header-create-team-button']"));

    }

    public void clickOnFirstTeam() {
        getTeamsArray().get(0).click();
    }

    public void clickOnSettingsButton() {
        click(By.cssSelector(".icon-gear.icon-sm._2aV_KY1gTq1qWc"));
    }

    public void clickOnDeleteThisTeamButton() {
        click(By.cssSelector(".quiet-button"));
    }

    public void submitDeleteForever() {
        click(By.xpath("//*[@value='Delete Forever']"));
    }

    public void clickEditTeamProfileButton() {
        click(By.cssSelector(".button-link.tabbed-pane-header-details-edit.js-edit-profile"));

    }

    public void clickSaveButton() {
        click(By.cssSelector("[value='Save']"));
    }
}
