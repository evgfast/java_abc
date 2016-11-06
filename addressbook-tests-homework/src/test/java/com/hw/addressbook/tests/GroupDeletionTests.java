package com.hw.addressbook.tests;

import com.hw.addressbook.model.GroupData;
import com.hw.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups before = app.group().all();
        GroupData delGroup = before.iterator().next();
        app.group().delete(delGroup);
        Groups after = app.group().all();
        //before.remove(delGroup);
        assertEquals(after.size(), before.size() - 1 );
        assertThat(after, equalTo(before.withOut(delGroup)));
    }


}
