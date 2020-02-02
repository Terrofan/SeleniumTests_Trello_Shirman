package com.nikita.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.ArrayList;

public class SessionHelper extends Helperbase{
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void fillLoginFormAtlassian(String email, String password) throws InterruptedException {
        type(By.id("user"), email);
        click(By.id("login"));
        click(By.id("login-submit"));
        WebElement passwordField = wd.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
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

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void openUserProfileFromDropDown() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianAccount() {
        click(By.cssSelector("[href $=manage-profile]"));
        ArrayList<String> availableTabs = new ArrayList<> (wd.getWindowHandles());
        if(!availableTabs.isEmpty()){
            wd.switchTo().window(availableTabs.get(1));
        }

    }

    public void addAvatarImage() throws InterruptedException {

            new Actions(wd)
                    .moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).perform();
            click(By.cssSelector("[data-test-selector='profile-hover-info']"));
            if (isElementPresent(By.cssSelector("[role=menu]"))) {
                click(By.xpath("//*[@role='menu']//span[@role='menuitem'][1]"));
            }
            attach(By.id("image-input"), new File("C:/Users/Elena/Documents/GitHub/trello-selenium-tests-Rochman/src/test/resources/2014-03-22 10.57.26.jpg"));
            click(By.xpath("//*[contains(text(),'Upload')]"));
            pause(5000);
            wd.close();
            pause(3000);
            ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
            if (!availableWindows.isEmpty()) {
                wd.switchTo().window(availableWindows.get(0));
                pause(5000);
                wd.navigate().refresh();
                pause(5000);
            }
    }
}
