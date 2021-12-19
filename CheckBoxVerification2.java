package com.cybertek.tests.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxVerification2 {
    @Test
    public void testCase2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Thread.sleep(2000);

        //2.	Login with-----Username: Tester, password: test
        WebElement usernameBox = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passwordBox.sendKeys("test");
        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(1000);

        //3.	Click on check all button verify all the checkboxes are checked
//        WebElement checkAllButton = driver.findElement(By.cssSelector("#ctl00_MainContent_btnCheckAll"));
//        checkAllButton.click();

        // this part for click each checkbox
        List<WebElement> checkBoxEach = driver.findElements(By.xpath("(//input[@type='checkbox'])"));
        for (int i=1 ; i<=checkBoxEach.size() ; i++){
            checkBoxEach.set(i-1, driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")));
            checkBoxEach.get(i-1).click();
            Thread.sleep(500);
            Assert.assertTrue(checkBoxEach.get(i-1).isSelected(),"Verifing checkbox " + i + " selected");
        }
        Thread.sleep(2000);

        for (int i=1 ; i<=8 ; i++){
            String checkBoxXpaths = "(//input[@type='checkbox'])[" + i + "]";
            WebElement checkBox = driver.findElement(By.xpath(checkBoxXpaths));
            Assert.assertTrue(checkBox.isSelected(), "Verifing checkbox \" + inputBoxes + \" selected");
//            System.out.println("Element name: " + checkBox.getAttribute("name"));
        }


        //4.	Click on uncheck all button verify that all the checkboxes are unchecked
        WebElement unCheckAllButton = driver.findElement(By.cssSelector("#ctl00_MainContent_btnUncheckAll"));
        unCheckAllButton.click();
        Thread.sleep(2000);

        for (int i=1 ; i<=8 ; i++){
            String checkBoxXpaths = "(//input[@type='checkbox'])[" + i + "]";
            WebElement checkBox = driver.findElement(By.xpath(checkBoxXpaths));
            Assert.assertFalse(checkBox.isSelected(), "Verifing checkbox " + checkBox + " is not selected");
//            System.out.println("Element name: " + checkBox.getAttribute("name"));
        }

        List<WebElement> checkBoxesBeforeDelete = driver.findElements(By.xpath("(//input[@type='checkbox'])"));
        int firstListQuantity = checkBoxesBeforeDelete.size();
        System.out.println("Before delete, elements numbers is " + firstListQuantity);

        //5.	Select one of the checkbox and delete one person
        WebElement Bob = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));
        Bob.click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete")).click();
        Thread.sleep(2000);

        //6.	Then verify that deleted item is no longer exists

        List<WebElement> checkBoxesAfterDelete = driver.findElements(By.xpath("(//input[@type='checkbox'])"));
        int lastListQuantity = checkBoxesAfterDelete.size();
        System.out.println("After delete, elements numbers is " + lastListQuantity);

        for (WebElement inputBoxes: checkBoxesAfterDelete) {
            Assert.assertFalse(inputBoxes.isSelected(),"Verifing checkbox " + inputBoxes + " selected");
        }
        if (lastListQuantity==firstListQuantity-1){
            System.out.println("Only 1 line was deleted");
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.close();
    }
}
