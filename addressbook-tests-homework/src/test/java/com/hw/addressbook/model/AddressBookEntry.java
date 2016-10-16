package com.hw.addressbook.model;

import org.openqa.selenium.firefox.FirefoxDriver;

public class  AddressBookEntry {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String company;
    private final String address;
    private final String phoneHome;
    private final String mobile;
    private final String phoneWork;
    private final String email;
    private String group;

    public AddressBookEntry(String firstname, String middlename, String lastname, String nickname, String company,
                            String address, String phoneHome, String mobile,
                            String phoneWork, String email, String group) {
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
}
