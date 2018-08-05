package wspolne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UstawDriverChrome {

    public WebDriver ustawDriver(WebDriver driver) {

        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "./src/test/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;

    }
}