package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class LoginController {

    @FXML
    private Label errorLogin;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;
   
    private String pass = "";
    private String id = "";
    private String id2 = "";
    
    private final BooleanProperty loggedIn = new SimpleBooleanProperty(false);
    private final IntegerProperty rank = new SimpleIntegerProperty(0);

    public BooleanProperty loggedInProperty() {
        return loggedIn;
    }
    public IntegerProperty rankProperty() {
        return rank;
    }

    public boolean isLoggedIn() {
        return loggedIn.get();
    }
    
    public int isEmployee() {
        return rank.get();
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn.set(loggedIn);
    }
    
    public void setRank(int loggedIn) {
        this.rank.set(loggedIn);
    }
    
    @FXML
    void idEntered(ActionEvent event) {
    	//this.id = idField.getText();
    }

    @FXML
    void loginClicked(ActionEvent event) {
    	this.id = idField.getText();
    	this.pass = passwordField.getText();
    	if(this.id.equals("engineer") && this.pass.equals("")){
    		setLoggedIn(true);
    		setRank(1);
    	}
    	else if(this.id.equals("supervisor") && this.pass.equals("")){
    		setLoggedIn(true);
    		setRank(1);
    	}
    	else {
    		errorLogin.setVisible(true);
    	}
    }

    @FXML
    void passwordEntered(ActionEvent event) {
    	//this.pass = passwordField.getText();
    }

}
