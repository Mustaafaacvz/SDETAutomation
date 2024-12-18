package lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getMethods {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("Page Title: "+ driver.getTitle());
        System.out.println("Current URL: "+ driver.getCurrentUrl());
    }
}
