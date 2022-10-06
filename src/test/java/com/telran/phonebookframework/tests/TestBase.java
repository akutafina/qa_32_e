package com.telran.phonebookframework.tests;

import com.telran.phonebookframework.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.internal.TestNGMethod;

import java.lang.reflect.Method;

public class TestBase {
    protected Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void setUp() {
        app.initApp();
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        logger.info("Start test " + method.getName());
        logger.info("****************************");
    }

    @AfterMethod
    public void afterMethod(Method method){
        logger.info("Stop test " + method.getName());
        logger.info("****************************");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(ITestResult result) throws InterruptedException {
        if (!result.isSuccess()) app.takeScreenShot();
        app.stopApp();
    }

}
