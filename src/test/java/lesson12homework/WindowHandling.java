package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandling {

    public static void main(String[] args) {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        //Navigate to the page.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Maximize the browser window
        driver.manage().window().maximize();

        WebElement clickButton = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        clickButton.click();

        String mainWindowHandle = driver.getWindowHandle();

        // Get all window handles (main + child windows)
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Iterate through all window handles
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();

            // If the current window is not the main window, switch to it
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);

            }
        }

        WebElement pageTitle = driver.findElement(By.xpath("//h3[normalize-space()='New Window']"));
        String title = pageTitle.getText();
        String expectedTitle = "New Window";

        if (title.equals(expectedTitle)) {
            System.out.println(pageTitle.getText() + ":" + driver.getCurrentUrl());
        } else
            System.out.println("Wrong page title!");

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Back to main window.");
        System.out.println(driver.getTitle() + ":" + driver.getCurrentUrl());
    }
}
