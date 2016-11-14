package com.hw.addressbook.model;


import java.io.File;

public class AddressBookEntry {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String company;
    private String address;
    private String phoneHome;
    private String mobile;
    private String phoneWork;
    private String email;
    private String email2;
    private String email3;
    private String group;
    private String allPhones;
    private String allEmails;
    private String allPostAddress;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public AddressBookEntry withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getAllPostAddress() {
        return allPostAddress;
    }

    public AddressBookEntry withAllPostAddress(String allPostAddress) {
        this.allPostAddress = allPostAddress;
        return this;
    }

    public AddressBookEntry withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public AddressBookEntry withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public AddressBookEntry withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public AddressBookEntry withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressBookEntry that = (AddressBookEntry) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }


    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public AddressBookEntry withGroup(String group) {
        this.group = group;
        return this;
    }

    public AddressBookEntry withId(int id) {
        this.id = id;
        return this;
    }

    public AddressBookEntry withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public AddressBookEntry withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public AddressBookEntry withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public AddressBookEntry withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public AddressBookEntry withCompany(String company) {
        this.company = company;
        return this;
    }

    public AddressBookEntry withAddress(String address) {
        this.address = address;
        return this;
    }

    public AddressBookEntry withPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
        return this;
    }

    public AddressBookEntry withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public AddressBookEntry withWorkPhone(String phoneWork) {
        this.phoneWork = phoneWork;
        return this;
    }

    public AddressBookEntry withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "AddressBookEntry{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}
