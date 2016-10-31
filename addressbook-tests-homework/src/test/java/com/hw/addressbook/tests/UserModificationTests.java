package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by evg on 19.09.16.
 */
public class UserModificationTests extends TestBase {
    @Test
    public void testsUserModification(){
        app.getNavigationHelper().gotoToHomePage();
        List<AddressBookEntry> before = app.getAddressBookEntryHelper().getContactList();
        AddressBookEntry user_mod = new AddressBookEntry(
                before.get(before.size() - 1).getId(),
                "Name_modification", "Olegovich_modification", "Shestopalov_modification",
                "evg_modification", "Inc_modification", "Saratov 64_modification", "555555",
                "00000000", "99999999", "evgmodification@gmail.ru",
                null
        );

        if (! app.getAddressBookEntryHelper().isThereAContact()){
            AddressBookEntry user = new AddressBookEntry(
                    before.get(before.size() - 1).getId(),
                    "Evgen", "Oleg", "Shestopalov",
                    "evg", "Inc", "Saratov 64", "555555",
                    "898783245", "6666", "evg@gmail.com",
                    "gt_group_name"
            );
            app.getAddressBookEntryHelper().createContact(user);
        }
        app.getAddressBookEntryHelper().initFirstUserModification(before.size() - 1);
        app.getAddressBookEntryHelper().fillAddressBookEntryForm(user_mod, false);
        app.getAddressBookEntryHelper().updateUser();
        app.getAddressBookEntryHelper().backHomePage();
        List<AddressBookEntry> after = app.getAddressBookEntryHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(user_mod);

        Comparator<? super AddressBookEntry> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
