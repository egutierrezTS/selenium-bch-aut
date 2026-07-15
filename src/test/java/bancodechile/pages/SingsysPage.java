package bancodechile.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SingsysPage {

    @FindBy(id = "details-button")
    private WebElement btnDetalles;

    @FindBy(id = "proceed-link")
    private WebElement btnProceder;

    @FindBy(id = "cphMain_LoginForm_UserName")
    private WebElement lblUsername;

    @FindBy(id = "cphMain_LoginForm_Password")
    private WebElement lblPassword;

    @FindBy(xpath = "//td/input[@value='Login']")
    private WebElement btnLogin;

    @FindBy(id = "txtPersonIdNumber_I")
    private WebElement lblPersonIdNumber;

    @FindBy(id = "cphMain_PersonSearch_btnSearchByPersonIdImg")
    private WebElement btnSearchByPersonId;

    @FindBy(id = "cphMain_btnPDF")
    private WebElement btnPDF;

    @FindBy(id = "MainMenu_DXI2_T")
    private WebElement btnMenuConsultas;

    @FindBy(id = "MainMenu_DXI2i1_T")
    private WebElement btnInformeLegal;

    @FindBy(id = "MainMenu_DXI2i1i0_T")
    private WebElement btnVigente;


    private WebDriver driver;

    private static final Duration DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = Duration.ofSeconds(15);


    // Constructor: Este es el puente entre el test y la página
    public SingsysPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Inicializa los @FindBy si los usas
    }

    private WebElement waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(elementToBeClickable(element));
    }

    private WebElement scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        return element;
    }

    protected WebElement click(WebElement element) {
        WebElement webElement = scrollTo(waitFor(element));
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        return wait.ignoring(ElementClickInterceptedException.class).until(webDriver -> {
            webElement.click();
            return webElement;
        });
    }

    public void setUsername(String text){
        waitFor(lblUsername).clear();
        lblUsername.sendKeys(text);
    }

    public WebElement esperaNuevoUsuario(){
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(visibilityOf(lblPersonIdNumber));
    }

    public void setPassword(String text){
        waitFor(lblPassword).clear();
        lblPassword.sendKeys(text);
    }

    public void setPersonIdNumber(String text){
        waitFor(lblPersonIdNumber).clear();
        lblPersonIdNumber.sendKeys(text);
    }

    public void clickBtnAvanzado(){
        click(btnDetalles);
    }

    public void clickBtnProceder(){
        click(btnProceder);
    }

    public void clickBtnLogin(){
        click(btnLogin);
    }

    public void clickBtnSearchByPersonId(){
        click(btnSearchByPersonId);
    }

    public void clickBtnPDF(){
        click(btnPDF);
    }

    public void clickBtnMenuConsultas(){
        click(btnMenuConsultas);
    }

    public void clickBtnInformeLegal(){
        click(btnInformeLegal);
    }

    public void clickBtnVigente(){
        click(btnVigente);
    }
}
