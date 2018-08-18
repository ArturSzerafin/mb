package logowanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import wspolne.UstawDriver;

import java.util.ArrayList;
import java.util.List;

public class LogowanieTest {

    private WebDriver driver;
    private UstawDriver ustawDriver = new UstawDriver();
    private LogowaniePage LogowaniePage;

    @BeforeTest
    public void WczytajStrone() {
        this.driver = ustawDriver.ustawDriver(this.driver);
        LogowaniePage = new LogowaniePage(this.driver);

        //LogowaniePage.setDriver(this.driver);
        LogowaniePage.wywolajUrl();

    }

    @Test(priority = 1)
    public void panelBezpieczenstwo(){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement sekcjaBezpieczenstwa =wait.until(ExpectedConditions.visibilityOf(LogowaniePage.getPanelBezpieczenstwo()));
        List<WebElement> calaLista = sekcjaBezpieczenstwa.findElements(By.tagName("li"));
        Assert.assertEquals(calaLista.size(), 20);

        List<WebElement> listaBezpieczenstwa = LogowaniePage.getListaUwag().findElements(By.tagName("li"));
        Assert.assertEquals(listaBezpieczenstwa.size(), 8);

        //porównanie listy Bezpieczenstwa

        ArrayList <String> listaUwag = new ArrayList <String>();
        listaUwag.add("1. mBank nie prosi w serwisie transakcyjnym o podawanie systemu operacyjnego telefonu komórkowego");
        listaUwag.add("2. Uwaga na zagrożenia związane z podmianą rachunku");
        listaUwag.add("3. Przed potwierdzeniem operacji przeczytaj uważnie SMS-a z kodem, aby upewnić się, że dotyczy on właściwej operacji");
        listaUwag.add("4. Konsultant mBanku nie pyta o hasło podczas rozmowy przychodzącej czy wychodzącej");
        listaUwag.add("5. mBank nie każe podawać haseł jednorazowych podczas logowania do serwisu transakcyjnego");
        listaUwag.add("6. Zawsze sprawdzaj certyfikat SSL i adres URL");
        listaUwag.add("7. mBank nigdy nie prosi o instalację certyfikatów na telefon komórkowy");
        listaUwag.add("8. Uwaga na zagrożenia związane z routerami");

        List<String> listaDodatkowejPomocy1 = new ArrayList<String>();

        for (WebElement e : listaBezpieczenstwa) {

            listaDodatkowejPomocy1.add(e.getText());

        }
        Assert.assertEquals(listaDodatkowejPomocy1, listaUwag);


    }

    @Test(priority = 2)
    public void PopupPoZalogowaniuTest() {

        LogowaniePage.zaloguj();

//znajdujemy się na dodatkowym oknie wyświetlanym po zalogowaniu
        WebElement popUpPoZalogowaniu = driver.findElement(By.id("welcomeScreen"));
//Sprawdzenie Tytułu
        String tytulPop = popUpPoZalogowaniu.findElement(By.xpath("//div/header[1]/h1")).getText();
        Assert.assertEquals("Witamy w wersji demonstracyjnej serwisu transakcyjnego mBanku.", tytulPop);
//sprawdzenie Podtytułu
        String h2Pop = popUpPoZalogowaniu.findElement(By.xpath("//div/header[1]/h2")).getText();
        Assert.assertEquals("Zachęcamy do skorzystania z dodatkowej pomocy w postaci:", h2Pop);
//Sprawdzenie tekstu w poszczególnych elementach listy Pomocy
        List<WebElement> listaDodatkowejPomocy = popUpPoZalogowaniu.findElements(By.className("text"));
        List<String> listaDodatkowejPomocy2 = new ArrayList<String>();
        ;
        for (WebElement e : listaDodatkowejPomocy) {

            listaDodatkowejPomocy2.add(e.getText());

        }

        ArrayList<String> listaDodatkowejPomocyActual = new ArrayList<String>();
        listaDodatkowejPomocyActual.add("w których krok po kroku sprawdzisz, jak dokonywać najważniejszych operacji w serwisie.");
        listaDodatkowejPomocyActual.add("z których dowiesz się więcej na temat wszystkich możliwości serwisu.");
        listaDodatkowejPomocyActual.add("jesli chcesz się skonsultować przez internet z pracownikiem mBanku.");

        Assert.assertEquals(listaDodatkowejPomocyActual, listaDodatkowejPomocy2);

        popUpPoZalogowaniu.findElement(By.className("close-button")).click();


    }



     @AfterClass
      public void zakoncz(){
         driver.quit();
      }


}
