package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        List<WebElement> formInputArea = driver.findElements(By.className("form_group"));
        System.out.println("Number of elements on SauceDemo: " + formInputArea.size());


        driver.get("https://demo.guru99.com/test/ajax.html");
        List<WebElement> elements = driver.findElements(By.name("name"));
        System.out.println("Number of elements on DemoQA: " + elements.size());


        driver.get("https://www.tutorialspoint.com/index.htm");
        //identify all links with findElements
        List m =driver.findElements(By.tagName("a"));
        //link counts
        int st = m.size();
        System.out.println("Number of links: "+ st);

    }
}
