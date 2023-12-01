package application;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVExporter {

    public static void exportToCSV(Connection connection, String tableName) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
        String timestamp = currentTime.format(formatter);
    	
        String query = "SELECT * FROM " + tableName;

        String userHome = System.getProperty("user.home");
        String relativePath = "eclipse-workspace/EffortLogger_2_0/downloads/" + tableName + "_" + timestamp + ".xlsx";
        //String relativePath = "/Downloads";
        String fullPath = Paths.get(userHome, relativePath).toString();

        // Use fullPath for file operations
        System.out.println("Full Download Path: " + fullPath);
        
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(fullPath);
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
