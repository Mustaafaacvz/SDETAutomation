package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicCheckboxInteraction {

    public static void main(String[] args)  {

        //Navigate to the page.
        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/samplesiteforselenium");

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Locate the checkboxes under the "Checkbox :" section.
        //Verify the initial state (checked or unchecked) of each checkbox and print the states to the console.
        WebElement checkbox1 = driver.findElement(By.className("Automation"));

        boolean checkbox1isNotSelected = checkbox1.isSelected();
        System.out.println("Checking whether checkbox 1 is selected: " + checkbox1isNotSelected);

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@class='Performance']"));

        boolean checkbox2isNotSelected = checkbox2.isSelected();
        System.out.println("Checking whether checkbox 2 is selected: " + checkbox2isNotSelected);


        //Checked first check box to see the following "if" condition is working.
        checkbox1.click();
        //checkbox2.click();

        //Check any unchecked checkboxes and uncheck any checked ones.
        if (!checkbox1.isSelected() ) {
            checkbox1.click();// Click the checkbox if not already selected

            System.out.println("Non selected checkboxes were checked.");
        } else{
            checkbox1.click();

            System.out.println("The selected checkboxes were unchecked again");
        }

        if (!checkbox2.isSelected() ) {
            checkbox2.click();// Click the checkbox if not already selected
            System.out.println("Non selected checkboxes were checked.");
        } else{
            checkbox2.click();
            System.out.println("The selected checkboxes were unchecked again.");
        }


        //Print the final states of all checkboxes to the console.
        boolean checkbox1isSelected = checkbox1.isSelected();
        System.out.println("Checking if checkbox 1 is selected or not: " + checkbox1isSelected);

        boolean checkbox2isSelected = checkbox2.isSelected();
        System.out.println("Checking if checkbox 2 is selected or not: " + checkbox2isSelected);

        //Close the browser
        driver.quit();

    }
}
