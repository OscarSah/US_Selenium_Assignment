package tests;
import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    /*
    1. Open browser
    2. Go to website https://google.com
    3. Save the title in a string variable
    4. Go to https://etsy.com
    5. Save the title in a string variable
    6. Navigate back to previous page
    7. Verify that title is same is in step 3
    8. Navigate forward to previous page
    9. Verify that title is same is in step 5
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String googleTitle = driver.getTitle();

        driver.get("https://etsy.com");
        String etsyTitle = driver.getTitle();
        Thread.sleep(3000);

        driver.navigate().back();
        if (driver.getTitle().equals(googleTitle)){
            System.out.println("Google Title verify -> PASS");
        }else {
            System.out.println("Google Title verify -> FAIL");
        }

        driver.navigate().forward();
        if (driver.getTitle().equals(etsyTitle)){
            System.out.println("Etsy Title verify -> PASS");
        }else {
            System.out.println("Etsy Title verify -> FAIL");
        }
        driver.close();

        WebDriver driver2= BrowserFactory.getDriver("firefox");
        driver2.get("https://google.com");
        String googleTitle2 = driver2.getTitle();

        driver2.get("https://etsy.com");
        String etsyTitle2 = driver2.getTitle();
        Thread.sleep(3000);

        driver2.navigate().back();
        if (driver2.getTitle().equals(googleTitle2)){
            System.out.println("Google Title verify -> PASS");
        }else {
            System.out.println("Google Title verify -> FAIL");
        }

        driver2.navigate().forward();
        if (driver2.getTitle().equals(etsyTitle2)){
            System.out.println("Etsy Title verify -> PASS");
        }else {
            System.out.println("Etsy Title verify -> FAIL");
        }
        driver2.close();

        WebDriver driver3= BrowserFactory.getDriver("edge");
        driver3.get("https://google.com");
        String googleTitle3 = driver3.getTitle();

        driver3.get("https://etsy.com");
        String etsyTitle3 = driver3.getTitle();
        Thread.sleep(3000);

        driver3.navigate().back();
        if (driver3.getTitle().equals(googleTitle3)){
            System.out.println("Google Title verify -> PASS");
        }else {
            System.out.println("Google Title verify -> FAIL");
        }

        driver3.navigate().forward();
        if (driver3.getTitle().equals(etsyTitle3)){
            System.out.println("Etsy Title verify -> PASS");
        }else {
            System.out.println("Etsy Title verify -> FAIL");
        }
        driver3.close();


    }
}
