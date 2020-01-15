package com.nikita.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BoardHelper extends Helperbase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName) throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//span[@name='board']/..//p"));
    }



    public void selectPublicBoardType() throws InterruptedException {
        selectNoTeamType();
        click(By.xpath("(//span[@name='down'])[2]")); //clicks on the second drop-down list with type of the boards
        click(By.xpath("//span[@name='public']")); //selects public type
        pause(1000);
        click(By.cssSelector("._3UeOvlU6B5KUnS._2MgouXHqRQDP_5._3ZPeWh5QQj47DA"));//"Yes, Make Board Public" button
    }

    public void selectNoTeamType() {
        click(By.xpath("(//span[@name='down'])[1]"));// clicks on first drop down list with "TeamNames"
        click(By.xpath("(//div/nav/ul/li)[1]")); // selects "No team" option
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public List<WebElement> getBoardsList() { //returns list of all existing boards
        List<WebElement> boardsList = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
        return boardsList;
    }

    public void deleteBoard() throws InterruptedException {
        String title = getBoardsList().get(0).getText(); // returns a title of first board from all existing boards
        click(By.xpath("//div[@title='" + title + "']")); // selects this(first) board by title
        if (wd.findElements(By.cssSelector(".board-header-btn-icon.icon-sm.icon-public")).size() != 0) { // checks if a current board is public
            click(By.cssSelector(".board-header-btn-icon.icon-sm.icon-public")); // switching the type
            click(By.cssSelector(".icon-sm.vis-icon.icon-private")); //             of the current board to private
            wd.navigate().refresh();
            pause(3000);
        }
        click(By.cssSelector(".js-open-more"));
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm.full.negate"));
        pause(2000);
        click(By.cssSelector(".quiet.js-delete"));
        click(By.cssSelector("[type='submit']"));
        pause(2000);
    }

    public void clickOnBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
    }

    public void changeBoardName() throws InterruptedException {
        String name = getText(By.cssSelector(".js-board-editing-target.board-header-btn-text"));
        name = name + "/changed/";
        click(By.cssSelector(".js-board-editing-target.board-header-btn-text"));
        pause(2000);
        wd.findElement(By.cssSelector(".board-name-input.js-board-name-input")).sendKeys(name);
        returnToHomePage();

    }
}
