package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends TestBase {
    @Test(enabled = true)
    public void testsUserCreation() {
        app.goTo().homePage();
        List<AddressBookEntry> before = app.contact().list();
        AddressBookEntry user = new AddressBookEntry(
                before.get(before.size() - 1).getId(),
                "Evgeniy", "Olegovich", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com",
                "gt_group_name"
        );
        app.contact().create(user);
        List<AddressBookEntry> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() +1);
        int max = after.stream().max( ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))).get().getId();
        before.add(user);
        user.setId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
