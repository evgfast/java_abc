package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.AddressBookEntry;
import com.hw.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /*
    addressBookEntry is object of contact
    creation is flag, if you will want create new contact should be equals TRUE
     */
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
            new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
        } else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initAddressBookEntryCreation() {
        click(By.linkText("add new"));
    }



    public void initUserDeletion(){
        click(By.xpath("//input[@value=\"Delete\"]"));
        wd.switchTo().alert().accept();
    }

    public void initFirstUserModification(int index){
        wd.findElement(By.xpath("//tr[@name=\"entry\"][1]//img[@alt=\"Edit\"]")).click();
    }


    public void updateUser(){
        click(By.xpath("//input[@value=\"Update\"][1]"));
    }

    public void backHomePage() {
        click(By.linkText("home"));
    }

    public void create(AddressBookEntry contact) {
        initAddressBookEntryCreation();
        fillAddressBookEntryForm(contact, true);
        submitAddressBookEntryForm();
        backHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//tr[@name][1]//input"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private void selectContactEditById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id +"']")).click();
    }
    private void selectContactCheckBoxById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[class]"));
        for(WebElement element : elements){
            String last_name = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String first_name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            int id = Integer.parseInt(element.findElement(By.cssSelector("td:nth-child(1) input")).getAttribute("value"));
            contacts.add(new AddressBookEntry().withId(id)
                    .withFirstname(first_name)
                    .withLastname(last_name)
            );
        }
        return contacts;
    }
    public void modify(AddressBookEntry user_mod) {
        selectContactEditById(user_mod.getId());
        fillAddressBookEntryForm(user_mod, false);
        updateUser();
        backHomePage();
    }



    public void delete(AddressBookEntry contact) {
        selectContactCheckBoxById(contact.getId());
        initUserDeletion();
        backHomePage();
    }


}
