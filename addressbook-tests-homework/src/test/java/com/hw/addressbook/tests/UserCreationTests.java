package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import com.hw.addressbook.model.Contacts;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class UserCreationTests extends TestBase {
    @Test(enabled = true)
    public void testsUserCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
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
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded( user.withId(after.stream().mapToInt( (g) -> g.getId() ).max().getAsInt()) ))
        );
    }
}
