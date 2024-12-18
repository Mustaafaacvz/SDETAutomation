package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findelement {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("Mustafa");
        Thread.sleep(3000);
        userNameInputField.clear();
    }
}
