package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class UserDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoToHomePage();
        AddressBookEntry user = new AddressBookEntry(
                "Evgen", "Oleg", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com",
                "gt_group_name"
        );
        if (! app.getAddressBookEntryHelper().isThereAContact()){
            app.getAddressBookEntryHelper().createContact(user);
        }
    }

    @Test(enabled = false)
    public void testsUserDeletion() {
        List<AddressBookEntry> before = app.getAddressBookEntryHelper().getContactList();
        int index = before.size() - 1;
        app.getAddressBookEntryHelper().selectContact(index);
        app.getAddressBookEntryHelper().initUserDeletion();
        app.getAddressBookEntryHelper().backHomePage();

        List<AddressBookEntry> after = app.getAddressBookEntryHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
