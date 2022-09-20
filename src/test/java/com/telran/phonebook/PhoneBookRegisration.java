package com.telran.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhoneBookRegisration extends TestBase{
    // todo: move more values to the variable

    @BeforeMethod
    public void SetUp(){
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
    }

    @Test
    public void TestRegistration(){
        registerUser("michael2@gmail.com","ZZxcv_1!");
    }

    public void registerUser(String userEmailStr, String pwdStr) {
        // enter email
        fillTheInputField(By.cssSelector(LOGIN_CSS_SELECTOR_STR), userEmailStr);
        // enter pwd
        // todo: change selector to a better one
        fillTheInputField(By.cssSelector(".login_login__3EHKB input:nth-child(2)"), pwdStr);
        // click Login Btn
        // todo: change selector to a better one
        WebElement registerBtn = wd.findElement(By.cssSelector("button:nth-child(5)"));
        registerBtn.click();
        // wait till the page is loaded

        // todo:
        // Option 1: check/assert that Sign Out btn is present/user is signed in

        // todo:
        // Option 2: check/assert that "No Contacts here!" block is present on the page

    }
}
