package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

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

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium");
        driver.findElement(By.id("nav-search-submit-button")).click();

        String expectedResult = "results for \"selenium\"";

        WebElement actualResultText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]"));
        String actualResult = actualResultText.getText();
        WebElement actualResultText2 = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]"));
        String totalActualResult = actualResult + " " + actualResultText2.getText();
        Thread.sleep(3000);


        if (totalActualResult.contains(expectedResult)){
            System.out.println("PASS");
        }else {
            System.out.println("Expected Result -> " + expectedResult);
            System.out.println("Actual Result -> " + actualResult);
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
