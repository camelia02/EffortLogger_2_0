package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static MainSceneController mainController;

    public static MainSceneController getMainController() {
        return mainController;
    }
    public void setMainController(MainSceneController mainController) {
        Main.mainController = mainController;
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the login scene
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent loginRoot = loginLoader.load();
            Scene loginScene = new Scene(loginRoot);
            primaryStage.setScene(loginScene);
            primaryStage.show();

            // Get the controller for the login scene
            LoginController loginController = loginLoader.getController();

            // Add a listener for the loggedIn property
            //loginController.loggedInProperty().addListener((obs, old, updated) -> {
//                if (updated) {
//                    try {
//                    	FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
//                        Parent mainRoot = mainLoader.load();
//                        Scene mainScene = new Scene(mainRoot);
//
//                        primaryStage.setScene(mainScene);
//                        primaryStage.show();
//
//                        mainController = mainLoader.getController();
//                        mainController.initialize();
//
//                        // Set the MainSceneController instance in Main
//                        setMainController(mainController);
//                        
//                        // Now you can access the employee
//                        Employee employeeFromLogin = mainController.getEmployee();
//                        System.out.println("Employee ID: " + employeeFromLogin.getID());
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
