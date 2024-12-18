package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getText {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement element = driver.findElement(By.className("login_logo"));
        System.out.println("Login page has text: " + element.getText());
        WebElement loginCredentials = driver.findElement(By.className("login_credentials"));
        System.out.println("Login page has login credentials text: " + loginCredentials.getText());

    }

}
