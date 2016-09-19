package com.hw.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by evg on 19.09.16.
 */
public class GroupDeletionTests extends TestBase {
    @Test
    public void testsUserDeletion() {
        app.getNavigationHelper().gotoToGroupPage();
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().initGroupDeletion();
    }
}
