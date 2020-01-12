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
        pause(7000);
        Assert.assertTrue(isAvatarPresentOnHeader());
    }

    @Test(enabled = false)
    public void testLogInOld() throws InterruptedException {
        // Old login
        clickLoginLink();
        fillLoginFormOld("shirmannik@gmail.com", "5457den5457");
        pause(5000);
        Assert.assertTrue(isAvatarPresentOnHeader());
    }


}
