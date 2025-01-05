package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class denemeseneryolari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        driver.manage().window().maximize();


        WebElement clickMe = driver.findElement(By.xpath("//button[@id='dRDu6']"));
        clickMe.click();

        System.out.println("test");

    }
}
