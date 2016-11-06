package com.hw.addressbook.model;


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
    private String group;


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

    public AddressBookEntry withPhoneWork(String phoneWork) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressBookEntry that = (AddressBookEntry) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
