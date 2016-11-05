package com.hw.addressbook.model;

import org.openqa.selenium.firefox.FirefoxDriver;

public class AddressBookEntry {
    private int id;
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

    public AddressBookEntry(int id, String firstname, String lastname){
        this.id = id;
        this.firstname = firstname;
        this.middlename = "";
        this.lastname = lastname;
        this.nickname = "";
        this.company = "";
        this.address = "";
        this.phoneHome = "";
        this.mobile = "";
        this.phoneWork = "";
        this.email = "";
        this.group = "";
    }

    public AddressBookEntry(int id, String firstname, String middlename, String lastname, String nickname, String company,
                            String address, String phoneHome, String mobile,
                            String phoneWork, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.address = address;
        this.phoneHome = phoneHome;
        this.mobile = mobile;
        this.phoneWork = phoneWork;
        this.email = email;
        this.group = group;
    }

    public AddressBookEntry( String firstname, String middlename, String lastname, String nickname, String company,
                            String address, String phoneHome, String mobile,
                            String phoneWork, String email, String group) {
        this.id = Integer.MAX_VALUE;;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.address = address;
        this.phoneHome = phoneHome;
        this.mobile = mobile;
        this.phoneWork = phoneWork;
        this.email = email;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setGroup(String group) {
        this.group = group;
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
