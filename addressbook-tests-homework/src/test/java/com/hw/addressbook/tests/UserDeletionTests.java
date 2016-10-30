package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserDeletionTests extends TestBase {
    @Test
    public void testsUserDeletion() {
        app.getNavigationHelper().gotoToHomePage();
        List<AddressBookEntry> before = app.getAddressBookEntryHelper().getContactList();

        AddressBookEntry user = new AddressBookEntry(
                before.get(before.size() - 1).getId(),
                "Evgen", "Oleg", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com",
                "gt_group_name"
        );
        if (! app.getAddressBookEntryHelper().isThereAContact()){
            app.getAddressBookEntryHelper().createContact(user);
        }
        app.getAddressBookEntryHelper().selectContact(before.size() - 1);
        app.getAddressBookEntryHelper().initUserDeletion();
        app.getAddressBookEntryHelper().backHomePage();

        List<AddressBookEntry> after = app.getAddressBookEntryHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
