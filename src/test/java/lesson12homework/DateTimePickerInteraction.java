package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class DateTimePickerInteraction {

    public static void main(String[] args)  {

        currentDAY();
        firstOfJune();
        fifthOfNovember();

    }

        public static void currentDAY() {

            // Initiate the Webdriver
            WebDriver driver = new ChromeDriver();

            //Navigate to the page.
            driver.get("https://jqueryui.com/datepicker/");

            //Locate the date picker input field and click it to open the calendar widget.
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

            driver.switchTo().frame(iframe);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
            datePicker.click();

            //Select the current date programmatically.
            WebElement currentDay = driver.findElement(By.xpath("(//td/a[@aria-current='false'])[14]"));
            currentDay.click();

            //Validate the selected date is displayed correctly in the input field.
            String selectedDate = datePicker.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);

            // Close the browser
            driver.quit();

        }

        public static void firstOfJune()  {

            // Initiate the Webdriver
            WebDriver driver = new ChromeDriver();

            //Navigate to the page.
            driver.get("https://jqueryui.com/datepicker/");

            //Locate the date picker input field and click it to open the calendar widget.
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

            driver.switchTo().frame(iframe);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
            datePicker.click();

            //Select the date 1st June 2025 programmatically.
            for(int i =0; i < 5; i++){
                driver.findElement(By.xpath(" //span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }

            WebElement day = driver.findElement(By.xpath("(//td/a[@aria-current='false'])[1]"));
            day.click();

            String selectedDate = datePicker.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);

            // Close the browser
            driver.quit();

        }

        public static void fifthOfNovember(){

            // Initiate the Webdriver
            WebDriver driver = new ChromeDriver();

            //Navigate to the page.
            driver.get("https://jqueryui.com/datepicker/");

            //Locate the date picker input field and click it to open the calendar widget.
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

            driver.switchTo().frame(iframe);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
            datePicker.click();

            //Select the date 5th November 2024 programmatically.
            for(int i =0; i < 2; i++){
                driver.findElement(By.xpath(" //span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            }

            WebElement day = driver.findElement(By.xpath("(//td/a[@aria-current='false'])[5]"));
            day.click();

            //Validate that the selected date is displayed correctly in the input field.
            String selectedDate = datePicker.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);

            // Close the browser
            driver.quit();

        }



    }


