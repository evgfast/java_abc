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

        AddressBookEntry user = new AddressBookEntry().withFirstname("Evgen")
                .withMiddlename("Oleg")
                .withLastname("Shestopalov")
                .withNickname("evg")
                .withCompany("Inc")
                .withAddress("Saratov 64")
                .withPhoneHome("5555555")
                .withPhoneWork("9878342543")
                .withEmail("evg@gmail.com")
                .withGroup("gt_group_name");
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
