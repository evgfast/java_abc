package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {
    @Test
    public void testsUserDeletion() {
        app.getNavigationHelper().gotoToHomePage();
        int before = app.getAddressBookEntryHelper().getContactCount();
        AddressBookEntry user = new AddressBookEntry(
                "Evgen", "Oleg", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com",
                "gt_group_name"
        );
        if (! app.getAddressBookEntryHelper().isThereAContact()){
            app.getAddressBookEntryHelper().createContact(user);
        }
        app.getAddressBookEntryHelper().selectContact(before - 1);
        app.getAddressBookEntryHelper().initUserDeletion();
        app.getAddressBookEntryHelper().backHomePage();
        int after = app.getAddressBookEntryHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
