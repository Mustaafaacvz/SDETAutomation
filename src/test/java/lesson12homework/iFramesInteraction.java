package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFramesInteraction {

    public static void main(String[] args) {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        //Navigate to the page.
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Maximize the browser window
        driver.manage().window().maximize();


        //Perform the following actions:
        //Switch to the top frame and validate its content (e.g., "TOP").
        //Inside the top frame, switch to the left frame and validate its content (e.g., "LEFT").
        //Switch to the right frame and validate its content (e.g., "RIGHT").
        //Switch to the bottom frame and validate its content (e.g., "BOTTOM").
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        WebElement leftFrame = driver.findElement(By.tagName("body"));
        System.out.println("Left frame context: " + leftFrame.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");

        WebElement rightFrame = driver.findElement(By.tagName("body"));
        System.out.println("Right frame context: " + rightFrame.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        WebElement bottomFrame = driver.findElement(By.tagName("body"));
        System.out.println("Bottom frame context: " + bottomFrame.getText());


        // Switch the WebDriver's context back to the main (parent) page
        driver.switchTo().defaultContent();

        // Close the browser.
        driver.quit();
    }
}
