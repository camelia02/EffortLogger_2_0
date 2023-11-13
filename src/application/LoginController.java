package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Platform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class LoginController implements AutoCloseable {

    @FXML
    private Label errorLogin;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    private final BooleanProperty loggedIn = new SimpleBooleanProperty(false);
    private Connection connection;

    public BooleanProperty loggedInProperty() {
        return loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn.get();
    }

    public void setLoggedIn(boolean loggedIn, Employee employee) {
        this.loggedIn.set(loggedIn);
        if (loggedIn) {
            // Ensure that the MainSceneController is initialized
            //MainSceneController mainSceneCoSSSntroller = Main.getMainController();
        	DashboardController dashboard = EffortLogger2.getDashboard();
           if (dashboard != null) {
                dashboard.setEmployee(employee);
                dashboard.initializeEmployeeData();
           }
            else {
                //If MainSceneController is not initialized, you may want to handle it or log an error
                System.err.println("Dashboard is not initialized.");
            }
        }
    }


    @FXML
    void loginClicked(ActionEvent event) throws SQLException {
        String username = idField.getText();
        String password = passwordField.getText();

        try (OracleDBConnection con = new OracleDBConnection()) {
            connection = con.makeConnection();
            Employee emp = login(username, password);
            if (emp != null) {
                setLoggedIn(true,emp);
            }
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            showLoginError("An error occurred during login");
        }
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

    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

