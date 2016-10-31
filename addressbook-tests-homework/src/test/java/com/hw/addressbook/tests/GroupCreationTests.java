package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase{
    @Test
    public void testsGroupCreation() {
        app.getNavigationHelper().gotoToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test2", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
        int max = after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
