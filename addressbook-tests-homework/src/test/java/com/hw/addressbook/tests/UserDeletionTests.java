package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class UserDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        AddressBookEntry user = new AddressBookEntry(
                "Evgen", "Oleg", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com",
                "gt_group_name"
        );
        if (app.contact().list().size() == 0){
            app.contact().create(user);
        }
    }

    @Test(enabled = true)
    public void testsUserDeletion() {
        List<AddressBookEntry> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<AddressBookEntry> after = app.contact().list();
        Assert.assertEquals(after.size(), index);
        before.remove(index);
        Assert.assertEquals(before, after);
    }


}
