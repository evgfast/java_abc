package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by evg on 18.09.16.
 */
public class GroupHelper extends HelperBase {
    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getComment());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void backGroupPage() {
        click(By.linkText("group page"));
    }


    public void submitForm() {
        click(By.name("submit"));
    }

}
