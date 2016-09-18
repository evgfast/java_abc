package com.hw.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
    @Test
    public void testsGroupCreation() {
        gotoToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("group_name", "group header", "group comment"));
        submitForm();
        backGroupPage();
    }
}
