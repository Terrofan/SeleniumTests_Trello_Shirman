package com.nikita.trello.fw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper boardHelper;
    TeamHelper teamHelper;
    HeaderHelper headerHelper;
    SessionHelper sessionHelper;
    Helperbase helperbase;


    public void init() {
        String browser = System.getProperty("browser", BrowserType.FIREFOX);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        maximize();
        wd.get("https://trello.com/");
        sessionHelper = new SessionHelper(wd);
        boardHelper = new BoardHelper(wd);
        headerHelper = new HeaderHelper(wd);
        teamHelper = new TeamHelper(wd);
        helperbase = new Helperbase(wd);
    }

    public void stop() throws InterruptedException {
        getHelperbase().pause(5000);
        wd.quit();
    }

    public void maximize(){
        wd.manage().window().maximize();
    }

    public Helperbase getHelperbase() {
        return helperbase;
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public HeaderHelper getHeaderHelper() {
        return headerHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
