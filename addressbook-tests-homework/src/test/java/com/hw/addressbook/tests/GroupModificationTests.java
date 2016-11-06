package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

/**
 * Created by evg on 19.09.16.
 */
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("testM"));
        }
    }

    @Test
    public void testsGroupModification(){
        Set<GroupData> before = app.group().all();
        GroupData modifyGroup = before.iterator().next();

        GroupData group = new GroupData()
                .withId(modifyGroup.getId())
                .withName("test1")
                .withHeader("header_test")
                .withComment("comment_test");

        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifyGroup);
        before.add(group);
        Assert.assertEquals(after, before);
    }


}
