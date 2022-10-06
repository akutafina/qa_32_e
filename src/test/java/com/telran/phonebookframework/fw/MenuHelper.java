package com.telran.phonebookframework.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MenuHelper extends BaseHelper {
    private static final String LOGOUT_BTN_XPATH_SELECTOR_STR = "//button[text()='Sign Out']";

    public MenuHelper(WebDriver wd) {
        super(wd);
    }

    public boolean hasSignOutButtonPresent() {
        wd.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
        return isWebElementPresent(By.xpath(LOGOUT_BTN_XPATH_SELECTOR_STR));
    }

}
