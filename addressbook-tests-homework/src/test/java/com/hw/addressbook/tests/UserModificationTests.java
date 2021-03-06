package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import com.hw.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by evg on 19.09.16.
 */
public class UserModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            AddressBookEntry user = new AddressBookEntry().withFirstname("Evgen")
                    .withMiddlename("Oleg")
                    .withLastname("Shestopalov")
                    .withNickname("evg")
                    .withCompany("Inc")
                    .withAddress("Saratov 64")
                    .withPhoneHome("5555555")
                    .withWorkPhone("9878342543")
                    .withEmail("evg@gmail.com")
                    .withGroup("gt_group_name");
            app.contact().create(user);
        }
    }
    @Test(enabled = true)
    public void testsUserModification(){
        Contacts before = app.contact().all();
        AddressBookEntry modifyContact = before.iterator().next();
        AddressBookEntry user_mod = new AddressBookEntry().withId(modifyContact.getId())
                .withFirstname("Name_modification")
                .withMiddlename("Olegovich_modification")
                .withLastname("Shestopalov_modification")
                .withNickname("evg_modification")
                .withCompany("Inc_modification")
                .withAddress("Saratov 64_modification")
                .withPhoneHome("00000000")
                .withWorkPhone("998877787")
                .withEmail("evgmodification@gmail.ru")
                .withGroup("gt_group_name");
        app.contact().modify(user_mod);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(modifyContact).withAdded(user_mod)));
    }

}
