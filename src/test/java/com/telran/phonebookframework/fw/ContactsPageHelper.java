package com.telran.phonebookframework.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactsPageHelper extends BaseHelper {

    public static final String URL_PATH = "/contacts";
    private static final String EXISTING_CONTACT_CARD_CSS_STR = ".contact-item_card__2SOIM";
    private static final String BUTTON_REMOVE_TO_REMOVE_CONRACR_CARD_XPATH_STR = "//button[contains(text(),'Remove')]";
    private static final String CONTACT_PAGE_CONTAINER_WITHOUT_CONTACTS_CLASS = "contact-page_message__2qafk";
    private static final String CONTACT_PAGE_CONTActs_CONTAINER_WITH_CONTACTS_CLASS = "contact-page_contactspage__2TPwe";


    public ContactsPageHelper(WebDriver wd) {
        super(wd);
    }

    public static void waitForPageToLoad() {
        System.out.println("looking_for_contact_page_to_load..");
        waitForOneOfTheElementsToLoad(By.className(CONTACT_PAGE_CONTAINER_WITHOUT_CONTACTS_CLASS),
                By.className(CONTACT_PAGE_CONTActs_CONTAINER_WITH_CONTACTS_CLASS));
    }

    public void clickOnContactCard() {
        wd.findElement(By.cssSelector(EXISTING_CONTACT_CARD_CSS_STR)).click();
    }

    public void clickOnContactCard(int i) {
        List<WebElement> contactCardsWebElement = wd.findElements(By.cssSelector(EXISTING_CONTACT_CARD_CSS_STR));
        contactCardsWebElement.get(i - 1).click();
    }

    public void clickOnRemoveContact() {
        clickOn(By.xpath(BUTTON_REMOVE_TO_REMOVE_CONRACR_CARD_XPATH_STR));

    }

    public void removeContact() {
        wd.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
        clickOnContactCard();
        clickOnRemoveContact();
        waitForElementToLoad(By.className(CONTACT_PAGE_CONTAINER_WITHOUT_CONTACTS_CLASS));
    }

    public void removeContact(Integer idx) {
        //todo: implement
    }

    public void removeContact(String suname) {
        //todo: implement
    }

    public int getContactCardsAmount() {
        List<WebElement> contactCardsArray = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        return contactCardsArray.size();
    }

}
