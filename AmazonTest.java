package com.cybertek.tests.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    /**
     * TASK
     * go to amazon.com
     * search for selenium
     * click search button
     * verify 1-48 of 304 results for "Java"
     *
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");
        driver.findElement(By.id("nav-search-submit-button")).click();

        String expectedResult = "1-48 of 304 results for \"Java\"";

        WebElement actualResultText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]"));
        String actualResult = actualResultText.getText();
        WebElement actualResultText2 = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]"));
        System.out.println("actualResult = " + actualResult + " " + actualResultText2.getText());
        Thread.sleep(3000);

        driver.quit();

        if (expectedResult.equals(actualResult)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }
}
