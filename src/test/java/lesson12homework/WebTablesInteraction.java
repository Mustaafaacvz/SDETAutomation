package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebTablesInteraction {

    public static void main(String[] args) {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        //Navigate to the page.
        driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");

        //maximize the window
        driver.manage().window().maximize();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Sort the table from the last letter to the first in the "Name" column.
        WebElement nameInvertsorting = driver.findElement(By.xpath("//th[@aria-label='Name: Activate to invert sorting']"));
        nameInvertsorting.click();

        //Extract data from the first 5 rows of the sorted "Name" column and print it to the console.
        WebElement table1 = driver.findElement(By.id("example"));

        List<WebElement> name =table1.findElements(By.xpath("//td[@class='sorting_1']"));

        for (int i = 0; i < Math.min(5, name.size()); i++) {
            System.out.println((i + 1) + ". " + name.get(i).getText());
        }

        WebElement search = driver.findElement(By.id("dt-search-0"));
        search.sendKeys("Software Engineer");

        WebElement softwareEngineer = driver.findElement(By.xpath("//td[contains(text(),'Software Engineer')]"));
        String value = softwareEngineer.getText();
        String position = "Software Engineer";

        if (value.equals(position)) {

            System.out.println("The people are shown in table who are in Software Engineer position");
        } else

            System.out.println("Please search again!");

        // Close the browser
         driver.quit();

    }
}
