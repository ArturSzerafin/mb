package wspolne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UstawDriver {

    private String nazwaDrivera = "chrome";

    public WebDriver ustawDriver(WebDriver driver) {

        switch (nazwaDrivera) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "./src/test/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                return driver;

            }
            case "IE": {
                System.setProperty("webdriver.ie.driver", "./src/test/drivers/IEDriverServer.exe");
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                driver = new InternetExplorerDriver();
                return driver;
            }
            case "FireFox": {
                System.setProperty("webdriver.gecko.driver", "./src/test/drivers/geckodriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver();

                return driver;
            }
        }
        return driver;
    }
}