package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EffortLogger2 extends Application {
	private static MainSceneController mainController;
	
	private static DashboardController dashboard;
	
    public static MainSceneController getMainController() {
        return mainController;
    }
    public void setMainController(MainSceneController mainController) {
        EffortLogger2.mainController = mainController;
    }
    
    public static DashboardController getDashboard() {
        return dashboard;
    }
    public void setDashboardController(DashboardController dashboard) {
        EffortLogger2.dashboard = dashboard;
    }

 
    @Override
    public void start(Stage primaryStage) {
        try {
    
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent loginRoot = loginLoader.load();
            Scene loginScene = new Scene(loginRoot);
            primaryStage.setScene(loginScene);
            primaryStage.show();

            // Get the controller for the login scene
            LoginController loginController = loginLoader.getController();

            // Add a listener for the loggedIn property
            loginController.loggedInProperty().addListener((obs, old, updated) -> {
                if (updated) {
                    try {
                    	FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                        Parent mainRoot = mainLoader.load();
                        Scene mainScene = new Scene(mainRoot);

                        primaryStage.setScene(mainScene);
                        primaryStage.show();

                        dashboard = mainLoader.getController();
                        //dashboard.initialize();

                        // Set the MainSceneController instance in Main
                        setDashboardController(dashboard);
                        dashboard.setConnection(loginController.getConnection());
                        // Now you can access the employee
                        Employee employeeFromLogin = dashboard.getEmployee();
                        System.out.println("Employee ID: " + employeeFromLogin.getID());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
