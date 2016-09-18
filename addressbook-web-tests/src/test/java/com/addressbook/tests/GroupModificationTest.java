package com.addressbook.tests;

import com.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by evg on 17.09.16.
 */
public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("modification", "header_mdd", "test33"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
