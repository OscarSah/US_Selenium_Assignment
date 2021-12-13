package com.cybertek.tests.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHWTest1 {
    /**
     * Test case
     *  Go to Ebay
     *  search Selenium
     *  click on search button
     *  print number of results
     *  verify title contains Selenium
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));      // with id locator
//        WebElement searchBox = driver.findElement(By.name("_nkw"));   // with name locator

        String expectedSearchItem = "Selenium";
        searchBox.sendKeys(expectedSearchItem);

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        WebElement searchResultElement = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));

        String searchResultText = searchResultElement.getText();
        String [] arr = searchResultText.split(" ");
        double searchedResultsNumber = Double.parseDouble(arr[0].replaceFirst(",",""));
        System.out.println("Number of search results= " + searchedResultsNumber);

        driver.close();

    }
}
