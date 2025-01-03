package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ConditionalRadioButtonInteraction {

    public static void main(String[] args)  {

        //Navigate to the page.
        WebDriver driver = new ChromeDriver();
        driver.get("https://qbek.github.io/selenium-exercises/en/radio_buttons.html");

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Locate the radio buttons available under the "Polish radio stations" section.
        List<WebElement> radioButtons = driver.findElements(By.className("form-check"));

        // Print the total number of radio buttons found
        System.out.println(radioButtons.size());

        WebElement RadioZET = driver.findElement(By.xpath("//input[@value='radiozet']"));
        RadioZET.click();

        //Select "Radio ZET" on the radio buttons, validating after selection that the correct radio button is selected.
        if (!RadioZET.isSelected()) {
            System.out.println("Radio ZET button is not selected.");
        } else {
            System.out.println("Radio ZET button is selected.");
        }


        WebElement webPageButton = driver.findElement(By.xpath("//a[@href='https://www.radiozet.pl']"));
        webPageButton.click();

        //Verify that clicking the "Web page" button redirects to the correct page associated with the selected radio station.
        System.out.println("Current URL: "+ driver.getCurrentUrl());

        String redirectedURL = driver.getCurrentUrl();
        String URL = "https://www.radiozet.pl/";

        if (redirectedURL.equals(URL)){
            System.out.println("The redirected URL is correct.");
        }else {
            System.out.println("The redirected URL is NOT correct.");
        }

        // //Close the browser
        driver.quit();

    }
}
