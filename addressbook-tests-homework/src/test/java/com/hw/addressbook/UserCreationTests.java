package com.hw.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserCreationTests extends TestBase {
    @Test
    public void testsUserCreation() {
        initUserCreation();
        UserData user = new UserData(
                "Evgeniy", "Olegovich", "Shestopalov",
                "evg", "Inc", "Saratov 64", "555555",
                "898783245", "6666", "evg@gmail.com"
        );
        fillUserDetails(user);
        submitUserForm();
    }
}
