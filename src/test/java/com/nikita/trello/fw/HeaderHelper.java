package com.nikita.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
