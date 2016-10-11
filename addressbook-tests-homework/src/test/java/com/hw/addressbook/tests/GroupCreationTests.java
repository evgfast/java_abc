package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
    @Test
    public void testsGroupCreation() {
        app.getNavigationHelper().gotoToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("group_name", null, null));
        app.getGroupHelper().submitForm();
        app.getGroupHelper().backGroupPage();
    }
}
