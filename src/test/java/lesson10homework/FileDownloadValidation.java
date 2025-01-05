package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class FileDownloadValidation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();


        try {
            // Open URL
            driver.get("https://people.sc.fsu.edu/~jburkardt/data/csv/csv.html");

            //Locate and click on a sample CSV file download link (e.g., airtravel.csv).
            WebElement sampleFiles = driver.findElement(By.xpath("//a[@href='airtravel.csv']"));
            sampleFiles.click();

            // Print confirmation message to console
            System.out.println("File download has been triggered successfully.");

        } catch (Exception e) {
            // Print error message if something goes wrong
            System.out.println("An error occurred during file download: " + e.getMessage());
        } finally {
            // Close the driver after the actions are complete
            Thread.sleep(3000);
            driver.quit();
        }

        //Verify the file's presence in your default download directory.
        String downloadPath = "C:\\Users\\muceviz\\Downloads";
        String fileName = "airtravel";
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();

            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                    System.out.println(fileName + " is present in my default download directory.");
                    break;
                }
            }
        }

    }



