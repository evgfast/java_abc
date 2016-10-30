package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by evg on 19.09.16.
 */
public class UserModificationTests extends TestBase {
    @Test
    public void testsUserModification(){
        app.getNavigationHelper().gotoToHomePage();
        int before = app.getAddressBookEntryHelper().getContactCount();
        AddressBookEntry user_mod = new AddressBookEntry(
                "Name_modification", "Olegovich_modification", "Shestopalov_modification",
                "evg_modification", "Inc_modification", "Saratov 64_modification", "555555",
                "00000000", "99999999", "evgmodification@gmail.ru",
                null
        );

        if (! app.getAddressBookEntryHelper().isThereAContact()){
            AddressBookEntry user = new AddressBookEntry(
                    "Evgen", "Oleg", "Shestopalov",
                    "evg", "Inc", "Saratov 64", "555555",
                    "898783245", "6666", "evg@gmail.com",
                    "gt_group_name"
            );
            app.getAddressBookEntryHelper().createContact(user);
        }
        app.getAddressBookEntryHelper().initFirstUserModification(before - 1);
        app.getAddressBookEntryHelper().fillAddressBookEntryForm(user_mod, false);
        app.getAddressBookEntryHelper().updateUser();
        app.getAddressBookEntryHelper().backHomePage();
        int after = app.getAddressBookEntryHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
