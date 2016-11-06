package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Set;

public class GroupCreationTests extends TestBase{
    @Test
    public void testsGroupCreation() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        //int max = after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        //group.withId(max);
        group.withId(after.stream()
                .mapToInt( (g) -> g.getId() ).max().getAsInt()
        );
        before.add(group);
        Assert.assertEquals(before, after);

    }
}
