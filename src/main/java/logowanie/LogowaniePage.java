package logowanie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogowaniePage {

    private final string url = "http://nowedemo.mbank.pl/login.html";

    @FindBy(id = "userID")
    private WebElement userId;

    @FindBy(id = "pass")
    private WebElement haslo;

    @FindBy(id = "log-in-panel-footer-security")
    private WebElement panelBezpieczenstwo;

    @FindBy(id = "help")
    private WebElement pomoc;

    @FindBy(xpath = "//*[@id=\"log-in-panel-footer-security\"]/ul")
    private WebElement listaUwag;

    @FindBy(id = "log-in-panel-footer-contact")
    private WebElement panelKontakt;

    private WebDriver driver;

    public LogowaniePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public string getUrl() {
        return url;
    }



    public WebElement getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId.sendKeys(userId);
    }

    public WebElement getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo.sendKeys(haslo);
    }

    public WebElement getPanelBezpieczenstwo() {
        return panelBezpieczenstwo;
    }

    public WebElement getPomoc() {
        return pomoc;
    }


    public WebElement getListaUwag() {
        return listaUwag;
    }



    public WebElement getPanelKontakt() {
        return panelKontakt;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}