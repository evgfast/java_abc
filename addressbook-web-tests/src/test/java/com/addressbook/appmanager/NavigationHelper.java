package com.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by evg on 17.09.16.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoToGroupPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }

    public void gotoToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
}
