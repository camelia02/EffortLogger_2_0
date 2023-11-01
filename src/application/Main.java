package application;
	
import java.sql.PreparedStatement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import oracle.jdbc.OraclePreparedStatement;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private MainSceneController mainController;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader login = new FXMLLoader(getClass().getResource("login.fxml"));
			Parent root = login.load();
			Scene scene=new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			LoginController logincontrol = login.getController();
			logincontrol.loggedInProperty().addListener((obs, old, updated)-> {
				if (updated) {
                    // Load the main scene when loggedIn becomes true
                    try {
                        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
                        Parent mainRoot = mainLoader.load();
                        Scene mainScene = new Scene(mainRoot);
                        mainController = mainLoader.getController();
                      
            			mainController.initialize();

                        primaryStage.setScene(mainScene);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
//		OracleDBConnection connection = new OracleDBConnection();
//		connection.makeConnection();
//		  String sql1 = "SELECT * FROM EMPLOYEE_LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
//	        
//	        
//	        try (PreparedStatement employeeStatement = connection.prepareStatement(sql1)) {
//	        	
//	        	((OraclePreparedStatement)employeeStatement).setString(1, username);
//	        	((OraclePreparedStatement)employeeStatement).setString(2, password);
//	        	employeeStatement.execute();
//	        	
//	        	if
//	        	
//	        }
		
	}
}
