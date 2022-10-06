package com.telran.phonebookframework.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelper {
    public static final int IMPLICIT_WAIT_TIME_SEC = 2;
    public static final int EXPLICIT_WAIT_TIME_SEC = 3;

    protected static WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    protected void fillInputField(By by, String key) {
        WebElement inputFieldWebElement = wd.findElement(by);
        inputFieldWebElement.clear();
        inputFieldWebElement.click();
        inputFieldWebElement.sendKeys(key);
    }

    protected void clickOn(By locator) {
        WebElement webElement = wd.findElement(locator);
        webElement.click();
    }

    public boolean isWebElementPresent(By by) {
        return wd.findElements(by).size() > 0;
    }

    protected static void waitForElementToLoad(By by){
        WebDriverWait wait = new WebDriverWait(wd,EXPLICIT_WAIT_TIME_SEC);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected static void waitForOneOfTheElementsToLoad(By by1, By by2){
        WebDriverWait wait = new WebDriverWait(wd,EXPLICIT_WAIT_TIME_SEC);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(by1),
                ExpectedConditions.presenceOfElementLocated(by2)));
    }
}
