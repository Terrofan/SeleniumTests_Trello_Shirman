package com.nikita.trello;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;

    @BeforeSuite
    public void setUp() {
        wd = new ChromeDriver();
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

    public void selectPublicBoardType() {
        click(By.xpath("//button/span[@name='private']"));
        click(By.xpath("//span[@name='public']"));
        click(By.cssSelector("._3UeOvlU6B5KUnS._2MgouXHqRQDP_5._3ZPeWh5QQj47DA"));
    }

    public int getBoardsCount(){
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }
}
