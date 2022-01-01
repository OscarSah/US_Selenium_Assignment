package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.WebDriverFactory;

public class LocatorHW {
    /**Test case 1
    Go to Ebay
    enter search term
    click on search button
    print number of results

    Test case 2
    Go to Ebay
    search Selenium
    click on search button
    verify title contains Selenium

    Test case 3
    Go to wikipedia.org (Links to an external site.)
    enter search term `selenium webdriver`
    click on search button
    click on search result `Selenium (software)`
    verify url ends with `Selenium_(software)'
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("m1 promax");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        String numberOfResult = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[1]")).getText();
        System.out.println("Number of result: " + numberOfResult);
        System.out.println("Test Case 1 -> PASS");
        Thread.sleep(3000);

//        double doubleNumberOfResult = Double.parseDouble(numberOfResult);
//        System.out.println(doubleNumberOfResult*5);

        driver.close();

        // Test Case 2
        WebDriver driver2 = WebDriverFactory.getDriver("chrome");
        driver2.manage().window().maximize();
        driver2.get("https://www.ebay.com/");

        WebElement searchBox2 = driver2.findElement(By.id("gh-ac"));
        searchBox2.sendKeys("Selenium");
        WebElement searchButton2 = driver2.findElement(By.xpath("//input[@id='gh-btn']"));
        searchButton2.click();
        Thread.sleep(2000);
        String actualTitle1 = driver2.getTitle();
        System.out.println("Page Title: " + actualTitle1);
        if (actualTitle1.toLowerCase().contains("selenium")){
            System.out.println("Current Page Title: " + actualTitle1 + " contains \"Selenium\" ");
            System.out.println("Test Case 2 -> PASS");
        }else{
            System.out.println("Test Case 2 -> FAIL");
        }
        driver2.close();

        // Test Case 3
        WebDriver driver3 = WebDriverFactory.getDriver("chrome");
        driver3.manage().window().maximize();
        driver3.get("https://www.wikipedia.org/");

        WebElement wikiSearchBox = driver3.findElement(By.id("searchInput"));
        wikiSearchBox.sendKeys("selenium webdriver");

        WebElement wikiSearchButton = driver3.findElement(By.xpath("//button[@type='submit']"));
        wikiSearchButton.click();

        WebElement seleniumSoftwareLinkElement = driver3.findElement(By.xpath("//a[.=\"Selenium (software)\"]"));
        seleniumSoftwareLinkElement.click();

        String actualURL = driver3.getCurrentUrl();
        if (actualURL.toLowerCase().substring(actualURL.length()-19).equalsIgnoreCase("selenium_(software)")){
            System.out.println("Actual URL : " + actualURL);
            System.out.println("Expected end with URL : \"...Selenium_(software)\" ");
            System.out.println("Test Case 3 --> PASS");
        }else {
            System.out.println("Actual URL : " + actualURL + " Expected URL : \"...Selenium_(software)\"");
            System.out.println(actualURL.toLowerCase().substring(actualURL.length()-19));
            System.out.println("Test Case 3 --> FAIL");
        }
        driver3.quit();


    }
}
