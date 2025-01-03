package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DependentDropdownSelection {

    public static void main(String[] args) throws InterruptedException {

        // Call the method to select a wrong answers from a dropdown
        loseTheGame();

        // Call the method to select correct answers from a dropdown
        winTheGame();
    }
        public static void loseTheGame() {

            //Navigate to the page.
            WebDriver driver = new ChromeDriver();
            driver.get("https://qbek.github.io/selenium-exercises/en/selects.html");

            // adding implicit wait of 10 secs
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Select a wrong answer from the dropdown.
            WebElement yourAnswer1 = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[1]"));
            yourAnswer1.sendKeys(Keys.ENTER);

            Select dropAnswer1 = new Select(yourAnswer1);
            dropAnswer1.selectByValue("3");

            //Confirm the answer.
            WebElement confirmButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
            confirmButton.click();

            //Verify if the correct banner indicating failure is displayed.
            //Print a failure message for validation.
            WebElement failure = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));

            boolean verify = failure.isDisplayed();

            System.out.println(failure.getText() + " : " + verify );

            driver.quit();

        }

        public static void winTheGame()throws InterruptedException {

            //Navigate to the page.
            WebDriver driver = new ChromeDriver();
            driver.get("https://qbek.github.io/selenium-exercises/en/selects.html");

            // adding implicit wait of 10 secs
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Correctly answer all the questions using the dropdown.
            WebElement yourAnswer1 = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[1]"));
            yourAnswer1.sendKeys(Keys.ENTER);

            Select dropAnswer1 = new Select(yourAnswer1);
            dropAnswer1.selectByValue("4");

            //Confirm the answer.
            WebElement confirmButton1 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
            confirmButton1.click();

            WebElement yourAnswer2 = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[2]"));
            yourAnswer2.sendKeys(Keys.ENTER);

            Select dropAnswer2 = new Select(yourAnswer2);
            dropAnswer2.selectByValue("words-7");

            //Confirm the answer.
            WebElement confirmButton2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
            confirmButton2.click();


            WebElement yourAnswer3 = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[3]"));
            yourAnswer3.sendKeys(Keys.ENTER);

            Select dropAnswer3 = new Select(yourAnswer3);
            dropAnswer3.selectByVisibleText("Carrot");

            //Confirm the answer.
            WebElement confirmButton3 = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
            confirmButton3.click();


            //Verify if the correct banner indicating success is displayed.
            //Print a success message for validation.
            WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));

            boolean check = success.isDisplayed();

            System.out.println(success.getText() + " : " + check);

            driver.quit();

        }




}
