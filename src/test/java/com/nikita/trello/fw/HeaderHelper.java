package com.nikita.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderHelper extends Helperbase {
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//span[@name='add']"));
    }

    public void clickOnAvatar() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test-id='header-member-menu-button']")));
        returnToHomePage();
        pause(5000);
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }
}
