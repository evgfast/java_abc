package com.hw.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by evg on 18.09.16.
 */
public class HelperBase {
    FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void clickCheckbox(By locator) {
        if (!wd.findElement(locator).isSelected()) {
            wd.findElement(locator).click();
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}