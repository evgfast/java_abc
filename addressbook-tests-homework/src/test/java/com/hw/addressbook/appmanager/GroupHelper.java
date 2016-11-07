package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.GroupData;
import com.hw.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by evg on 18.09.16.
 */
public class GroupHelper extends HelperBase {

    private Groups groupCache = null;

    public GroupHelper(WebDriver wd) {
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

    public void selectFirstGroup() {
        clickCheckbox(By.xpath("//hr/following-sibling::span[1]/input"));
    }

    public void initGroupDeletion() {
        click(By.xpath("//input[@name=\"delete\"][1]"));
    }

    public void initGroupModification() {
        click(By.xpath("//input[@name=\"edit\"][1]"));
    }

    public void updateGroupModification(){
        click(By.xpath("//input[@value=\"Update\"]"));
    }

    public void create(GroupData group) {
       initGroupCreation();
       fillGroupForm(group);
       submitForm();
       groupCache = null;
       backGroupPage();
    }
    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        updateGroupModification();
        groupCache = null;
        backGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.xpath("//hr/following-sibling::span[1]/input"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public Groups all() {
        if (groupCache != null){
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        initGroupDeletion();
        groupCache = null;
        backGroupPage();
    }
}
