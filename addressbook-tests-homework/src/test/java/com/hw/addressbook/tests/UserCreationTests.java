package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class UserCreationTests extends TestBase {
    @Test(enabled = true)
    public void testsUserCreation() {
        app.goTo().homePage();
        Set<AddressBookEntry> before = app.contact().all();
        AddressBookEntry user = new AddressBookEntry().withFirstname("Evgeniy")
                .withMiddlename("Olegovich")
                .withLastname("Shestopalov")
                .withNickname("evg")
                .withCompany("Inc")
                .withAddress("Saratov 64")
                .withPhoneHome("3443535")
                .withPhoneWork("9878342543")
                .withEmail("evg@gmail.com")
                .withGroup("gt_group_name");
        app.contact().create(user);
        Set<AddressBookEntry> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() +1);

//        int max = after.stream().max( ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))).get().getId();
        user.withId(after.stream().mapToInt( (g) -> g.getId() ).max().getAsInt());
        before.add(user);
//        user.withId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
