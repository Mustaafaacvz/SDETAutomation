package lesson14homework;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComputerDatabaseTests {

    static WebDriver driver; // Static WebDriver instance for the class

    @BeforeClass
    public static void preparation() {
        driver = new ChromeDriver(); // Initializes the ChromeDriver instance
        driver.get("https://computer-database.gatling.io/computers");
        driver.manage().window().maximize();
    }

    @Test
    public void ClickOn(){

        WebElement add = driver.findElement(By.id("add"));
        add.click();
    }
    @Test
    public void fillIntheForm (){

        WebElement computerName = driver.findElement(By.id("name"));
        computerName.sendKeys("JUnit4 Test Computer");

        WebElement introduced = driver.findElement(By.id("introduced"));
        introduced.sendKeys("2025-01-01");

        WebElement discontinued = driver.findElement(By.id("discontinued"));
        discontinued.sendKeys("2026-01-01");

        WebElement company = driver.findElement(By.id("company"));

        Select chooseCompany = new Select(company);
        chooseCompany.selectByValue("1");

    }

    @Test
    public void createComputerButton (){

        WebElement button = driver.findElement(By.xpath("//input[@class='btn primary']"));
        button.click();
    }

    @Test
    public void successMessage () {

        WebElement doneMessage = driver.findElement(By.xpath("//div[@class='alert-message warning']"));
        String actualmessage = doneMessage.getText();
        String expectedmessage = "Done ! Computer JUnit4 Test Computer has been created";

        Assert.assertEquals(expectedmessage,actualmessage);

    }

    @AfterClass
    public static void closeTests() {
        driver.quit(); // Closes the browser and ends the WebDriver session
    }

}
