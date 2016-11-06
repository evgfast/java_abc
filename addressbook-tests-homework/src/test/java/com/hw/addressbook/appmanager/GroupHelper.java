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
       backGroupPage();
    }
    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        updateGroupModification();
        backGroupPage();
    }
    /*
    public void delete(int index) {
        selectGroup(index);
        initGroupDeletion();
        backGroupPage();
    }
    */
    public boolean isThereAGroup() {
        return isElementPresent(By.xpath("//hr/following-sibling::span[1]/input"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    /*
    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
    */
    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
    /*
    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }
    */
    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        initGroupDeletion();
        backGroupPage();
    }
}
