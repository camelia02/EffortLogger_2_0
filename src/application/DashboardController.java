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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import org.controlsfx.control.ToggleSwitch;

public class DashboardController implements Initializable {

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
    private Button sPoints;
    
    @FXML
    private Button estimationTime;
    
    @FXML
    private Button avgTime;
    
    @FXML
    private Button similarProj;
    
    @FXML
    private Button defects;

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
    
    @FXML
    private Button exitButton1;
    
    @FXML
    private Pane infoPane;

    @FXML
    private Label information;
    
    @FXML
    private Label title;
    
    
    private Image green_circle;
    
    private Image grey_circle;
    
	private Employee employee;
	
	public void setEmployee(Employee emps) {
		this.employee = emps;
	}
	
	Employee getEmployee() {
		return employee;
	}
	
	public void initializeEmployeeData() {
	    Employee employeeFromLogin = getEmployee();

	    if (employeeFromLogin != null) {
	        setEmployee(employeeFromLogin);
	        usernameTextLabel.setText(employeeFromLogin.getFullName());
	        System.out.println(employeeFromLogin.getID() + "\n" + employeeFromLogin.getRank() + "\n" +
	                employeeFromLogin.getFullName() + "\n");
	    } else {
	        System.err.println("Employee not set in MainSceneController");
	    }
	}
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	// Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date using a DateTimeFormatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDateTime.format(dateFormatter);

        // Format the time using a DateTimeFormatter
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentDateTime.format(timeFormatter);

        // Set the formatted date and time to the labels
        dateLabel.setText("Date: " + formattedDate);
        timeLabel.setText("Time: " + formattedTime);
        
		green_circle = new Image(getClass().getResourceAsStream("green-circle.png"), 15, 15, true, true);
		
		grey_circle = new Image(getClass().getResourceAsStream("grey-circle.png"), 15, 15, true, true);
		//infoPane.setClip(createRoundedRectangle(10));	
		infoPane.toBack();
    	infoPane.setVisible(false);
    	title.setText("");
    	information.setText("");
		username_1_1_button.setGraphic(new ImageView(grey_circle));
		username_1_2_button.setGraphic(new ImageView(grey_circle));
		username_1_3_button.setGraphic(new ImageView(grey_circle));
		mainHomePane.setVisible(true);
    	mainEntryPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainPlanningPokerPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    	infoPane.setVisible(false);
		initializeEmployeeData();
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
    	infoPane.setVisible(false);
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
    	infoPane.setVisible(false);
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
    	infoPane.setVisible(false);
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
    	infoPane.setVisible(false);
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
    	infoPane.setVisible(false);
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
    	infoPane.setVisible(false);

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
    	infoPane.setVisible(false);

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
    	infoPane.setVisible(false);
    }
    
    @FXML
    void usernameToggleClicked(ActionEvent event) {
    	infoPane.setVisible(false);
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
    	infoPane.setVisible(false);
    	if (((ImageView) btn.getGraphic()).getImage().equals(grey_circle)) {
    		//System.out.println("grey_circle match");
    		return true;
    		
    	}
    	return false;
    }
    
    @FXML
    void infoClosed(ActionEvent event) {
    	System.out.print("clicked");
    	infoPane.toBack();
    	infoPane.setVisible(false);
    }
    
    @FXML
    void spOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);
   	    title.setText(sPoints.getText());
   	    information.setText(
   	    		"1. As a user, I want to create a new account with my personal information.\r\n"
   	    		+ "2. As a user, I want to log in to my account securely using my email and password.\r\n"
   	    		+ " .......\r\n"
   	    		);

    }
    
    @FXML
    void estOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);
    	title.setText(estimationTime.getText());
    	information.setText(
    			"1. Rough Order of Magnitude (ROM) Estimate: ±50% accuracy - This is a very high-level estimate made early in the project when there is limited information available. It provides a ballpark figure but is subject to substantial variation.\r\n"
    			+ "2. Preliminary Estimate: ±30% accuracy - As the project progresses and more information becomes available, you can provide a preliminary estimate that is somewhat more accurate than a ROM estimate but still has a significant margin of error.\r\n"
    			+ ".......");
    }
    
    @FXML
    void avgTOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);
    	title.setText(avgTime.getText());
    	information.setText(
    			"1. Project Planning and Initiation:\r\n"
    			+ "- Duration: 1 to 2 weeks\r\n"
    			+ "- Activities: Project kickoff, requirement gathering, initial architecture design, and team formation.\r\n"
    			+ "2. Requirements Gathering and Analysis:\r\n"
    			+ "- Duration: 2 to 4 weeks\r\n"
    			+ "- Activities: Detailed discussions with stakeholders, user stories creation, and use case analysis.\r\n"
    			+ "3. Design and Architecture:\r\n"
    			+ "- Duration: 4 to 6 weeks\r\n"
    			+ "4. Activities: ");
    }
    
    @FXML
    void projsOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);
    	title.setText(similarProj.getText());
    	information.setText(
    			"1. Online Marketplace Platform\r\n"
    			+ "2. Classifieds Website\r\n"
    			+ "3. Auction Platform\r\n"
    			+ "4. Event Ticketing System\r\n"
    			+ "5. Food Delivery and Ordering App\r\n"
    			);
    }
    
    @FXML
    void defectOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);	
    	title.setText(defects.getText());
    	information.setText(
    			"1. Security Vulnerabilities:\r\n"
    			+ "Vulnerabilities in payment processing and credit card handling, potentially leading to data breaches.\r\n"
    			+ "Inadequate security measures for user data, exposing sensitive information to potential threats.\r\n"
    			+ "2. Performance and Scalability Issues:\r\n"
    			+ "Slow loading times, particularly during peak traffic periods, leading to poor user experience.\r\n"
    			+ "Scalability problems when the system is unable to handle increasing user load, resulting in site crashes or slow response times."
    			);
    }
}
