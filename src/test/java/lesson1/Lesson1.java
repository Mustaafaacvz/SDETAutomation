package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson1 {

    public static void main(String[] args) {

        // Create an instance of the ChromeDriver class to initialize the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Use the driver instance to open the specified URL in the browser
        driver.get("https://selenium.dev");


    }
}
