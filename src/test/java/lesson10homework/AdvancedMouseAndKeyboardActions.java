package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class AdvancedMouseAndKeyboardActions {

    public static void main(String[] args) throws InterruptedException {

        //dragANDdrop();

        //demoQAButton();

        demoQATips();

    }
    public static void dragANDdrop() {
        //Navigate to the page
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/#default");

        driver.manage().window().maximize();

        //Drag the source box into the target box and validate the success message.
        //İlgili locator'ları bulamadım hiçbir yöntemle çözemedim ama gördüğüm kadarıyla draganddrop kullanımı bu şekilde.
        WebElement sourceBox = driver.findElement(By.id("draggable"));
        WebElement targetBox = driver.findElement(By.id("droppable"));

       Actions builder = new Actions(driver);

        builder.dragAndDrop(sourceBox, targetBox).build().perform();

        System.out.println(targetBox.getText());

        //Close the browser
        driver.quit();

    }

    public static void demoQAButton() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //maximise the window
        driver.manage().window().maximize();

        //Double-click on the "Double Click Me" button and validate the success message.
        //Right-click on the "Right Click Me" button and validate the success message.
        //Click on the "Click Me" button and validate the success message.
        //Click me butonun locator'ını bulamadı bir türlü çözemedim?(id, CSS selector, xpath hepsini denedim)
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));

        //WebElement clickMe = driver.findElement(By.xpath("//button[@id='dRDu6']"));

        Actions builder = new Actions(driver);
        builder.doubleClick(doubleClick).contextClick(rightClick).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));

        System.out.println(doubleClickMessage.getText());

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));

        System.out.println(rightClickMessage.getText());

        //WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));

       // System.out.println(rightClickMessage.getText());


        //Close the browser
        driver.quit();


    }

    public static  void demoQATips(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/tool-tips");

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //maximise the window
        driver.manage().window().maximize();

        //Hover over the "Hover me to see" button.
        //Validate that the tooltip is displayed and print its text to the console.
        //Chained Actions: Perform a hover action followed by a click on a different element without breaking the hover.
        WebElement elements = driver.findElement(By.xpath("//div[@class='element-group'][1]"));

        WebElement hoverMe = driver.findElement(By.id("toolTipButton"));

        Actions builder = new Actions(driver);
        builder.click(elements).moveToElement(hoverMe).build().perform();

        if(hoverMe.isDisplayed()) {
            System.out.println(hoverMe.getText());
        }else{
            System.out.println("It is NOT displayed.");
        }



    }

}
