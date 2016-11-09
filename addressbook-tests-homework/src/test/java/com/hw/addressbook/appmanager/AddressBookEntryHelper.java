package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.AddressBookEntry;
import com.hw.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;


/**
 * Created by evg on 18.09.16.
 */
public class AddressBookEntryHelper extends HelperBase{
    private Contacts contactsCache = null;
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
        contactsCache = null;
        backHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//tr[@name][1]//input"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private void selectContactEditById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id +"']")).click();
    }

    private void selectContactCheckBoxById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }

    public Contacts all() {
        if(contactsCache != null){
            return new Contacts(contactsCache);
        }
        contactsCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[class]"));
        for(WebElement element : elements){
            String last_name = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String first_name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            String allEmails = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
            String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            int id = Integer.parseInt(element.findElement(By.cssSelector("td:nth-child(1) input")).getAttribute("value"));
            contactsCache.add(new AddressBookEntry().withId(id)
                    .withFirstname(first_name)
                    .withLastname(last_name)
                    .withAllPhones(allPhones)
                    .withAllEmails(allEmails)
                    .withAllPostAddress(address)
            );
        }
        return new Contacts(contactsCache);
    }

    public void modify(AddressBookEntry user_mod) {
        selectContactEditById(user_mod.getId());
        fillAddressBookEntryForm(user_mod, false);
        updateUser();
        contactsCache = null;
        backHomePage();
    }



    public void delete(AddressBookEntry contact) {
        selectContactCheckBoxById(contact.getId());
        initUserDeletion();
        contactsCache = null;
        backHomePage();
    }


    public  AddressBookEntry infoFromEditForm(AddressBookEntry contact) {
        selectContactEditById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new AddressBookEntry().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withPhoneHome(home).withMobile(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3)
                .withAddress(address);
    }


}
