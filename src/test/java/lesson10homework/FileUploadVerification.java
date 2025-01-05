package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadVerification {

    public static void main(String[] args) {

        //Navigate to page
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        // adding implicit wait of 10 secs
        // Create an explicit wait instance for synchronization
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the file upload input field is present
        WebElement chooseFile = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fileinput")));

        chooseFile.sendKeys("C:\\Users\\muceviz\\IdeaProjects\\SDETAutomation\\src\\test\\java\\lesson10homework\\testfile.txt");

        // Wait until the upload button is clickable and then click it
        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("upload")));
        uploadButton.click();

        // Wait until the upload confirmation message is visible
        WebElement fileUploadTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='explanation']")));

        // Print a success message to the console
        if (fileUploadTest.isDisplayed()) {
            System.out.println("File uploaded successfully: " + fileUploadTest.getText());
        } else {
            System.out.println("File upload failed.");
        }

        //Close the browser
        driver.quit();
    }

}
