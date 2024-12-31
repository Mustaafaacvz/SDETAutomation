package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getAttribute {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement Username = driver.findElement(By.id("user-name"));
        System.out.println("Attribute: " + Username.getAttribute("autocapitalize") );
        Username.sendKeys("Test Username");
        Username.getAttribute("value");
        System.out.println("value after typing username: " + Username.getAttribute("value"));

    }
}
