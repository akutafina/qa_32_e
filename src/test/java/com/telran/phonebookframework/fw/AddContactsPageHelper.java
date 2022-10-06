package com.telran.phonebookframework.fw;

import com.telran.phonebookframework.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AddContactsPageHelper extends BaseHelper {
public static final String INPUT_FIELD_NAME_XPATH_STR = "//input[@placeholder='Name']";
    public static final String URL_PATH = "/add";
    private static final String INPUT_FIELD_LAST_NAME_XPATH_STR = "//input[@placeholder='Last Name']";
    private static final String INPUT_FIELD_PHONE_XPATH_STR = "//input[@placeholder='Phone']";
    private static final String INPUT_FIELD_EMAIL_STR = "//input[@placeholder='email']";
    private static final String INPUT_FIELD_ADDRESS_XPATH_STR = "//input[@placeholder='Address']";
    private static final String INPUT_FIELD_DESCRIPTION_XPATH_STR = "//input[@placeholder='description']";
    private static final String BUTTON_SAVE_TO_ADD_CONTACT_XPATH_STR = "//b[contains(text(), 'Save')]";
    private static final String ADD_CONTACTS_PAGE_CONTAINER_CLASS = "add_main__1tbl_";

    public AddContactsPageHelper(WebDriver wd) {
        super(wd);
    }

    public static void waitForPageToLoad() {
            waitForElementToLoad(By.className(ADD_CONTACTS_PAGE_CONTAINER_CLASS));
    }

    public void fillAndSubmitContactsInfoForm(Contact contact) {
        wd.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
        fillInputField(By.xpath(INPUT_FIELD_NAME_XPATH_STR), contact.getName());
        fillInputField(By.xpath(INPUT_FIELD_LAST_NAME_XPATH_STR), contact.getLastName());
        fillInputField(By.xpath(INPUT_FIELD_PHONE_XPATH_STR), contact.getPhone());
        fillInputField(By.xpath(INPUT_FIELD_EMAIL_STR), contact.getEmail());
        fillInputField(By.xpath(INPUT_FIELD_ADDRESS_XPATH_STR), contact.getAddress());
        fillInputField(By.xpath(INPUT_FIELD_DESCRIPTION_XPATH_STR), contact.getDescription());
        WebElement saveButton = wd.findElement(By.xpath(BUTTON_SAVE_TO_ADD_CONTACT_XPATH_STR));
        saveButton.click();
    }
}
