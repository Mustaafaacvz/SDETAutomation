package lesson4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticeFormSubmission {

    public static void main(String[] args) throws InterruptedException {
        // Configure ChromeOptions to run the browser in headless mode (without GUI)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // Initialize the WebDriver with ChromeDriver, open the target URL
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        // Locate the 'Forms' section card on the homepage and click on it
        WebElement form = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][2]"));
        //form.click(); exception hatası verdi bunu kullanamadım ama çalıştığı da olabiliyor
        // Aşağıdakşni kullandık o yüzden
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", form);

        // Locate the 'Practice Form' link and check if it is displayed
        WebElement practice_form = driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]"));
        System.out.println("Practice form is displayed if response is true:" + practice_form.isDisplayed());

        // Click on the 'Practice Form' button to navigate to the form
        WebElement practice_form_button = driver.findElement(By.xpath("//div[@class='element-list collapse show']"));
        practice_form_button.click();

        // Fill out the 'First Name' field
        WebElement first_name = driver.findElement(By.id("firstName"));
        first_name.sendKeys("Mustafa");

        //Fill out the 'Last Name' field
        WebElement last_name = driver.findElement(By.id("lastName"));
        last_name.sendKeys("Ceviz");

        //Fill out the 'Email' field
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("mustafa@test.com");

        // Select the 'Male' gender radio button using JavaScript (since it's a hidden input element)
        WebElement genderMale = driver.findElement(By.id("gender-radio-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", genderMale);


        //Fill out the 'Mobile' field
        WebElement mobile = driver.findElement(By.id("userNumber"));
        mobile.sendKeys("1234567890");

        // Click the 'Submit' button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.submit();

        // Locate the header of the modal that appears after form submission
        //WebElement header = driver.findElement(By.id("example-modal-sizes-title-lg"));
        // Hoca yukarıdaki gibi yazdı ben xpath formatı denedim.

        WebElement header = driver.findElement(By.xpath("//div[@class='modal-title h4']"));

        // Extract and print the text of the modal header
        String headerText = header.getText();
        System.out.println("Header Text is: " + headerText);

        // Close the browser after execution
         driver.quit();


    }

}

