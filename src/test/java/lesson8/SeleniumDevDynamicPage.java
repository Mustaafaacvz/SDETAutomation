package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class SeleniumDevDynamicPage {

    public static void main(String[] args)  {

        //Configure Microsoft Edge Driver.
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        //Use Implicit Wait to find the "Add a box!" and "Reveal a new input" buttons.
        //Print confirmation to the console with isDisplayed() method.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement adder = driver.findElement(By.cssSelector("#adder"));

        WebElement reveal = driver.findElement(By.cssSelector("#reveal"));

        System.out.println("Add a box button is displayed: " + adder.isDisplayed() );
        System.out.println("Reveal a new input is displayed: " + reveal.isDisplayed());

        //Click the "Add a box!" button.
        //Use Explicit Wait to ensure a dynamically generated box (it has 'div' tag ) becomes visible.
        adder.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newBoxAdded = driver.findElement(By.xpath("//div[@id='box0']"));
        System.out.println("The new box is added dynamically: " + newBoxAdded.isDisplayed());

        //Click the "Reveal a new input" button.
        //Use Explicit Wait to wait for the input field (id:'revealed') to become visible.
        reveal.click();
        WebElement revealed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
        System.out.println("The input field is displayed: " + revealed.isDisplayed());

        //Interact with the revealed input field by sending the text "Selenium Wait Test".
        revealed.sendKeys("Selenium Wait Test");

        //Use findElements to count the initial boxes before adding more. The total after adding five boxes should be the initial count + 5.
        List<WebElement> boxCounts = driver.findElements(By.className("redbox"));
        int initialBoxCount = boxCounts.size();
        System.out.println("Initial red box count is " + initialBoxCount);

        //Click the "Add a box!" button five times.
        int boxesToAdd =5;
        for(int i =0; i < boxesToAdd; i++){
            adder.click();
        }

        //Use Fluent Wait to wait until all dynamically generated boxes appear.
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver1-> driver.findElements(By.xpath("//div[@class='redbox']")).size() == initialBoxCount + boxesToAdd);


        //Print the total count to the console. It should be 6.
        List<WebElement> newBoxCounts = driver.findElements(By.className("redbox"));

                System.out.println("The updated red box count is "+ newBoxCounts.size());


                //Ensure the browser closes after the script completes.
                driver.quit();

    }
}

