package com.telran.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    // todo: move more values to the variable
    static final String LOGIN_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(1)";
    static final int WAITING_TIME_SEC = 10;
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        // create a user - skipped to simplify
        // open web page
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        //wait till it's loaded
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        wd.quit();
    }

    public void fillTheInputField(By by, String key) {
        WebElement inputFieldWebElement = wd.findElement(by);
        inputFieldWebElement.clear();
        inputFieldWebElement.click();
        inputFieldWebElement.sendKeys(key);
    }
}
