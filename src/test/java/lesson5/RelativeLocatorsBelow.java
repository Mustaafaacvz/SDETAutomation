package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsBelow {

    public static void main(String[] args) throws  InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");

        WebElement login= driver.findElement(By.xpath("//*[@value='Login']"));

        WebElement NewUser = driver.findElement(RelativeLocator.with(By.tagName("a")).below(login));

        System.out.println("Getting element text: "+ NewUser.getText());

        driver.quit();
    }
}
