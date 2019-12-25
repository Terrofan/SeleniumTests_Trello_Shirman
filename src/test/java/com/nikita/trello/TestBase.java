package com.nikita.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    public void clickLoginLink(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        fillLoginForm(By.id("user"), email);
        click(By.id("login"));
        click(By.id("login-submit"));
        fillLoginForm(By.id("password"), password);
        click(By.id("login-submit"));

    }

    public void fillLoginForm(By locator, String text) throws InterruptedException {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
        Thread.sleep(5000);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();

    }
}
