package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.AddressBookEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by evg on 18.09.16.
 */
public class ApplicationManager {
    private FirefoxDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private AddressBookEntryHelper addressBookEntryHelper;



    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://192.168.1.34/addressbook/");
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
