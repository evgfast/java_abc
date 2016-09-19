package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.annotations.Test;

public class UserCreationTests extends TestBase {
    @Test
    public void testsUserCreation() {
        app.getNavigationHelper().gotoToHomePage();
        app.getAddressBookEntryHelper().initAddressBookEntryCreation();
        AddressBookEntry user = new AddressBookEntry(
                "Evgeniy", "Olegovich", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com"
        );
        app.getAddressBookEntryHelper().fillAddressBookEntryForm(user);
        app.getAddressBookEntryHelper().submitAddressBookEntryForm();
    }
}
