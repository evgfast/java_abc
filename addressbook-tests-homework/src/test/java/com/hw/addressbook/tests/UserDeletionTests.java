package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

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
        if (app.contact().all().size() == 0){
            app.contact().create(user);
        }
    }

    @Test(enabled = true)
    public void testsUserDeletion() {
        Set<AddressBookEntry> before = app.contact().all();
        AddressBookEntry delContact = before.iterator().next();

        app.contact().delete(delContact);
        Set<AddressBookEntry> after = app.contact().all();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(delContact);
        Assert.assertEquals(before, after);
    }


}
