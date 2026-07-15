package bancodechile.tests;

import bancodechile.base.BaseTest;
import bancodechile.pages.SingsysPage;
import bancodechile.utils.AutomationUtils;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Login_Singsys extends BaseTest {


    @Test
    public void testLoginCorrecto() throws Throwable{

        String URL = System.getenv("BASE_URL");
        String user = System.getenv("SING_USERNAME");
        String pass = System.getenv("SING_PASSWORD");
        driver.get(URL);

        SingsysPage singsysPage = new SingsysPage(driver);
        singsysPage.clickBtnAvanzado();
        singsysPage.clickBtnProceder();
        singsysPage.setUsername(user);
        singsysPage.setPassword(pass);
        singsysPage.clickBtnLogin();

        List<String> ruts = AutomationUtils.leerColumnaExcel(0);
        for (String rut : ruts) {
            singsysPage.setPersonIdNumber(rut);
            singsysPage.clickBtnSearchByPersonId();
            singsysPage.clickBtnPDF();
            AutomationUtils.pausa(2000);
            driver.get(URL);
            //AutomationUtils.pausa(4000);
            singsysPage.esperaNuevoUsuario();
        }
    }
}