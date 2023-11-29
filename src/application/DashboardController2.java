package application;

import application.OracleDBConnection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import oracle.jdbc.OracleConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.controlsfx.control.ToggleSwitch;

public class DashboardController2 implements AutoCloseable, Initializable {

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
    
    @FXML
    private Button myPoint;
    
    @FXML
    private Button btn0;
    
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    
    @FXML
    private Button btn3;
    
    @FXML
    private Button btn4;
    
    @FXML
    private Button empw;
    
    @FXML
    private Button empw1;
    
    @FXML
    private Button empw2;
    
    @FXML
    private Button empw3;
    
    @FXML
    private Label timer;
    
    @FXML
    private Label avgW;
    
    @FXML
    private Label rangeW;
    
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
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        String formattedDate = currentDateTime.format(dateFormatter);

        // Format the time using a DateTimeFormatter
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm a");
        String formattedTime = currentDateTime.format(timeFormatter);

        // Set the formatted date and time to the labels
        dateLabel.setText(formattedDate);
        timeLabel.setText(formattedTime);
        
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Schedule a task to update the time every second
        scheduler.scheduleAtFixedRate(() -> {
            // Get the current date and time
            LocalDateTime updatedDateTime = LocalDateTime.now();

            // Format the updated time using a DateTimeFormatter
            String updatedFormattedTime = updatedDateTime.format(timeFormatter);

            // Update the time label with the new formatted time
            Platform.runLater(() -> timeLabel.setText(updatedFormattedTime));
        }, 0, 1, TimeUnit.SECONDS); // Update every second

        // Add a shutdown hook to stop the scheduler when the program exits
        Runtime.getRuntime().addShutdownHook(new Thread(scheduler::shutdown));
        
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
		initializeEmployeeData();
		displayEntryDetails();
		displayReportDetails();
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
    
    private int seconds = 30;
    private Timeline timeline = new Timeline();
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
    	
    	
    	
    	
    	KeyFrame kf = new KeyFrame(Duration.seconds(1), e -> {
    		timer.setText(String.valueOf(seconds));
    		seconds--;
    		if(timeline != null) {
	    		if(seconds < 0) {
	    			timeline.stop();
	    		}
    		}
    	});

    	timeline.getKeyFrames().add(kf);
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.play();
    	
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

    @FXML
    private TextField entryTitle;
    @FXML
    private TextField entryDate;
    @FXML
    private TextField entryType;
    @FXML
    private TextField entryTimeSpent;
    @FXML
    private TextField entryDescription;
    @FXML
    private TextField reportTitle;
    @FXML
    private TextField reportDate;
    @FXML
    private TextField reportType;
    @FXML
    private TextField reportTimeSpent;
    @FXML
    private TextField reportDescription;

    private OracleDBConnection dbConnection;


    public void displayEntryDetails() {
        try (OracleConnection conn = dbConnection.makeConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin.ENTRY WHERE ID = ?")) {
            
            // Set the ID
            pstmt.setInt(1, 1); // ID = 1

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dateTimeString = rs.getString("DATE_COLUMN");
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    String dateString = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                	
                    entryTitle.setText("Title: \n" + rs.getString("TITLE"));
                    entryDate.setText("Date: \n" + rs.getString("DATE_COLUMN"));
                    entryType.setText("Type: \n" + rs.getString("TYPE"));
                    entryTimeSpent.setText("Time Spent: \n" + rs.getString("TIME"));
                    entryDescription.setText("Description: \n" + rs.getString("DESCRIPTION"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
        }
    }
    
    public void displayReportDetails() {
//        try (OracleConnection conn = dbConnection.makeConnection();
//             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin.REPORT WHERE ID = ?")) {
//
//            pstmt.setInt(1, 1); // Assuming you're fetching the report with ID = 1
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
                    // Setting text for each TextField with the data from the database
                    reportTitle.setText("Title: EffortLogger Defect Check");
                    reportDate.setText("Date: 2023-11-11");
                    reportType.setText("Type: Defect");
                    reportTimeSpent.setText("Time Spent: 05:10");
                    reportDescription.setText("Description: This is Effortlogger defect check.");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle SQL exception
//        }
    }

    private String formatDate(Date date) {
        if (date != null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        return "";
    }

    
    @FXML
    void one(ActionEvent event) {
    	timeline.stop();
    	myPoint.setText("1");
    	disableButton(); 
    	compute(); 
    	
    }
    
    @FXML
    void two(ActionEvent event) {
    	timeline.stop();
    	myPoint.setText("2");
    	disableButton(); 
    	compute(); 
    }
    
    @FXML
    void three(ActionEvent event) {
    	timeline.stop();
    	myPoint.setText("3");
    	disableButton();
    	compute(); 
    }
    
    @FXML
    void four(ActionEvent event) {
    	timeline.stop();
    	myPoint.setText("4");
    	disableButton(); 
    	compute(); 
    }
    
    @FXML
    void zero(ActionEvent event) {
    	timeline.stop();
    	myPoint.setText("0");
    	disableButton(); 
    	compute();
    }
    
    void disableButton() {
    	btn0.setDisable(true);
    	btn1.setDisable(true);
    	btn2.setDisable(true);
    	btn3.setDisable(true);
    	btn4.setDisable(true);
    	empw.setText("4");
    	empw1.setText("4");
    	empw2.setText("4");
    	empw3.setText("4");
    }
    
    void compute() {
    	int userW = Integer.parseInt(myPoint.getText());
    	int otherUser = Integer.parseInt(empw.getText());
    	int avg = (userW + 3*otherUser)/4;
    	avgW.setText(String.valueOf(avg));
    	rangeW.setText(String.valueOf(userW > otherUser? userW - otherUser: otherUser - userW));;
    	
    }

	
    
}
