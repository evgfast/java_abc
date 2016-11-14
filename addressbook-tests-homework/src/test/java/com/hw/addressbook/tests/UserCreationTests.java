package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import com.hw.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class UserCreationTests extends TestBase {
    @Test(enabled = true)
    public void testsUserCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/ava.png");
        AddressBookEntry user = new AddressBookEntry().withFirstname("Evgeniy")
                .withMiddlename("Olegovich")
                .withLastname("Shestopalov")
                .withNickname("evg")
                .withCompany("Inc")
                .withAddress("Saratov 64")
                .withPhoneHome("222266")
                .withMobile("88888")
                .withWorkPhone("99999")
                .withEmail("evg@gmail.com")
                .withPhoto(photo);
        app.contact().create(user);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded( user.withId(after.stream().mapToInt( (g) -> g.getId() ).max().getAsInt()) ))
        );
    }

    @Test
    public void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/ava.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

    @Test(enabled = true)
    public void testsBadUserCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        AddressBookEntry user = new AddressBookEntry().withFirstname("Evgeniy'")
                .withMiddlename("Olegovich")
                .withLastname("Shestopalov")
                .withNickname("evg")
                .withCompany("Inc")
                .withAddress("Saratov 64")
                .withPhoneHome("222266")
                .withMobile("88888")
                .withWorkPhone("99999")
                .withEmail("evg@gmail.com")
                .withGroup("gt_group_name");
        app.contact().create(user);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}
