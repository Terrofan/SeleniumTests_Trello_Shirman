package com.nikita.trello;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(isAvatarPresentOnHeader()){
            logout();
        }
    }

    @Test
    public void testLogInAtlassian() throws InterruptedException {
        // Atlassian login
        clickLoginLink();
        fillLoginFormAtlassian("nikitashirman@gmail.com", "5457den5457");
        pause(5000);
        Assert.assertTrue(isAvatarPresentOnHeader());
        /*Locators to create new board
        1) "Добавить доску" button : [class="board-tile mod-add"]
        2) "Добавить заголовок доски" button : [data-test-id="create-board-title-input"]
        3) "Тип доски" button : .subtle-chooser-trigger.unstyled-button.vis-chooser-trigger
        4) "Создать доску" : [data-test-id="create-board-submit-button"]
        */
    }

    @Test
    public void testLogInOld() throws InterruptedException {
        // Old login
        clickLoginLink();
        fillLoginFormOld("shirmannik@gmail.com", "5457den5457");
        pause(5000);
        Assert.assertTrue(isAvatarPresentOnHeader());
    }


}
