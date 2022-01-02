package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class OscarS_Three_Test_Scenarios {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void task1() throws InterruptedException {
        /*
        Task1:
        1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        2. Click on "Click me, to Open an alert after 5 seconds"
        3. Explicitly wait until alert is present
        4. Then handle the Javascript alert
         */
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement clickMEToOpen = driver.findElement(By.id("alert"));
        clickMEToOpen.click();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert();
        System.out.println("Alert Window: " + driver.switchTo().alert().getText());
        Assert.assertEquals("I got opened after 5 secods",driver.switchTo().alert().getText());
        Thread.sleep(2000);
        alert.accept();

    }
    @Test
    public void task2(){
        /*
        Task2:
        1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        2. Click on "Enable button after 10 seconds"
        3. Explicitly wait until the button is enabled
        4. Then verify the button is enabled
         */

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.cssSelector("#enable-button")).click();

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement button = driver.findElement(By.id("disable"));
        System.out.println("Before button.isEnabled() = " + button.isEnabled());
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Assert.assertTrue(button.isEnabled(),"verify button enable");
        System.out.println("After button.isEnabled() = " + button.isEnabled());

    }
    @Test
    public void task3() throws InterruptedException {
        /*
        Task3:
        1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        2. Login with username: Tester, password: test
        3. Click  Order button
        4. Verify under Product Information, selected option is “MyMoney”
        5. Then select FamilyAlbum, make quantity 2, and click Calculate,
        6. Then verify Total is equal to Quantity*PricePerUnit
         */

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement usernameInputBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameInputBox.sendKeys("Tester");

        WebElement passwordInputBox = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passwordInputBox.sendKeys("test");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

//        Alert alert= driver.switchTo().alert();
//        driver.switchTo().alert();
//        alert.dismiss();

        driver.findElement(By.xpath("//ul[@id='ctl00_menu']/li[3]/a")).click();

        WebElement productOptions = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        String expectedOption = "MyMoney";

        Select select= new Select(productOptions);
        String actualOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify MyMoney is selected");

        System.out.println("Selected option -> " + select.getFirstSelectedOption().getText());

        List<WebElement> productList = driver.findElements(By.tagName("option"));
        System.out.println("productList.size() = " + productList.size());
        for (WebElement option: productList) {
            System.out.println(option.getText());
        }
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(productList.get(1)));
        productList.get(1).click();

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        Thread.sleep(1000);

        WebElement quantityBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        WebElement pricePerUnitBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtUnitPrice"));
        WebElement totalBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtTotal"));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        int expectedPrice = 160;


        System.out.println("pricePerUnitBox.isEnabled() = " + pricePerUnitBox.isEnabled());
        System.out.println("pricePerUnitBox.getText() = " + pricePerUnitBox.getAttribute("value"));
        System.out.println("totalBox.getAttribute(\"value\") = " + totalBox.getAttribute("value"));
//        if (Integer.parseInt(quantityBox.getAttribute("value"))*Integer.parseInt(pricePerUnitBox.getAttribute("value"))==
//                Integer.parseInt(totalBox.getAttribute("value"))){
//            System.out.println("Total amount is correct. Test PASS");
//        }else{
//            System.out.println("Test FAIL");
//        }

        if (expectedPrice==Integer.parseInt(totalBox.getAttribute("value"))){
            System.out.println("Total amount is correct. Task3 --> PASS");
        }else{
            System.out.println("Task3 --> FAIL");
        }

    }

}
