package com.hw.addressbook.tests;

import com.hw.addressbook.model.AddressBookEntry;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by evg on 08.11.16.
 */
public class ContactPhoneTests extends TestBase {
    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        AddressBookEntry contact = app.contact().all().iterator().next();
        AddressBookEntry contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getPhoneHome(), equalTo(cleaned(contactInfoFromEditForm.getPhoneHome())));
        assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
        assertThat(contact.getPhoneWork(), equalTo(cleaned(contactInfoFromEditForm.getPhoneWork())));
    }
    public String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
