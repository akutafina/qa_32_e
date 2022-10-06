package com.telran.phonebookframework.tests;


import com.telran.phonebookframework.fw.DataProviders;
import com.telran.phonebookframework.model.Contact;
import com.telran.phonebookframework.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTests extends TestBase {

    User defaultUserForContactsTest = new User("michael1@gmail.com", "ZZxcv_1!");

    @BeforeMethod
    public void contactsPageTestSetUp() {
        if (!app.isStateSignedIn()) {
            app.loginUser(defaultUserForContactsTest);
            logger.info("Dasult user for the Contacts Page Test is used. Email: "
                    + defaultUserForContactsTest.getEmail()
                    + ", password: " + defaultUserForContactsTest.getPwd());
            app.waitForContactsPageToLoad();
        }
    }

    @Test(dataProvider = "newContactsForPositiveContactPageTest", dataProviderClass = DataProviders.class)
    public void testAddAndRemoveContactPositive(Contact contact) {
        app.goToAddContactsPage();
        app.waitForAddContactPageToLoad();
        app.getAddContactsPageHelper().fillAndSubmitContactsInfoForm(contact);
        app.waitForContactsPageToLoad();
        Assert.assertTrue(app.getContactsPageHelperl().getContactCardsAmount() > 0, "Contact is added");
        app.getContactsPageHelperl().removeContact();
        Assert.assertTrue(app.getContactsPageHelperl().getContactCardsAmount() == 0, "Contact is deleted");
    }


    @Test(dataProvider = "newContactsForPositiveContactPageTestFromFile", dataProviderClass = DataProviders.class)
    public void testAddAndRemoveContactPositiveFromFile(Contact contact) {
        app.goToAddContactsPage();
        app.waitForAddContactPageToLoad();
        app.getAddContactsPageHelper().fillAndSubmitContactsInfoForm(contact);
        app.waitForContactsPageToLoad();
        Assert.assertTrue(app.getContactsPageHelperl().getContactCardsAmount() > 0, "Contact is added");
        app.getContactsPageHelperl().removeContact();
        Assert.assertTrue(app.getContactsPageHelperl().getContactCardsAmount() == 0, "Contact is deleted");
    }

}


