//package application;
//	
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.stage.Stage;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//
//
//public class Main extends Application {
//	private MainSceneController mainController;
//	
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			FXMLLoader login = new FXMLLoader(getClass().getResource("login.fxml"));
//			Parent root = login.load();
//			Scene scene=new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//			
//			LoginController logincontrol = login.getController();
//			logincontrol.loggedInProperty().addListener((obs, old, updated)-> {
//				if (updated) {
//                    // Load the main scene when loggedIn becomes true
//                    try {
//                        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
//                        Parent mainRoot = mainLoader.load();
//                        Scene mainScene = new Scene(mainRoot);
//                        mainController = mainLoader.getController();
//                        int rank = logincontrol.isEmployee();
//            			mainController.initialize(rank);
//
//                        primaryStage.setScene(mainScene);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//			});
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		launch(args);
//	}
//}
package application;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;
import java.sql.DatabaseMetaData;

public class Main {  
	
	  
  // The recommended format of a connection URL is the long format with the
  // connection descriptor.
  //final static String DB_URL= "jdbc:oracle:thin:@myhost:1521/myorcldbservicename";
  // For ATP and ADW - use the TNS Alias name along with the TNS_ADMIN when using 18.3 JDBC driver
  // final static String DB_URL="jdbc:oracle:thin:@wallet_dbname?TNS_ADMIN=/Users/test/wallet_dbname";
  // In case of windows, use the following URL 
  //final static String DB_URL="jdbc:oracle:thin:@cyhxfar9lch0mgfg_high?TNS_ADMIN=C:\\Users\\camel\\Oracle\\Wallet_CYHXFAR9LCH0MGFG";
  final static String DB_USER = "admin";
  final static String DB_PASSWORD = "tu#63_CSE365";
  final static String DB_URL = "jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.us-phoenix-1.oraclecloud.com))(connect_data=(service_name=gd44933cc717050_cyhxfar9lch0mgfg_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))";
 /*
  * The method gets a database connection using 
  * oracle.jdbc.pool.OracleDataSource. It also sets some connection 
  * level properties, such as,
  * OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH,
  * OracleConnection.CONNECTION_PROPERTY_THIN_NET_CHECKSUM_TYPES, etc.,
  * There are many other connection related properties. Refer to 
  * the OracleConnection interface to find more. 
  */
  public static void main(String args[]) throws SQLException {
    Properties info = new Properties();     
    info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
    info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);          
    info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");    
    


    OracleDataSource ods = new OracleDataSource();
    ods.setURL(DB_URL);    
    ods.setConnectionProperties(info);

    // With AutoCloseable, the connection is closed automatically.
    try (OracleConnection connection = (OracleConnection) ods.getConnection()) {
      // Get the JDBC driver name and version 
      DatabaseMetaData dbmd = connection.getMetaData();       
      System.out.println("Driver Name: " + dbmd.getDriverName());
      System.out.println("Driver Version: " + dbmd.getDriverVersion());
      // Print some connection properties
      System.out.println("Default Row Prefetch Value is: " + 
         connection.getDefaultRowPrefetch());
      System.out.println("Database Username is: " + connection.getUserName());
      System.out.println();
      // Perform a database operation 
      printEffort(connection);
    }
    
    
  }
  public static void printEffort(Connection connection) throws SQLException {
	    try (Statement statement = connection.createStatement()) {
	        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM Effort")) {
	            System.out.println("Effort Data:");
	            System.out.println("ID | DATE | START TIME | STOP TIME | PROJECT NAME | LIFECYCLE STEP | EFFORT CATEGORY | DELIVERABLE");
	            System.out.println("-------------------------------------------------------------");
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                java.sql.Date date = resultSet.getDate("datecolumn");
	                java.sql.Timestamp startTime = resultSet.getTimestamp("startTime");
	                java.sql.Timestamp stopTime = resultSet.getTimestamp("stopTime");
	                String projectName = resultSet.getString("projectName");
	                String lifeCycleStep = resultSet.getString("lifeCycleStep");
	                String effortCategory = resultSet.getString("effortCategory");
	                String deliverable = resultSet.getString("deliverable");
	                
	                System.out.println(id + " | " + date + " | " + startTime + " | " + stopTime + " | " + projectName + " | " + lifeCycleStep + " | " + effortCategory + " | " + deliverable);
	            }
	        }
	    }
	}

}