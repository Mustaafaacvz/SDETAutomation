package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorAlerts {

    public static void main(String[] args) {

        jsAlert();
        jsConfirm();
        jsPrompt();
    }

    public static void jsAlert(){

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        //Navigate to the page.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Maximize the browser window
        driver.manage().window().maximize();


        WebElement JSalert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        JSalert.click();

        // Switch to the alert and retrieve its text
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText); // Print the alert text to the console

        // Accept the JS alert
        driver.switchTo().alert().accept();

        driver.quit();

    }

    public static void jsConfirm(){

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        //Navigate to the page.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Maximize the browser window
        driver.manage().window().maximize();

        WebElement JSconfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        JSconfirm.click();

        // Switch to the alert and retrieve its text
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText); // Print the alert text to the console

        // Accept the JS confirm
        driver.switchTo().alert().accept();


        driver.quit();
    }

    public static void jsPrompt(){

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        //Navigate to the page.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Maximize the browser window
        driver.manage().window().maximize();


        WebElement JSprompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSprompt.click();

        // Send text input to the prompt box
        driver.switchTo().alert().sendKeys("Hello World!");

        // Switch to the alert and retrieve its text
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText); // Print the alert text to the console

        // Accept the JS prompt
        driver.switchTo().alert().accept();

        WebElement result = driver.findElement(By.id("result"));
        String value = result.getText();
        String expectedResult = "Hello World!";

        if(value.contains(expectedResult)){
            System.out.println("Result: " + value);
        }else
            System.out.println("Result and input text are not matching!");

        driver.quit();



    }
}
