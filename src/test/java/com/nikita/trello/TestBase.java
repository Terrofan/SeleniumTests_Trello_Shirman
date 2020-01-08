package com.nikita.trello;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;

public class TestBase {

    protected static ApplicationManager applicationManager = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        init();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        stop();
    }


    public void init() {
        applicationManager.init();
    }

    public void stop() throws InterruptedException {
        applicationManager.stop();
    }

    public void fillLoginFormAtlassian(String email, String password) throws InterruptedException {
        applicationManager.fillLoginFormAtlassian(email, password);
    }

    public void fillLoginFormOld(String email, String password) throws InterruptedException {
        applicationManager.fillLoginFormOld(email, password);
    }

    public void clickLoginLink() {
        applicationManager.clickLoginLink();
    }

    public void click(By locator) {
        applicationManager.click(locator);
    }

    public void type(By locator, String text) throws InterruptedException {
        applicationManager.type(locator, text);
    }

    public boolean isElementPresent(By locator) {
        return applicationManager.isElementPresent(locator);
    }

    public void pause(int millis) throws InterruptedException {
        applicationManager.pause(millis);
    }

    public boolean isAvatarPresentOnHeader() {
        return applicationManager.isAvatarPresentOnHeader();
    }

    public void logout() {
        applicationManager.logout();
    }

    public void confirmCreation() {
        applicationManager.confirmCreation();
    }

    public void fillBoardForm(String boardName) throws InterruptedException {
        applicationManager.fillBoardForm(boardName);
    }

    public void selectCreateBoardFromDropDown() {
        applicationManager.selectCreateBoardFromDropDown();
    }

    public void clickOnPlusButton() {
        applicationManager.clickOnPlusButton();
    }

    public void selectPublicBoardType() {
        applicationManager.selectPublicBoardType();
    }

    public int getBoardsCount() {
        return applicationManager.getBoardsCount();
    }

    public void returnToHomePage() {
        applicationManager.returnToHomePage();
    }

    public List<WebElement> getBoardsList() {
        return applicationManager.getBoardsList();
    }

    public void deleteBoard() throws InterruptedException {
        applicationManager.deleteBoard();
    }

    public void clickLaterButton() throws InterruptedException {
        applicationManager.clickLaterButton();
    }

    public int getTeamsCount() {
        return applicationManager.getTeamsCount();
    }

    public void submitTeamCreation() {
        applicationManager.submitTeamCreation();
    }

    public void closeInviteToTheTeamForm() {
        applicationManager.closeInviteToTheTeamForm();
    }

    public void fillTeamCreationForm(String teamName, String teamDesc) throws InterruptedException {
        applicationManager.fillTeamCreationForm(teamName, teamDesc);
    }

    public void selectCreateTeamFromDropDown() {
        applicationManager.selectCreateTeamFromDropDown();
    }
}
