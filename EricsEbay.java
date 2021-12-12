package com.cybertek.tests.assignment;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EricsEbay {
    public static void main(String[] args) throws InterruptedException {

        /*
        Locator HW
        Feel free to use any project for automation.
        Test case 1
        Go to Ebay
        enter search term
        click on search button
        print number of results
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //go to ebay
        driver.get("https://www.ebay.com/%22");

                //enter search term (book)
                WebElement searchItem = driver.findElement(By.xpath("//input[@type='text']"));
        searchItem.sendKeys("book");

        //click on search button
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        //print number of results
        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println("result = " + result.getText());

        Thread.sleep(5000);
        driver.quit();
    }
}