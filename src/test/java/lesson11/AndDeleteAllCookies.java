package lesson11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class AndDeleteAllCookies {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // open browser session
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // Add two cookies in key-value pairs
        driver.manage().addCookie(new Cookie("C1", "VAL1"));
        driver.manage().addCookie(new Cookie("C3", "VAL3"));

        // get every cookie details
        Set<Cookie> c = driver.manage().getCookies();
        System.out.println("Cookie details are: " + c);

        // delete a cookie with its name
        driver.manage().deleteAllCookies();

        // get every cookie details after deleting cookie C2
        Set<Cookie> c2 = driver.manage().getCookies();
        System.out.println("Cookie details after deleting all cookies: " + c2);

        // Closing browser
        driver.quit();
    }
}

