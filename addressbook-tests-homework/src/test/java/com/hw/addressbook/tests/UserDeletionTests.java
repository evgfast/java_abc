package com.hw.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {
    @Test
    public void testsUserDeletion() {
        app.getNavigationHelper().gotoToHomePage();
        app.getAddressBookEntryHelper().selectFirstUser();
        app.getAddressBookEntryHelper().initUserDeletion();
    }

}
