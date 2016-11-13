package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by evg on 08.11.16.
 */
public class ContactVisibleTests extends TestBase {
    @Test
    public void testContactVisible(){
        app.goTo().homePage();
        AddressBookEntry contact = app.contact().all().iterator().next();
        AddressBookEntry contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAllPostAddress()));
    }

    @Test
    public void testDetailsVisible() {
        app.goTo().homePage();
        AddressBookEntry contact = app.contact().all().iterator().next();
        AddressBookEntry contactInfoFromDetailsForm = app.contact().infoFromDetails(contact);
        assertThat(contact.getFirstname(), equalTo(contactInfoFromDetailsForm.getFirstname()));
        assertThat(contact.getLastname(), equalTo(contactInfoFromDetailsForm.getLastname()));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromDetailsForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromDetailsForm)));
    }

    private String mergePhones(AddressBookEntry contact) {
        return Arrays.asList(contact.getPhoneHome(), contact.getMobile(), contact.getPhoneWork())
                .stream().filter( (s) -> ! s.equals(""))
                .map(ContactVisibleTests::cleaned)
                .collect(Collectors.joining("\n"));
    }
    private String mergeEmails(AddressBookEntry contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter( (s) -> ! s.equals(""))
                .map(ContactVisibleTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String str){
        return str.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
