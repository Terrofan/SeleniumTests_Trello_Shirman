package com.nikita.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeSuite
    public void setUp() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();
    }

    public void fillLoginFormAtlassian(String email, String password) throws InterruptedException {
        type(By.id("user"), email);
        click(By.id("login"));
        click(By.id("login-submit"));
        type(By.id("password"), password);
        click(By.id("login-submit"));
    }

    public void fillLoginFormOld(String email, String password) throws InterruptedException {
        type(By.id("user"), email);
        type(By.id("password"), password);
        click(By.id("login"));
    }

    public void clickLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) throws InterruptedException {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
        Thread.sleep(5000);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
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

    public void clickOnPlusButton() {
        click(By.xpath("//span[@name='add']"));
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

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
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

    public void clickLaterButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='show-later-button']"));
        pause(1000);
    }

    public int getTeamsCount() {
        int nTeams = wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
        return nTeams;
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
}
