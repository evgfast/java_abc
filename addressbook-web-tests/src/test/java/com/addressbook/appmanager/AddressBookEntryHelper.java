package com.addressbook.appmanager;

import com.addressbook.model.AddressBookEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by evg on 18.09.16.
 */
public class AddressBookEntryHelper extends HelperBase{

    public AddressBookEntryHelper(WebDriver wd) {
        super(wd);
    }

    public void submitAddressBookEntryForm() {
        click(By.xpath("//input[@type=\"submit\"][1]"));
    }

    public void fillAddressBookEntryForm(AddressBookEntry addressBookEntry, boolean creation) {
        type(By.name("firstname"), addressBookEntry.getFirstname());
        type(By.name("middlename"), addressBookEntry.getMiddlename());
        type(By.name("lastname"), addressBookEntry.getLastname());
        type(By.name("nickname"), addressBookEntry.getNickname());
        type(By.name("company"), addressBookEntry.getCompany());
        type(By.name("address"), addressBookEntry.getAddress());
        type(By.name("home"), addressBookEntry.getPhoneHome());
        type(By.name("mobile"), addressBookEntry.getMobile());
        type(By.name("work"), addressBookEntry.getPhoneWork());
        type(By.name("email"), addressBookEntry.getEmail());

        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressBookEntry.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initAddressBookEntryCreation() {
        click(By.linkText("add new"));
    }

    public void selectFirstUser(){
        clickCheckbox(By.xpath("//tr[@name][1]//input"));
    }

    public void initUserDeletion(){
        click(By.xpath("//input[@value=\"Delete\"]"));
        wd.switchTo().alert().accept();
    }

    public void initFirstUserModification(){
        click(By.xpath("//tr[@name][1]//img[@alt=\"Edit\"]"));
    }

    public void updateUser(){
        click(By.xpath("//input[@value=\"Update\"][1]"));
    }

}
