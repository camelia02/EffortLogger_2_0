package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import org.controlsfx.control.ToggleSwitch;

public class DashboardController {

    @FXML
    private ToggleSwitch DataAnonyButton;

    @FXML
    private ToggleSwitch DataEncryptButton;

    @FXML
    private ToggleSwitch ProfileVisButton;

    @FXML
    private ToggleSwitch TwoFAButton;

    @FXML
    private ToggleSwitch autoCorrectButton;

    @FXML
    private ToggleSwitch autoUpdateButton;

    @FXML
    private Button codingButton;

    @FXML
    private ToggleSwitch darkModeButton;

    @FXML
    private Label dateLabel;

    @FXML
    private Button debuggingButton;

    @FXML
    private Button defectButton;

    @FXML
    private Button deploymentButton;

    @FXML
    private ToggleSwitch emailNotifButton;

    @FXML
    private Button eventButton;

    @FXML
    private Button exitButton;

    @FXML
    private RadioButton mainEntryButton;

    @FXML
    private Pane mainEntryPane;

    @FXML
    private RadioButton mainExportButton;

    @FXML
    private Pane mainExportPane;

    @FXML
    private Pane mainHomePane;

    @FXML
    private RadioButton mainMenuButton;

    @FXML
    private Pane mainPlanningPokerPane;

    @FXML
    private RadioButton mainPlanningPoklerButton;

    @FXML
    private RadioButton mainPrivacyButton;

    @FXML
    private Pane mainPrivacyPane;

    @FXML
    private RadioButton mainReportButton;

    @FXML
    private Pane mainReportPane;

    @FXML
    private RadioButton mainSettingsButton;

    @FXML
    private Pane mainSettingsPane;

    @FXML
    private RadioButton mainTeamCollabButton;

    @FXML
    private Pane mainTeamCollabPane;

    @FXML
    private ToggleGroup navMainTab;

    @FXML
    private ToggleSwitch notifSoundButton;

    @FXML
    private Button performanceButton;

    @FXML
    private Button refactoringButton;

    @FXML
    private Button requirementAnlyButton;

    @FXML
    private Label roleLabel;

    @FXML
    private Button securityButton;

    @FXML
    private Button shrinkButton;

    @FXML
    private Button sysDesignButton;

    @FXML
    private Button testingButton;

    @FXML
    private Label timeLabel;

    @FXML
    private ToggleSwitch userConsentButton;

    @FXML
    private Label usernameTextLabel;

    @FXML
    private ToggleButton username_1_1_button;

    @FXML
    private ImageView username_1_1_img;

    @FXML
    private ToggleButton username_1_2_button;

    @FXML
    private ImageView username_1_2_img;

    @FXML
    private ToggleButton username_1_3_button;

    @FXML
    private ImageView username_1_3_img;

    @FXML
    private ToggleGroup username_1_group;
    
    private Image green_circle;
    
    private Image grey_circle;
    

    @FXML
    void initialize() {
		green_circle = new Image(getClass().getResourceAsStream("green-circle.png"), 15, 15, true, true);
		
		grey_circle = new Image(getClass().getResourceAsStream("grey-circle.png"), 15, 15, true, true);
				
		username_1_1_button.setGraphic(new ImageView(grey_circle));
		username_1_2_button.setGraphic(new ImageView(grey_circle));
		username_1_3_button.setGraphic(new ImageView(grey_circle));
    }
    @FXML
    void mainHomeClicked(ActionEvent event) {
    	mainHomePane.setVisible(true);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    }
    
    @FXML
    void mainEntryClicked(ActionEvent event) {
    	//System.out.println("main entry button clicked");
    	mainHomePane.setVisible(false);
    	mainEntryPane.setVisible(true);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    	//mainEntryPane.setVisible(true);
    }
    
    @FXML
    void mainReportClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(true);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    }
    @FXML
    void mainTeamCollabClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(true);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    }
    @FXML
    void mainExportClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(true);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    }
    @FXML
    void mainPlanningPokerClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(true);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);

    }
    @FXML
    void mainPrivacylicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(true);
    	mainSettingsPane.setVisible(false);

    }
    
    @FXML
    void mainSettingsClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(true);
    }
    
    @FXML
    void usernameToggleClicked(ActionEvent event) {
    	if (event.getSource() == username_1_1_button) {
    		if (checkGray(username_1_1_button)) {
    			username_1_1_button.setGraphic(new ImageView(green_circle));
    		} else {
    			username_1_1_button.setGraphic(new ImageView(grey_circle));
    		}
    	}
    	
    	else if (event.getSource() == username_1_2_button) {
    		if (checkGray(username_1_2_button)) {
    			username_1_2_button.setGraphic(new ImageView(green_circle));
    		} else {
    			username_1_2_button.setGraphic(new ImageView(grey_circle));
    		}
    	}
    	
    	else if (event.getSource() == username_1_3_button) {
    		if (checkGray(username_1_3_button)) {
    			username_1_3_button.setGraphic(new ImageView(green_circle));
    		} else {
    			username_1_3_button.setGraphic(new ImageView(grey_circle));
    		}
    	}
    	/*
		else if () {
			
		}
		    	
		else if () {
			
		}
		    	
		else if () {
			
		} */
    }
    
    boolean checkGray(ToggleButton btn) {
    	if (((ImageView) btn.getGraphic()).getImage().equals(grey_circle)) {
    		//System.out.println("grey_circle match");
    		return true;
    		
    	}
    	return false;
    }
    
}
