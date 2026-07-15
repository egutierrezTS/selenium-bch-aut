package bancodechile.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class AutomationUtils {

    private static final DataFormatter formatter = new DataFormatter();
    static String ruta = System.getProperty("user.dir") + "\\src\\test\\resources\\signsys_13072026.xlsx";
    public static List<String> leerColumnaExcel(int columna) {
        List<String> datos = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(ruta);
             Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null && row.getCell(columna) != null) {
                    String valorCelda = formatter.formatCellValue(row.getCell(columna)).trim();
                    if (!valorCelda.isEmpty() && valorCelda.length()>9) {
                        datos.add(valorCelda);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo Excel: " + e.getMessage());
        }
        return datos;
    }

    public static void pausa(long milisegundos) {
        try { Thread.sleep(milisegundos); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
