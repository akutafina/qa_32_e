package com.telran.phonebookframework.fw;

import com.telran.phonebookframework.model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPageHelper extends BaseHelper {
    private static final String LOGIN_FAILED_400_ERROR_MSG_TEXT_STR = "Login Failed with code 400";
    private static final String LOGIN_ERROR_MSG_XPATH_SELECTOR_STR = "//div[text() = '$loginFailedMessageTxt']";
    private static final String LOGIN_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(1)";
    private static final String PWD_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(2)";
    private static final String LOGIN_BTN_CSS_SELECTOR_STR = "button:nth-child(4)";
    private static final String LOGIN_PAGE_CONTAINER_CLASS = "login_login__3EHKB";

    public static final String URL_PATH = "/login";
    public static final String EMAIL_INPUT_FIELD_CSS = ".login_login__3EHKB input:nth-child(1)";
    public static final String PWD_INPUT_FIELD_CSS = ".login_login__3EHKB input:nth-child(2)";
    public static final String REGISTER_BTN_CSS = "button:nth-child(5)";

    public LoginPageHelper(WebDriver wd) {
        super(wd);
    }

    public static void waitForPageToLoad() {
        waitForElementToLoad(By.className(LOGIN_PAGE_CONTAINER_CLASS));
    }

    public void fillAndSubmitLoginForm(User currentUser) {
        fillInputField(By.cssSelector(LOGIN_CSS_SELECTOR_STR), currentUser.getEmail());
        fillInputField(By.cssSelector(PWD_CSS_SELECTOR_STR), currentUser.getPwd());
        clickOn(By.cssSelector(LOGIN_BTN_CSS_SELECTOR_STR));
    }

    public void registerUser(User user) {
        fillInputField(By.cssSelector(EMAIL_INPUT_FIELD_CSS), user.getEmail());
        fillInputField(By.cssSelector(PWD_INPUT_FIELD_CSS), user.getPwd());
        clickOn(By.cssSelector(REGISTER_BTN_CSS));
    }

    public void clickOnErrorAlert() {
        Alert invalidEmailOrPwdAlert = new WebDriverWait(wd, IMPLICIT_WAIT_TIME_SEC)
                .until(ExpectedConditions.alertIsPresent());
        // click Ok in the Alert window
        wd.switchTo().alert();
        invalidEmailOrPwdAlert.accept();
    }

    public boolean isLoginErrorMessagePresent(String errorMsgTextStr) {
        return wd.findElements(By.xpath(LOGIN_ERROR_MSG_XPATH_SELECTOR_STR.replace
        //was:
        //("$loginFailedMessageTxt", LOGIN_FAILED_400_ERROR_MSG_TEXT_STR))).size() > 0;
        //fix:
        ("$loginFailedMessageTxt", errorMsgTextStr))).size() > 0;
    }

}
