package com.addressbook.tests;


import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void GroupDeletionTests() {
        app.getNavigationHelper().gotoToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
