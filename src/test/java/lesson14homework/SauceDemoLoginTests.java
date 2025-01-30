package lesson14homework;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.time.Duration;

import static lesson14homework.ComputerDatabaseTests.driver;

public class SauceDemoLoginTests {

    static WebDriver driver; // Static WebDriver instance for the class

    @BeforeClass
    public static void preparation() {
        driver = new ChromeDriver(); // Initializes the ChromeDriver instance
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Before
    public void logIncredentials ()  {

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        try {
            Thread.sleep(3000); // Pauses execution for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Throws a runtime exception in case of interruption
        }
        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.click();


    }
/*
  Login testi daha önce gerçekleştiği için username hatası alıyordum yukarıdaki şekilde yaptım
    @Test
    public void LogInButton () {

        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.click();

    }

 */

    @Test
    public void logInsuccessful () {

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement products = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title']")));

        String title = products.getText();
        String expectedtitle = "Products";

        Assert.assertEquals(expectedtitle, title);
        System.out.println("Products are listed:"+ title);
    }

    @After
    public void LogOut (){

        WebElement logOut = driver.findElement(By.id("react-burger-menu-btn"));
        logOut.click();

        try {
            Thread.sleep(3000); // Pauses execution for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Throws a runtime exception in case of interruption
        }

        WebElement logOutclick = driver.findElement(By.id("logout_sidebar_link"));
        logOutclick.click();

        WebElement logInButton = driver.findElement(By.id("login-button"));
        boolean validate = logInButton.isDisplayed();

        System.out.println("Loged out is succesfully: " + validate);
    }

    @AfterClass
    public static void closeTests() {
         driver.quit(); // Closes the browser and ends the WebDriver session
    }


}
