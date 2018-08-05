package logowanie;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import wspolne.UstawDriverChrome;
import logowanie.LogowaniePage;

public class LogowanieTest {

    private WebDriver driver;
    private UstawDriverChrome ustawDriver = new UstawDriverChrome();
    private LogowaniePage LogowaniePage = new LogowaniePage(this.driver);


    @BeforeTest
    public void WczytajStrone(){
      driver =  ustawDriver.ustawDriver(this.driver);
       LogowaniePage.setDriver(this.driver);
        LogowaniePage.wywolajUrl();
        LogowaniePage.zaloguj();

    }

    @Test
    public void zaloguj(){

    }






}
