package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DateTimePickers {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // URL launch for accessing calendar
        driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");

        // identify element to get calendar
        WebElement calendar2 = driver
                .findElement(By.xpath("//*[@id='datetimepicker2']"));
        calendar2.click();

        // selecting month June
        WebElement month = driver
                .findElement(By.xpath("(//select[@class='flatpickr-monthDropdown-months'])[2]"));
        Select select = new Select(month);
        select.selectByVisibleText("June");
        //select.selectByValue("5");
        //select.selectByIndex(5);


        // getting selected month
        String selectedMonth = select.getFirstSelectedOption().getText();

        // selecting year 2023
        WebElement year = driver.findElement(By.xpath("(//input[@class='numInput cur-year'])[2]"));

        // removing existing year then entering
        year.clear();
        year.sendKeys("2023");

        // selecting day 4
        WebElement day = driver.findElement(By.xpath("//span[contains(@aria-label,'"+selectedMonth+" 4')]"));
        day.click();

        // selecting AM time
        WebElement time = driver.findElement(By.xpath("/html/body/div[3]/div[3]/span[2]"));
        if (time.getText().equalsIgnoreCase("PM")){
           // time.click();

            // Use JavaScript to click the button because a direct click may cause an interception error
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", time);

        }

        // selecting hour
        WebElement hour = driver
                .findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/input"));

        // removing existing hour then entering
        hour.clear();
        hour.sendKeys("9");

        // selecting minutes
        WebElement minutes = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/input"));

        // removing existing minutes then entering
        minutes.clear();
        minutes.sendKeys("5");

        // reflecting both date and time
        calendar2.click();

        // get date and time selected
        String v = calendar2.getDomProperty("value");
        System.out.println("Date and time selected by Date Time Picker: " + v);

        // check date and time selected
        if (v.equalsIgnoreCase("2023-06-04 09:05")){
            System.out.print("Date and Time selected successfully");
        } else {
            System.out.print("Date and Time selected unsuccessfully");
        }
        // close browser
        driver.quit();
    }
}
