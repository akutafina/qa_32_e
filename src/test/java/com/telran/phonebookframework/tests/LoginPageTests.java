package com.telran.phonebookframework.tests;

import com.telran.phonebookframework.fw.DataProviders;
import com.telran.phonebookframework.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTests extends TestBase {
    User invalidPwdUser = new User("michael@gmail.com", "invalid_pwd");
    User invalidEmailUser = new User("invalid_email@gmail.com", "ZZxcv_1!");

    @Test (dataProvider = "newUsersForPositiveLoginPageTestFromFile", dataProviderClass = DataProviders.class)
    public void testLoginFormWithDataProviderFromFilePositive(User user) throws InterruptedException {
        app.goToLoginPage();
        app.waitForLoginPageToLoad();
        app.getLoginPageHelper().fillAndSubmitLoginForm(user);
        app.waitForContactsPageToLoad();
        Assert.assertTrue(app.getMenuHelper().hasSignOutButtonPresent(), "Log Out button is present");
    }

    @Test (dataProvider = "newUsersForPositiveLoginPageTest", dataProviderClass = DataProviders.class)
    public void testLoginFormWithDataProviderPositive(User user) throws InterruptedException {
        app.goToLoginPage();
        app.waitForLoginPageToLoad();
        app.getLoginPageHelper().fillAndSubmitLoginForm(user);
        app.waitForContactsPageToLoad();
        Assert.assertTrue(app.getMenuHelper().hasSignOutButtonPresent(), "Log Out button is present");
    }

//    @Test
//    public void testLoginFormWithInvalidPwdNegative(){
//        app.goToLoginPage();
//        app.waitForLoginPageToLoad();
//        app.getLoginPageHelper().fillAndSubmitLoginForm(invalidPwdUser);
//        app.getLoginPageHelper().clickOnErrorAlert();
//        Assert.assertTrue(app.getLoginPageHelper().isLoginErrorMessagePresent("Login Failed with code 400"), "Login error message is present");
//        Assert.assertFalse(app.getMenuHelper().hasSignOutButtonPresent(), "User is not signed in");
//    }
//    @Test
//    public void testLoginFormWithInvalidEmailNegative() {
//        app.goToLoginPage();
//        app.waitForLoginPageToLoad();
//        app.getLoginPageHelper().fillAndSubmitLoginForm(invalidEmailUser);
//        app.getLoginPageHelper().clickOnErrorAlert();
//        Assert.assertTrue(app.getLoginPageHelper().isLoginErrorMessagePresent("Login Failed with code 500"), "Login error message is present");
//        Assert.assertFalse(app.getMenuHelper().hasSignOutButtonPresent(), "User is not signed in");
//    }

    @Test (dataProvider = "newUsersForNegativeLoginPageTestFromFile", dataProviderClass = DataProviders.class)
    public void testLoginFormNegative(User user){
        app.goToLoginPage();
        app.waitForLoginPageToLoad();
        app.getLoginPageHelper().fillAndSubmitLoginForm(user);
        app.getLoginPageHelper().clickOnErrorAlert();
        Assert.assertTrue(app.getLoginPageHelper().isLoginErrorMessagePresent("Login Failed with code"), "Login error message is present");
    }
}
