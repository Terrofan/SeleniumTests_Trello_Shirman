package com.nikita.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            clickLoginLink();
            fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
            pause(5000);
        }
    }

    @Test
    public void createPrivateBoardTest() throws InterruptedException {
        String name = "TestBoard3";
        click(By.xpath("//span[@name='add']"));
        click(By.xpath("//span[@name='board']/..//p"));
        type(By.cssSelector("[data-test-id='create-board-title-input']"), name);
        click(By.xpath("//button/span[@name='private']"));
        click(By.xpath("//button/span/span[@name='private']"));
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        pause(5000);
        Assert.assertEquals(wd.findElement(By.xpath("//div/span[@dir='auto']")).getText(),name);
    }

    @Test
    public void createPublicBoardTest() throws InterruptedException {
        String name = "TestBoard4";
        click(By.xpath("//span[@name='add']"));
        click(By.xpath("//span[@name='board']/..//p"));
        type(By.cssSelector("[data-test-id='create-board-title-input']"), name);
        click(By.xpath("//button/span[@name='private']"));
        click(By.xpath("//span[@name='public']"));
        click(By.cssSelector("._3UeOvlU6B5KUnS._2MgouXHqRQDP_5._3ZPeWh5QQj47DA"));
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        pause(5000);
        Assert.assertEquals(wd.findElement(By.xpath("//div/span[@dir='auto']")).getText(),name);
    }
}
