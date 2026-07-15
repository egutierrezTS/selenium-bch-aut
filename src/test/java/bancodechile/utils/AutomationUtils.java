package bancodechile.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;

public class AutomationUtils {

    // --- GRUPO 1: Gestión de Archivos (Excel) ---
    private static final DataFormatter formatter = new DataFormatter();
    static String ruta = "C:\\Users\\TS\\Documents\\base_automatizacion\\src\\test\\resources\\signsys_13072026 - copia.xlsx";
    public static List<String> leerColumnaExcel(int columna) {
        List<String> datos = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(ruta);
             Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null && row.getCell(columna) != null) {
                    String valorCelda = formatter.formatCellValue(row.getCell(columna)).trim();
                    if (!valorCelda.isEmpty()) {
                        datos.add(valorCelda);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo Excel: " + e.getMessage());
        }
        return datos;
    }

    // --- GRUPO 2: Gestión de Credenciales ---
    // Ideal para no tener hardcodeado usuario/pass en el código
//    public static String getProperty(String key) {
//        Properties prop = new Properties();
//        try (InputStream input = AutomationUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
//            prop.load(input);
//            return prop.getProperty(key);
//        } catch (Exception ex) {
//            return System.getenv(key); // Si no está en properties, intenta leer de variables de entorno (Jenkins/Bash)
//        }
//    }

    // --- GRUPO 3: Utilidades de Tiempo/Espera (Ejemplos futuros) ---
    public static void pausa(long milisegundos) {
        try { Thread.sleep(milisegundos); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
