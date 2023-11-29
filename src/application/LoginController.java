package application;

import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Platform;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.MaskerPane;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class LoginController implements Initializable {

    @FXML
    private Label errorLogin;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;
    
    @FXML
    private MaskerPane load;

    private final BooleanProperty loggedIn = new SimpleBooleanProperty(false);
    
    
    private Connection connection;
    
 
    
    public Connection getConnection() {
        return connection;
    }
    
   
    BooleanProperty loggedInProperty() {
        return loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn.get();
    }


    public void setLoggedIn(boolean loggedIn, Employee employee){
        this.loggedIn.set(loggedIn);
        if (loggedIn) {
            // Ensure that the MainSceneController is initialized
            //MainSceneController mainSceneCoSSSntroller = Main.getMainController();
        	DashboardController dashboard = EffortLogger2.getDashboard();
           if (dashboard != null) {
                dashboard.setEmployee(employee);
                load.setDisable(true);
                dashboard.initializeEmployeeData();
                
                //Close connection
                //close();
           }
            else {
                //If MainSceneController is not initialized, you may want to handle it or log an error
                System.err.println("Dashboard is not initialized.");
            }
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	load.setDisable(true);
    	load.setVisible(false);
    	//load.setOpacity(0.0);
    }
    
    
    @FXML
    void loginClicked(ActionEvent event)throws SQLException {
        String username = idField.getText();
        String password = passwordField.getText();

        Platform.runLater(() -> {
            load.setVisible(true);
            load.setDisable(false);
            load.toFront();
        });

        new Thread(() -> {
            try(OracleDBConnection con = new OracleDBConnection()) { 
                connection = con.makeConnection();
                Employee emp = login(username, password);
                
                // Ensure UI updates are performed on the JavaFX Application Thread
                Platform.runLater(() -> {
                    if (emp != null) {
							setLoggedIn(true, emp);
                    }
                    System.out.println(username + " " + password);
                    //load.setVisible(false);
                    load.setDisable(true);
                });
            } catch (Exception e) {
                System.err.println("Error during login: " + e.getMessage());
                
                // Ensure UI updates are performed on the JavaFX Application Thread
                Platform.runLater(() -> {
                    showLoginError("An error occurred during login");
                    load.setVisible(false);
                    load.setDisable(true);
                });
            }
        }).start();
    }
    
     
    private Employee login(String username, String password) throws SQLException {
        String sql1 = "SELECT * FROM EMPLOYEE_LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
        try (PreparedStatement employeeStatement = connection.prepareStatement(sql1)) {
            employeeStatement.setString(1, username);
            employeeStatement.setString(2, password);

            try (ResultSet employeeResult = employeeStatement.executeQuery()) {
                if (employeeResult.next()) {
                    String sql2 = "SELECT * FROM EMPLOYEE WHERE EMAIL = ? AND PASSWORD = ?";
                    try (PreparedStatement employeeRetrieval = connection.prepareStatement(sql2)) {
                        employeeRetrieval.setString(1, username);
                        employeeRetrieval.setString(2, password);

                        try (ResultSet employeeData = employeeRetrieval.executeQuery()) {
                            if (employeeData.next()) {
                                int id = employeeData.getInt("ID");
                                int rank = employeeData.getInt("RANK");
                                String fName = employeeData.getString("FIRST_NAME");
                                String mName = employeeData.getString("MIDDLE_NAME");
                                String lName = employeeData.getString("LAST_NAME");
                                // System.out.println(id + "\n" + rank + "\n" + fName + "\n" + mName + "\n" + lName);
                                return new Employee(id, rank, fName, mName, lName, username, password);
                            }
                            return null;
                        }
                    }
                }
                return null;
            }
        }
    }

    private void showLoginError(String errorMessage) {
        Platform.runLater(() -> {
            errorLogin.setText(errorMessage);
            errorLogin.setVisible(true);
        });
    }

   

}

