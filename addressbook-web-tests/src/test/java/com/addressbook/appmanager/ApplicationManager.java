package com.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by evg on 16.09.16.
 */
public class ApplicationManager {
    WebDriver wd;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private String browser;
    private AddressBookEntryHelper addressBookEntryHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "/home/evg/project/driver/chromedriver");
            wd = new ChromeDriver();
        }
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        addressBookEntryHelper = new AddressBookEntryHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public AddressBookEntryHelper getAddressBookEntryHelper() {
        return addressBookEntryHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
