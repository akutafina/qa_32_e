package com.telran.qa32e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson11TableSelectors {
    WebDriver wd;

    @BeforeMethod
    public void SetUp (){
        // System.setProperty("webdriver.chrome.driver","/Users/akutafina/Documents/tools/chromedriver");
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_selectors.asp");

        //maximise browser to window width
//        wd.manage().window().maximize();
        //wait for the web page to fully load

        // implicit wait:
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // explicit wait - wait for the elements

        // fluent wait - checks the elements: https://blog.knoldus.com/what-is-fluent-wait-and-its-advantages-in-selenium
    }

    @Test
    public void testTableCssSelectors(){
        // return the 1st row
        WebElement firstRow = wd.findElement(By.cssSelector("tr:nth-child(1)"));
        System.out.println("Text in the 1st row: " + firstRow.getText());
//      https://www.w3.org/wiki/CSS/Selectors/pseudo-classes/:nth-last-child#:~:text=The%20%3Anth%2Dlast%2Dchild,and%20has%20a%20parent%20element

        // returns 2nd row and the 1st value
        WebElement tableElement2 = wd.findElement(By.cssSelector("tr:nth-child(2) td:first-child"));
        System.out.println("tableElement2 text: " + tableElement2.getText());
//        // alt+enter - introduses local variable
//        // sout - System.out.println

        // returns 2nd row and the last value
        WebElement tableElement3 = wd.findElement(By.cssSelector("tr:nth-child(2) td:last-child"));
        System.out.println("tableElement3 text: " + tableElement3.getText());

        // returns 2nd row and the 2nd value
        WebElement tableElement4 = wd.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)"));
        System.out.println("tableElement4 text: " + tableElement4.getText());

        // returns 3 elements of the 1st row
        List<WebElement> row3TableElements = wd.findElements(By.cssSelector("tr:nth-child(1) th"));
        System.out.println("row3TableElements size: " + row3TableElements.size());

//        for (WebElement currWebElement:
//             row3TableElements) {
//            System.out.println("Current text in foreach cycle: "  + currWebElement.getText());
//        }
//
//        for (int i = 0; i < row3TableElements.size(); i++) {
//            System.out.println("Current text in cycle for: "  + row3TableElements.get(i).getText());;
//        }

        // returns 6 elements = values of the 1st column, all rows
        List<WebElement> firstColumtTableElements = wd.findElements(By.cssSelector("td:nth-child(1)"));
        System.out.println("firstColumtTableElements size: " + firstColumtTableElements.size());

        for (int i = 0; i < firstColumtTableElements.size(); i++) {
            System.out.println("Current text in cycle for: "  + firstColumtTableElements.get(i).getText());;
        }

        // returns 3 elements of the header (th tag)
        List<WebElement> thTableElements = wd.findElements(By.cssSelector("th"));
        System.out.println("thTableElements size: " + thTableElements.size());
    }

    @AfterMethod
//    @AfterMethod (enabled=false)
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        // webDriver.Close() - Close the browser window that the driver has focus of
        // webDriver.Quit() - Calls Dispose()
        // webDriver.Dispose() Closes all browser windows and safely ends the session
        wd.quit();
    }
}
