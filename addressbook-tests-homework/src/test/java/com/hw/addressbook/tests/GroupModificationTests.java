package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import com.hw.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups before = app.group().all();
        GroupData modifyGroup = before.iterator().next();

        GroupData group = new GroupData()
                .withId(modifyGroup.getId())
                .withName("test1")
                .withHeader("header_test")
                .withComment("comment_test");

        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());
        assertThat(after, CoreMatchers.equalTo(before.withOut(modifyGroup).withAdded(group)));
    }


}
