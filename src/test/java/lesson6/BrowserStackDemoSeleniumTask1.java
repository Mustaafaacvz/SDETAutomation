package lesson6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

public class BrowserStackDemoSeleniumTask1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");


        //WebElement productcounts = driver.findElement(By.xpath("//*[@class='shelf-item']"));
        //Bu xpath yazımı.

        //Count the elements and print the count.
        List<WebElement> productcount = driver.findElements(By.cssSelector(".shelf-item"));

        System.out.println("Total product counts: " + productcount.size());

        //Locate the text "25 Product(s) found." and validate its visibility with isDisplayed().
        WebElement text = driver.findElement(By.xpath("//div[@class='shelf-container-header']/small"));

        boolean validate = text.isDisplayed();

        System.out.println("25 Product(s) found. is displayed: " + validate);

        //Count and print the total number of iPhones.
        List<WebElement> iPhone = driver.findElements(By.xpath("//div/p[contains(text(),'iPhone')]"));
        System.out.println("Count of iPhone models: " + iPhone.size());

        //Extract and print the name of each iPhone model.
       for (WebElement webElement : iPhone){
           String name = webElement.getText();

           System.out.println("iPhone model name: "+ name);
       }

       //Count and print the total number of  all "Add to cart" buttons.
       List<WebElement> buyButton = driver.findElements(By.cssSelector("div.shelf-item__buy-btn"));
                                                   //By.xpath("//div[contains(text(),'Add to cart')]")  -->xpath form

       System.out.println("Buy button counts: " + buyButton.size());

       Thread.sleep(2000);

       //Click the first button you find.
       WebElement addtocart = driver.findElement(By.xpath("//div[contains(text(),'Add to cart')]"));
       addtocart.click();

       //Use CSS Selectors to locate the Sign In button.
       Thread.sleep(3000);
       WebElement signin = driver.findElement(By.cssSelector("a#signin"));
       signin.click();

       //Enter the username and password credentials
       Thread.sleep(5000);
       WebElement username = driver.findElement(By.cssSelector("input#react-select-2-input"));
       username.sendKeys("demouser");
       username.sendKeys(Keys.ENTER);

       Thread.sleep(5000);
       WebElement password = driver.findElement(By.cssSelector("input#react-select-3-input"));
       password.sendKeys("testingisfun99");
       password.sendKeys(Keys.ENTER);

       //Click the Login button.
       Thread.sleep(5000);
       WebElement login = driver.findElement(By.cssSelector("button#login-btn"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", login);

        //Validate the login success by checking for the Logout button.
        Thread.sleep(3000);
        WebElement logout = driver.findElement(By.cssSelector("a#logout"));

        boolean validates = logout.isDisplayed();
        System.out.println("Logout button is displayed.  " + validates);

        //div[id='1'] p[class='shelf-item__title']--> this is CSS selector forms.
        WebElement firstproductname = driver.findElement(By.xpath("(//div/p[contains(text(),'iPhone 12')])[1]"));
        System.out.println("The added phone model is " + firstproductname.getText());

        //Click the "Add to cart" button for the first product.
        WebElement firstproduct = driver.findElement(By.cssSelector("div.shelf-item__buy-btn"));
        firstproduct.click();

        Thread.sleep(3000);
        WebElement cartClose = driver.findElement(By.cssSelector("div.float-cart__close-btn"));
        cartClose.click();

        //Use CSS Selectors to locate the cart icon and open it.
        Thread.sleep(3000);
        WebElement cartIcon = driver.findElement(By.cssSelector("span.bag.bag--float-cart-closed"));
        cartIcon.click();

        //Validate that the product name in the cart matches the selected product.
        Thread.sleep(3000);
        WebElement addedProduct = driver.findElement(By.xpath("(//div/p[contains(text(),'iPhone 12')])[5]"));
        String name = addedProduct.getText();
        String expectedname = firstproductname.getText();

        if (name.equals(expectedname)){
            System.out.println("The product name in the cart matches the selected product.");
        }
        else {
            System.out.println("The product name in the cart doesn't match the selected product.");
        }

        // Logout is already defined above so I just click it.
        //Use CSS Selectors to locate and click the Logout button.
        logout.click();

        Thread.sleep(3000);
        //Validate that the Sign In button is displayed, confirming successful logout.
        WebElement signIn = driver.findElement(By.cssSelector("a#signin"));
        boolean signInValidate = signIn.isDisplayed();
        System.out.println("Successfully logged out " + signInValidate);

        Thread.sleep(3000);
        driver.quit();


    }
}
