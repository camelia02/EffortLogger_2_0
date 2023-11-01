package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class LoginController {

    @FXML
    private Label errorLogin;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;
   
    
    private final BooleanProperty loggedIn = new SimpleBooleanProperty(false);
    private String id;
    private String pass;
    private static Connection connection;
    
    public BooleanProperty loggedInProperty() {
        return loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn.get();
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn.set(loggedIn);
    }
   

    @FXML
    void loginClicked(ActionEvent event) throws SQLException {
    	this.id = idField.getText();
    	this.pass = passwordField.getText();
    	Employee emp = login(this.id, this.pass);
    	System.out.println(emp);
    	if(emp != null){
    		setLoggedIn(true);
    	}
    	else {
    		errorLogin.setVisible(true);
    	}
    }

    public static Employee login(String username, String password) throws SQLException {
        OracleDBConnection con = new OracleDBConnection();
        connection = con.makeConnection();
        try  {
        	String sql1 = "SELECT * FROM EMPLOYEE_LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
        	if (!connection.isClosed()) {
        	    try (PreparedStatement employeeStatement = connection.prepareStatement(sql1)) {
        	        employeeStatement.setString(1, username);
        	        employeeStatement.setString(2, password);

        	        try (ResultSet employeeResult = employeeStatement.executeQuery()) {
        	            // Check if authentication is successful
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
        	                            System.out.println(id + "\n" + rank + "\n" + fName + "\n" + mName + "\n" + lName);
        	                            Employee authenticatedEmployee = new Employee(id, rank, fName, mName, lName, username, password);
        	                            return authenticatedEmployee;
        	                        }
        	                        return null;
        	                    }
        	                }
        	            }
        	            return null;
        	        }
        	    }
        	}

        }catch(SQLException e) {
        	System.err.println(e);
        }

        // Add a return statement here to handle cases where no authentication is successful
        return null;
    }


 
}
