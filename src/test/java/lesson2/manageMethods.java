package lesson2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class manageMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

       // driver.get("https://www.google.com/");
        driver.get("https://demoqa.com");
        //Thread.sleep(5000);
        //driver.manage().window().fullscreen();
        //Thread.sleep(5000);
        //driver.manage().window().minimize();

        System.out.println("Browser size: " + driver.manage().window().getSize());
        driver.manage().window().setSize(new Dimension(800, 800));
        System.out.println("New size: "+ driver.manage().window().getSize());

        System.out.println("Current Position"+ driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(200 , 200));
        System.out.println("Updated Postion"+ driver.manage().window().getPosition());
    }


    }

