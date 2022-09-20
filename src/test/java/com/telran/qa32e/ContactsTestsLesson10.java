package com.telran.qa32e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactsTestsLesson10 {
    WebDriver wd;

    @BeforeMethod
    public void SetUp (){
        // System.setProperty("webdriver.chrome.driver","/Users/akutafina/Documents/tools/chromedriver");
        wd = new ChromeDriver();
        wd.navigate().to("https://www.saucedemo.com");
    }

    @Test
    public void testLocators(){
        /* First part of the lesson*/

        // by a HTML tag (v1):
        WebElement webElementByTagName = wd.findElement(By.tagName("form"));
        System.out.println("webElementByTagName: " + webElementByTagName.isDisplayed());
        // by a HTML tag (v2):
        WebElement webElementByTagCssSelector = wd.findElement(By.cssSelector("form"));
        System.out.println("webElementByTagCssSelector: " + webElementByTagCssSelector.isDisplayed());
        
        // by a class name(v1):
        WebElement webElementByClassName = wd.findElement(By.className("login-box"));
        System.out.println("webElementByClassName: " + webElementByClassName.isDisplayed());
        // by a class name(v2):
        WebElement webElementByClassCssSelector = wd.findElement(By.cssSelector(".login-box"));
        System.out.println("webElementByClassCssSelector: " + webElementByClassCssSelector.isDisplayed());

        // finding element by a class name:
        WebElement anotherWebElementByClassCssSelector = wd.findElement(By.cssSelector(".login_password"));
        System.out.println("anotherWebElementByClassCssSelector: " + anotherWebElementByClassCssSelector.isDisplayed());

        // getting all text inside nested element; finding by a HTLM tag and its parent class name:
        WebElement webElementByNestedTag = wd.findElement(By.cssSelector(".login_password h4"));
        System.out.println("webElementByNestedTag: '" + webElementByNestedTag.getText() + "'");
        // getting all text inside parent of that element; finding by its class name:
        WebElement parentElementByClassCssSelector = wd.findElement(By.cssSelector(".login_password"));
        System.out.println("parentElementByClassCssSelector: '" + parentElementByClassCssSelector.getText() + "'");

        // example of equal element found using different syntaxis:
        WebElement webElementByCssSelector1 = wd.findElement(By.cssSelector(".input_error.form_input"));
        WebElement webElementByCssSelector2 = wd.findElement(By.cssSelector("[class='input_error form_input']"));
        WebElement webElementByCssSelector3 = wd.findElement(By.cssSelector("[class='input_error form_input'][type='text']"));
        System.out.println("webElementByCssSelector3: " + webElementByCssSelector3.isDisplayed());

        /* Second part of the lesson*/

        // if WebElement has an id > use ID locator (faster, unique)
        WebElement loginBtnWebElement1 = wd.findElement(By.id("login-button"));
        System.out.println("loginBtnWebElement1: " + loginBtnWebElement1.isDisplayed());

        // just for training purposes:
        // by ID:
        WebElement loginBtnWebElement2 = wd.findElement(By.cssSelector("#login-button"));
        System.out.println("loginBtnWebElement2: " + loginBtnWebElement2.isDisplayed());

        // by class name(v1):
        WebElement loginBtnWebElement3 = wd.findElement(By.className("submit-button"));
        System.out.println("loginBtnWebElement3: " + loginBtnWebElement3.isDisplayed());
        // by class name(v1):
        WebElement loginBtnWebElement4 = wd.findElement(By.cssSelector(".submit-button"));
        System.out.println("loginBtnWebElement4: " + loginBtnWebElement4.isDisplayed());

        // by complicated class names:
        WebElement loginBtnWebElement5 = wd.findElement(By.cssSelector(".submit-button.btn_action"));
        System.out.println("loginBtnWebElement5: " + loginBtnWebElement5.isDisplayed());

        // by class name of own and it's parent (nested web elements:):
        WebElement loginBtnWebElement6 = wd.findElement(By.cssSelector(".login-box .submit-button"));
        System.out.println("loginBtnWebElement6: " + loginBtnWebElement6.isDisplayed());

        // nested web elements:
        WebElement loginBtnWebElement7 = wd.findElement(By.cssSelector(".login-box .submit-button.btn_action"));
        System.out.println("loginBtnWebElement7: " + loginBtnWebElement7.isDisplayed());

        // by class name (substring):
        WebElement loginBtnWebElement8 = wd.findElement(By.cssSelector("[class^='submit-button']"));
        System.out.println("loginBtnWebElement8: " + loginBtnWebElement8.isDisplayed());
        // by class name (substring):
        WebElement loginBtnWebElement9 = wd.findElement(By.cssSelector("[class$='btn_action']"));
        System.out.println("loginBtnWebElement9: " + loginBtnWebElement9.isDisplayed());
        // by class name (substring):
        WebElement loginBtnWebElement10 = wd.findElement(By.cssSelector("[class*='btn_action']"));
        System.out.println("loginBtnWebElement10: " + loginBtnWebElement10.isDisplayed());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        // webDriver.Close() - Close the browser window that the driver has focus of
        // webDriver.Quit() - Calls Dispose()
        // webDriver.Dispose() Closes all browser windows and safely ends the session
        wd.quit();
    }
}
