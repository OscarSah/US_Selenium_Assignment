package com.cybertek.tests.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW2 {
    public static void main(String[] args) throws InterruptedException {
        //Step1
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Step2
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //Step 3
        WebElement home = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement forgotPasswordText = driver.findElement(By.xpath("//h2"));
        WebElement emailText = driver.findElement(By.xpath("(//input [@name=\"email\"]/..)//*[contains(text(),'E-mail')]"));
        WebElement emailBox = driver.findElement(By.xpath("//input [@name=\"email\"]"));
        WebElement buttonRetrieve = driver.findElement(By.xpath("//*[@id=\"form_submit\"]"));
        WebElement poweredByText = driver.findElement(By.xpath("//div[contains(text(), 'Powered by ')]"));
        WebElement cybertekSchoolLink = driver.findElement(By.xpath("//a[.='Cybertek School']"));

        //Step 4
        System.out.println("home = " + home);
        System.out.println("forgotPasswordText = " + forgotPasswordText);
        System.out.println("emailText = " + emailText);
        System.out.println("emailBox = " + emailBox);
        System.out.println("buttonRetrieve = " + buttonRetrieve.toString());

        emailBox.sendKeys("mike@smith.com");
        Thread.sleep(2000);
        emailBox.clear();
        Thread.sleep(2000);
        emailBox.sendKeys("alice@wonderworld.com");
        buttonRetrieve.click();
        Thread.sleep(2000);

        driver.quit();


    }
}
