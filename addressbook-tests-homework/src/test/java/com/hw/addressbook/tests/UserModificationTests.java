package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by evg on 19.09.16.
 */
public class UserModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
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
            app.contact().create(user);
        }
    }
    @Test(enabled = true)
    public void testsUserModification(){
        List<AddressBookEntry> before = app.contact().list();
        int index = before.size() - 1;
        AddressBookEntry user_mod = new AddressBookEntry().withId(before.get(index).getId())
                .withFirstname("Name_modification")
                .withMiddlename("Olegovich_modification")
                .withLastname("Shestopalov_modification")
                .withNickname("evg_modification")
                .withCompany("Inc_modification")
                .withAddress("Saratov 64_modification")
                .withPhoneHome("00000000")
                .withPhoneWork("998877787")
                .withEmail("evgmodification@gmail.ru")
                .withGroup("gt_group_name");
        app.contact().modify(index, user_mod);
        List<AddressBookEntry> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(user_mod);

        Comparator<? super AddressBookEntry> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}
