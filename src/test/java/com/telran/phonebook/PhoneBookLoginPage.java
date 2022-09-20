package com.telran.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PhoneBookLoginPage extends TestBase {
    // todo: move more values to the variable
    static final String LOGIN_PAGE_URL_STR = "https://contacts-app.tobbymarshall815.vercel.app/login";
    static final String LOGIN_FORM_CLASS_NAME = "login_login__3EHKB";
    static final String USER_EMAIL_STR = "michael@gmail.com";

    @BeforeMethod
    public void loginSetUp() {
        // navigate streight to the login page
        wd.navigate().to(LOGIN_PAGE_URL_STR);
        //wait till it's loaded
        wd.manage().timeouts().implicitlyWait(WAITING_TIME_SEC, TimeUnit.SECONDS);
        assertElementIsPresent(By.className(LOGIN_FORM_CLASS_NAME), "Login form");
    }

    @Test
    public void testLoginForm() throws InterruptedException {
        loginUser(USER_EMAIL_STR, "ZZxcv_1!");

        // check that the user is signed in
        assertElementIsPresent(By.xpath("//button[text()='Sign Out']"), "Log Out button");

        // The second way to make the same assertions is:
        // Assert.assertTrue(isWebElementPresent(By.cssSelector("button")) == true, "Log Out button is present");
        // The third way to make the same assertions is:
        // Assert.assertEquals(isWebElementPresent(By.cssSelector("button")),true,"Log Out button is present (second assertion)");

        System.out.println("Signed in!");
    }

    private void assertElementIsPresent(By by, String message) {
        Assert.assertTrue(isWebElementPresent(by), message + " is present");
    }

    public void loginUser(String userEmailStr, String pwdStr) {
        // enter email
        fillTheInputField(By.cssSelector(LOGIN_CSS_SELECTOR_STR), userEmailStr);
        // enter pwd
        fillTheInputField(By.cssSelector(".login_login__3EHKB input:nth-child(2)"), pwdStr);
        // click Login Btn
        WebElement loginBtn = wd.findElement(By.cssSelector("button:nth-child(4)"));
        loginBtn.click();
        //wait till the page is loaded
        WebElement firstContactPageResult = new WebDriverWait(wd, WAITING_TIME_SEC)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.className("contact-page_main__32Irj"))));
    }

    public boolean isWebElementPresent(By by) {
        // Option 1:
        if (wd.findElements(by).size() > 0) return true;
        else return false;
    }

    // Option 2: try-catch]
    /*
    public boolean isWebElementPresentWithTryCatch() {
        try {
            WebElement webElement = wd.findElement(By.cssSelector("button"));
            return true;
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }
     */

}
