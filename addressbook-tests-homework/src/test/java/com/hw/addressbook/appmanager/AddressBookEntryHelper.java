package com.hw.addressbook.appmanager;

import com.hw.addressbook.model.AddressBookEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by evg on 18.09.16.
 */
public class AddressBookEntryHelper {
    private FirefoxDriver wd;

    public AddressBookEntryHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void submitAddressBookEntryForm() {
        wd.findElement(By.xpath("//input[@type=\"submit\"][1]")).click();
    }

    public void fillAddressBookEntryForm(AddressBookEntry addressBookEntry) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(addressBookEntry.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(addressBookEntry.getMiddlename());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(addressBookEntry.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(addressBookEntry.getNickname());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(addressBookEntry.getCompany());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(addressBookEntry.getAddress());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(addressBookEntry.getPhoneHome());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(addressBookEntry.getMobile());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(addressBookEntry.getPhoneWork());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(addressBookEntry.getEmail());
    }

    public void initAddressBookEntryCreation() {
        wd.findElement(By.linkText("add new")).click();
    }
}
