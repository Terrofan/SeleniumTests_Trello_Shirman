package com.nikita.trello;
import org.testng.annotations.Test;



public class LoginTest extends TestBase {

    @Test
    public void testLogIn() throws InterruptedException {
        // Atlassian login
        clickLoginLink("nikitashirman@gmail.com", "5457den5457");
        /*Locators to create new board
        1) "Добавить доску" button : [class="board-tile mod-add"]
        2) "Добавить заголовок доски" button : [data-test-id="create-board-title-input"]
        3) "Тип доски" button : .subtle-chooser-trigger.unstyled-button.vis-chooser-trigger
        4) "Создать доску" : [data-test-id="create-board-submit-button"]
        */
    }


}
