package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by evg on 19.09.16.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testsGroupModification(){
        app.getNavigationHelper().gotoToGroupPage();
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("edit_name", "modification header", "mod mod modification"));
        app.getGroupHelper().updateGroupModification();
    }
}
