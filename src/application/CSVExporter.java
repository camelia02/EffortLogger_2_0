package application;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CSVExporter {

    public static void exportToCSV(Connection connection, String tableName) {
        String query = "SELECT * FROM " + tableName;

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream("/EffortLogger_2_0/downloads/" + tableName + ".xlsx");
             ResultSet resultSet = connection.prepareStatement(query).executeQuery()) {

            Sheet sheet = workbook.createSheet(tableName);

            // Write column headers
            Row headerRow = sheet.createRow(0);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int col = 1; col <= columnCount; col++) {
                Cell cell = headerRow.createCell(col - 1);
                cell.setCellValue(metaData.getColumnName(col));
            }

            // Write data
            int rowNum = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                for (int col = 1; col <= columnCount; col++) {
                    Cell cell = row.createCell(col - 1);
                    cell.setCellValue(resultSet.getString(col));
                }
            }

            // Write the workbook content to the file
            workbook.write(fileOut);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
