package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkOrangeHRMSeleniumTask1 {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
        login_button.submit();

        Thread.sleep(3000);

        WebElement dasboardTitle = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        String actualTitle = dasboardTitle.getText();
        String expectedTitle = "Dashboard";


        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed: Dashboard title is correct.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedTitle + "' but got '" + actualTitle + "'.");
        }


        Thread.sleep(2000);
        driver.quit();

    }
}
