package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends TestBase {
    @Test
    public void testsUserCreation() {
        app.getNavigationHelper().gotoToHomePage();
        List<AddressBookEntry> before = app.getAddressBookEntryHelper().getContactList();
        AddressBookEntry user = new AddressBookEntry(
                before.get(before.size() - 1).getId(),
                "Evgeniy", "Olegovich", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com",
                "gt_group_name"
        );
        app.getAddressBookEntryHelper().createContact(user);
        List<AddressBookEntry> after = app.getAddressBookEntryHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);

        before.add(user);
        int max = 0;
        for(AddressBookEntry a : after ) {
            if (a.getId() > max) {
                max = a.getId();
            }
        }
        user.setId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
