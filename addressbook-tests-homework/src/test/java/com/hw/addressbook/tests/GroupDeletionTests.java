package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by evg on 19.09.16.
 */
public class GroupDeletionTests extends TestBase {
    @Test
    public void testsUserDeletion() {
        app.getNavigationHelper().gotoToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().initGroupDeletion();
    }
}
