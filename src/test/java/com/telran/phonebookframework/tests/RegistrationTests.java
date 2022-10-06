package com.telran.phonebookframework.tests;

import com.telran.phonebookframework.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void SetUp() {
        app.initApp();
    }

    @Test
    public void testRegistrationPositive() {
        User newValidUser = new User("ZZxcv_1!");
        app.goToLoginPage();
        app.getLoginPageHelper().registerUser(newValidUser);
        app.waitForContactsPageToLoad();
        Assert.assertTrue(app.getMenuHelper().hasSignOutButtonPresent(), "Registered user is signed in");
    }


}
