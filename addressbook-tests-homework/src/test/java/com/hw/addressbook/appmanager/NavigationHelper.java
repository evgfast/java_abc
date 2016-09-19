package com.hw.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by evg on 18.09.16.
 */
public class NavigationHelper extends HelperBase {
    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoToGroupPage() {
        click(By.linkText("groups"));
    }
    public void gotoToHomePage() {
        click(By.linkText("home"));
    }
}
