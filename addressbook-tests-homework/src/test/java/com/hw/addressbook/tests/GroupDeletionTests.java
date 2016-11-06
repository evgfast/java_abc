package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

/**
 * Created by evg on 19.09.16.
 */
public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("testM"));
        }
    }

    @Test
    public void testsUserDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData delGroup = before.iterator().next();

        app.group().delete(delGroup);
        Set<GroupData> after = app.group().all();
        int index = before.size() - 1;
        Assert.assertEquals(after.size(), index);
        before.remove(delGroup);
        Assert.assertEquals(before, after);
    }


}
