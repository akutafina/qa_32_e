package com.telran.phonebookframework.fw;

import com.google.common.io.Files;
import com.telran.phonebookframework.model.User;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public static final String DEFAULT_APP_HOST_STR = "https://contacts-app.tobbymarshall815.vercel.app";
    protected String browser;
    protected WebDriver wd;
    MenuHelper menuHelper;
    LoginPageHelper loginPageHelper;
    AddContactsPageHelper addContactsPageHelper;
    ContactsPageHelper contactsPageHelperl;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public MenuHelper getMenuHelper() {
        return menuHelper;
    }

    public LoginPageHelper getLoginPageHelper() {
        return loginPageHelper;
    }

    public AddContactsPageHelper getAddContactsPageHelper() {
        return addContactsPageHelper;
    }

    public ContactsPageHelper getContactsPageHelperl() {
        return contactsPageHelperl;
    }

    public void initApp() {
        if (browser.equals(BrowserType.CHROME))
            wd = new ChromeDriver();
        else if (browser.equals(BrowserType.FIREFOX))
            wd = new FirefoxDriver();
        else if (browser.equals(BrowserType.SAFARI))
            wd = new SafariDriver();

        loginPageHelper = new LoginPageHelper(wd);
        addContactsPageHelper = new AddContactsPageHelper(wd);
        contactsPageHelperl = new ContactsPageHelper(wd);
        menuHelper = new MenuHelper(wd);

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wd.navigate().to(DEFAULT_APP_HOST_STR);
    }

    public void stopApp() throws InterruptedException {
        //todo: remove sleep() before pushing to remote
        sleep(1);
        wd.quit();
    }

    public void goToLoginPage() {
        goToPath(LoginPageHelper.URL_PATH);
    }

    protected void goToContactsPage() {
        goToPath(ContactsPageHelper.URL_PATH );
    }

    public void goToAddContactsPage() {
        goToPath(addContactsPageHelper.URL_PATH);
    }

    protected void goToPath(String path) {
        try {
            URL currURL = new URL(wd.getCurrentUrl());
            String currHostURL = currURL.getProtocol() + "://" + currURL.getHost();
            if (currHostURL == null) currHostURL = DEFAULT_APP_HOST_STR;
            wd.navigate().to(currHostURL + path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean isStateSignedIn() {
        return menuHelper.hasSignOutButtonPresent();
    }

    public String takeScreenShot() {
        File tmpScreenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        String pathName = "screenshots/" + System.currentTimeMillis() + ".png";
        File screenshotFile = new File(pathName);
        try {
            Files.copy(tmpScreenshotFile, screenshotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathName;
    }

    public void sleep(Integer seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForContactsPageToLoad() {
        ContactsPageHelper.waitForPageToLoad();
    }

    public void waitForAddContactPageToLoad() {
        AddContactsPageHelper.waitForPageToLoad();
    }

    public void waitForLoginPageToLoad() {
        LoginPageHelper.waitForPageToLoad();
    }

    public void loginUser(User user) {
        goToLoginPage();
        waitForLoginPageToLoad();
        getLoginPageHelper().fillAndSubmitLoginForm(user);
    }
}
