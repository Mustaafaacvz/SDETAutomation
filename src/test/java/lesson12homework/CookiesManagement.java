package lesson12homework;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookiesManagement {

    public static void main(String[] args) {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        //Navigate to the page.
        driver.get("https://www.browserstack.com/test-on-the-right-mobile-devices");

        // Maximize the browser window
        driver.manage().window().maximize();

        //Add a new cookie programmatically using Selenium. (Hint: name "SpecialCookie", "SpecialValue")
        Cookie cookie = new Cookie("SpecialCookie", "SpecialValue");
        driver.manage().addCookie(cookie);
        System.out.println("Cookie added: " + cookie);

        //Retrieve and print all cookies to the console.
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println("Cookie details are: " + c);
        }

        //Delete a specific cookie by name
        driver.manage().deleteCookieNamed("SpecialCookie");
        System.out.println("Cookie 'SpecialCookie' deleted.");

        //Clear all cookies
        driver.manage().deleteAllCookies();

    }
}
