package com.nikita.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends Helperbase{
    public SessionHelper(WebDriver wd) {
        super(wd);
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

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }
}
