package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserCreationTests extends TestBase {
    @Test
    public void testsUserCreation() {
        app.getNavigationHelper().gotoToHomePage();
        List<AddressBookEntry> before = app.getAddressBookEntryHelper().getContactList();
        AddressBookEntry user = new AddressBookEntry(
                "Evgeniy", "Olegovich", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com",
                "gt_group_name"
        );
        app.getAddressBookEntryHelper().createContact(user);
        List<AddressBookEntry> after = app.getAddressBookEntryHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);
    }
}
