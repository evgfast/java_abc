package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
    @Test
    public void testsGroupCreation() {
        app.getNavigationHelper().gotoToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("group_name", null, null));
    }
}
