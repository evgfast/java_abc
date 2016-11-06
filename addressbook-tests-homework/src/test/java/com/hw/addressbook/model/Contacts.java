package com.hw.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by evg on 06.11.16.
 */
public class Contacts extends ForwardingSet<AddressBookEntry> {
    private Set<AddressBookEntry> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<AddressBookEntry>(contacts.delegate());
    }

    public Contacts() {
        this.delegate = new HashSet<AddressBookEntry>();
    }


    @Override
    protected Set<AddressBookEntry> delegate() {
        return delegate;
    }

    public Contacts withAdded(AddressBookEntry contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts withOut(AddressBookEntry contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
