package com.telran.phonebookframework.fw;

import com.telran.phonebookframework.model.Contact;
import com.telran.phonebookframework.model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newUsersForPositiveLoginPageTest(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{ new User("michael@gmail.com","ZZxcv_1!")});
        list.add(new Object[]{ new User("michael1@gmail.com","ZZxcv_1!")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newUsersForPositiveLoginPageTestFromFile() {
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/usersForPositiveLoginPageTestFromFile.csv"));
            String line = bufferedReader.readLine();
            while(line!=null){
                // line = "michael@gmail.com,ZZxcv_1!"
                String[] lineValues =  line.split(",");
                // lineValues = ["michael@gmail.com","ZZxcv_1!"]
                list.add(new Object[]{ new User(lineValues[0],lineValues[1])});
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> newContactsForPositiveContactPageTestFromFile() {
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/contactsForPositiveContactPageTest.csv"));
            String line = bufferedReader.readLine();
            while(line!=null){
                String[] lineValues =  line.split(",");
                list.add(new Object[]{ new Contact(lineValues[0], lineValues[1], lineValues[2], lineValues[3], lineValues[4], lineValues[5])});
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newContactsForPositiveContactPageTest() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new Contact("testName", "testLastName", "123456789", "testEmail@gmail.com", "testAddress", "testDescription")});
        list.add(new Object[]{new Contact("anotherTestName", "anotherTestLastName", "9876543210", "anotherTestEmail@gmail.com", "anotherTestAddress", "anotherTestDescription")});
        return list.iterator();
    }

}
