package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by evg on 18.09.16.
 */
public class GroupHelper {
    FirefoxDriver wd;
    public GroupHelper(FirefoxDriver wd){
        this.wd = wd;
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getComment());
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void backGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitForm() {
        wd.findElement(By.name("submit")).click();
    }
}
