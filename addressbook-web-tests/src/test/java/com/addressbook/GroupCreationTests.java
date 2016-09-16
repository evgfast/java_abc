package com.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("gt_group_name", "header", "comment"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
