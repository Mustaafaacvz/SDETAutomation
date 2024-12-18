package lesson2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class HomeworkSeleniumBrowserNavigation {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");


        // 1. Pencere boyutu ayarlama
        System.out.println("Browser size: " + driver.manage().window().getSize());
        driver.manage().window().setSize(new Dimension(300, 500));
        System.out.println("New size: "+ driver.manage().window().getSize());


        // 2.Pencere pozisyon ayarlama
        System.out.println("Current Position"+ driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(100 , 400));
        System.out.println("Updated Postion"+ driver.manage().window().getPosition());

        // 3. İlk URL'yi açma
        driver.get("https://www.orioninc.com/");
        String firstPageTitle = driver.getTitle();
        System.out.println("First Page Title: "+ firstPageTitle);


        // 4. Sayfayı başka URL'ye yönlendirme
        driver.navigate().to("https://www.amazon.com/");


        // 5. Geri navigasyon yapma ve URL'yi yazdırma
        driver.navigate().back();
        System.out.println("Current URL: "+ driver.getCurrentUrl());

        // 6. İleri navigasyon yapma
        driver.navigate().forward();


        // 7. Yeni sekme açma, google sayfasını yükleme ve kaynak kodu yazdırma
        ((ChromeDriver) driver).executeScript("window.open('https://www.google.com', '_blank');");

        System.out.println("Google Page Sourcecode" + driver.getPageSource());


        // 8. İlk sekmeye geri dön ve URL'yi yazdır
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        System.out.println("Firt screen URL:"+ driver.getCurrentUrl());

        // Ben yukarıdaki şekilde sekmelere geçiş yaptım hoca şu şekilde yapmış
        //Set<String> windowHandles = driver.getWindowHandles();
        // String lastTab = windowHandles.toArray()[windowHandles.size() - 1].toString();
        //driver.switchTo().window(lastTab);

        // String firstTab = windowHandles.toArray()[0].toString();
        //driver.switchTo().window(firstTab);

        // 9. Son sekmeye geç ve sayfayı yenile
        driver.switchTo().window(tabs.get(1));
        driver.navigate().refresh();

        // 10. Tüm sekmeleri kapat
        driver.quit();
        System.out.println("All screen are closed.");
}
}