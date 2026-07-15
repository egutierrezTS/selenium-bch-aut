package bancodechile.tests;

import bancodechile.base.BaseTest;
import bancodechile.pages.SingsysPage;
import bancodechile.utils.AutomationUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;

public class Login_Singsys extends BaseTest {


    @Test
    public void testLoginCorrecto() throws Throwable{
        driver.get("https://152.139.146.19/signsys/Grantors/LegalReports/Current.aspx");

        SingsysPage singsysPage = new SingsysPage(driver);

        String user = "ngomez";
        String pass = "Banco001";

        singsysPage.clickBtnAvanzado();
        singsysPage.clickBtnProceder();
        singsysPage.setUsername(user);
        singsysPage.setPassword(pass);
        singsysPage.clickBtnLogin();
        String pestanaPrincipal = driver.getWindowHandle();
        List<String> ruts = AutomationUtils.leerColumnaExcel(0);
        for (String rut : ruts) {

            singsysPage.setPersonIdNumber(rut);
            singsysPage.clickBtnSearchByPersonId();
            singsysPage.clickBtnPDF();
            AutomationUtils.pausa(2000);
//            singsysPage.clickBtnMenuConsultas();
//            singsysPage.clickBtnInformeLegal();
//            singsysPage.clickBtnVigente();
            driver.get("https://152.139.146.19/signsys/Grantors/LegalReports/Current.aspx");

            AutomationUtils.pausa(4000);
            singsysPage.esperaNuevoUsuario();
        }
    }
}