package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

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

    public void createGroup(GroupData group) {
       initGroupCreation();
       fillGroupForm(group);
       submitForm();
       backGroupPage();
    }
    public void modifyGroup(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        updateGroupModification();
        backGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.xpath("//hr/following-sibling::span[1]/input"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
