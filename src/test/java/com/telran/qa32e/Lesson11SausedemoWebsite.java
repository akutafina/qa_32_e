package com.telran.qa32e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lesson11SausedemoWebsite {
    WebDriver wd;

    @BeforeMethod
    public void SetUp () throws InterruptedException {
        // System.setProperty("webdriver.chrome.driver","/Users/akutafina/Documents/tools/chromedriver");
        wd = new ChromeDriver();
        wd.navigate().to("https://www.saucedemo.com");

        //maximise browser to window width
        TimeUnit.SECONDS.sleep(3);
        wd.manage().window().maximize();
        //wait for the web page to fully load
        // implicit wait:
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
   }

    @Test
    public void testLoginBtn(){
        // explicit wait - wait for the elements
        WebElement firstResult = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("login-button")));

        // fluent wait - checks the elements: https://blog.knoldus.com/what-is-fluent-wait-and-its-advantages-in-selenium

        System.out.println("Test!");
        // if WebElement has an id > use ID locator (faster, unique)
        WebElement loginBtnWebElement = wd.findElement(By.id("login-button"));
        loginBtnWebElement.click();
    }

    @Test
    public void testFooter(){
        // if WebElement has an id > use ID locator (faster, unique)
//        WebElement footerText1 = wd.findElement(By.cssSelector("#login_credentials h4"));
//        String footerText1Str = footerText1.getText();
//        System.out.println("footerText1: '" + footerText1Str + "'");
//        Assert.assertEquals(footerText1Str,"Accepted usernames are:");
//        Assert.assertTrue(footerText1Str.contains("Accepted usernames are:"));
    }


    @Test
    public void testTableCssSelectors(){
        // if WebElement has an id > use ID locator (faster, unique)
//        WebElement footerText1 = wd.findElement(By.cssSelector("tr:nth-child(4) td:first-child"));
//        String footerText1Str = footerText1.getText();
//        System.out.println("footerText1: '" + footerText1Str + "'");
//        Assert.assertEquals(footerText1Str,"Accepted usernames are:");
//        Assert.assertTrue(footerText1Str.contains("Accepted usernames are:"));
        // you can do without variables also
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        // webDriver.Close() - Close the browser window that the driver has focus of
        // webDriver.Quit() - Calls Dispose()
        // webDriver.Dispose() Closes all browser windows and safely ends the session
        wd.quit();
    }
}
