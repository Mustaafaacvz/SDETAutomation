package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


public class RelativeLocatorsAbove {

    public static void main(String[] args) throws InterruptedException{

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        // launching a browser and navigate to a URL
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");

        // identify first element
        WebElement e = driver.findElement(By.xpath("(//*[@id='collapseOne']/div/ul/li/a)[3]"));

        // identify element above the first element
        WebElement a = driver.findElement(RelativeLocator.with(By.tagName("a")).above(e));

        // Getting element text value the above identified element
        System.out.println("Gettig Element text: " + a.getText() );

        driver.quit();
    }
}
