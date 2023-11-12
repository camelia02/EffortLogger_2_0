package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
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
    private ToggleSwitch darkModeButton;

    @FXML
    private ToggleSwitch emailNotifButton;

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
    private ToggleSwitch userConsentButton;

    @FXML
    void navClicked(ActionEvent event) {
    	if (navMainTab.getSelectedToggle().equals(mainMenuButton)) {
    		mainHomePane.setVisible(true);
        	mainEntryPane.setVisible(false);
        	mainReportPane.setVisible(false);
        	mainTeamCollabPane.setVisible(false);
        	mainExportPane.setVisible(false);
        	mainPlanningPokerPane.setVisible(false);
        	mainPrivacyPane.setVisible(false);
        	mainSettingsPane.setVisible(false);
    	}
    	
    	else if (navMainTab.getSelectedToggle().equals(mainEntryButton)) {
        	mainHomePane.setVisible(false);
        	mainEntryPane.setVisible(true);
        	mainReportPane.setVisible(false);
        	mainTeamCollabPane.setVisible(false);
        	mainExportPane.setVisible(false);
        	mainPlanningPokerPane.setVisible(false);
        	mainPrivacyPane.setVisible(false);
        	mainSettingsPane.setVisible(false);
    	}
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
    	System.out.println("main entry button clicked");
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
    
}

