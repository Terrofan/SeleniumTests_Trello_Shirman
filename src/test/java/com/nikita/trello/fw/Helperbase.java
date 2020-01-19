package com.nikita.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helperbase {
    WebDriver wd;
    WebDriverWait wait;
    public Helperbase(WebDriver wd){
        this.wd = wd;
        wait = new WebDriverWait(wd, 20);
    }


    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) throws InterruptedException {
        if(text != null){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
            Thread.sleep(5000);
        }

    }

    public String getText(By locator) {
        return wd.findElement(locator).getText();
    }
    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//span[@name='add']"));
    }



}
