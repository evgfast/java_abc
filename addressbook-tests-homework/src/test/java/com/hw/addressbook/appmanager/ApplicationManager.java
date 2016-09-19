package com.hw.addressbook.appmanager;

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

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://192.168.1.40/addressbook/");
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
