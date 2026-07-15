package bancodechile.tests;

import bancodechile.base.BaseTest;
import bancodechile.pages.SingsysPage;
import org.junit.jupiter.api.Test;

public class Descarga_InformeLegalVigentePDF extends BaseTest{
    @Test
    public void testDescargaPDF() throws Throwable{
        Login_Singsys login = new Login_Singsys();
        login.testLoginCorrecto();

        SingsysPage singsysPage = new SingsysPage(driver);

    }
}
