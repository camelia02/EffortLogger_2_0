package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
    
    @FXML
    private Pane loggerPane;
    
    @FXML
    private Button type;
    
    
    @FXML
    private Button close;
    
    @FXML
    private Button entry;
    
    @FXML
    private Button report;
    
    @FXML
    private TextArea logTitle;
    
    @FXML
    private TextArea logDate;
    
    @FXML
    private TextArea logType;
    
    @FXML
    private TextArea logTime;
    
    @FXML
    private TextArea logDescription;
    
    @FXML
    private Label titleLabel;
    
    @FXML
    private Label dateLabelLog;
    
    @FXML
    private Label typeLabel;
    
    @FXML
    private Label timeLabelLog;
    
    @FXML
    private Label descriptionLabel;
    
    @FXML
    private Pane exportPane;
    
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
    
    @FXML
    private Label activityLogs;
   
    
    private Image green_circle;
    
    private Image grey_circle;
    
	private Employee employee;
	
	private Connection connection;
	

	public void setConnection(Connection connection) {
	    this.connection = connection;
	}
	
	public void setEmployee(Employee emps) {
		this.employee = emps;
	}
	
	Employee getEmployee() {
		return employee;
	}
	
	public DashboardController() {
		
	}

	public DashboardController(Connection connection) {
        this.connection = connection;
    }
	
	public void initializeEmployeeData(){
	    Employee employeeFromLogin = getEmployee();
	    if (employeeFromLogin != null) {
	        setEmployee(employeeFromLogin);
	        usernameTextLabel.setText(employeeFromLogin.getFullName());
	        System.out.println(employeeFromLogin.getID() + "\n" + employeeFromLogin.getRank() + "\n" +
	                employeeFromLogin.getFullName() + "\n");
	    } else {
	        System.err.println("Employee not set in DashboardController");
	    }
	}
    
	
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	try {
    		OracleDBConnection con = new OracleDBConnection();
            connection = con.makeConnection();
            Employee employeeFromLogin = getEmployee();

            if (employeeFromLogin != null) {
                setEmployee(employeeFromLogin);
                usernameTextLabel.setText(employeeFromLogin.getFullName());
                System.out.println(employeeFromLogin.getID() + "\n" + employeeFromLogin.getRank() + "\n" +
                        employeeFromLogin.getFullName() + "\n");
            } else {
                System.err.println("Employee not set in DashboardController");
            }
        } catch (Exception e) {
            // Handle the SQLException (log or propagate)
            e.printStackTrace();
        }

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
		
		loggerPane.setVisible(false);
		exportPane.setVisible(false);
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
    	exportPane.toBack();
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
    	exportPane.toBack();
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
    	exportPane.toBack();
    }
    
    void displayLog() {
    	String updateLog = "Select * from logs";
     	StringBuilder activityText = new StringBuilder();
     	int count = 1;
     	try (PreparedStatement pstmt = connection.prepareStatement(updateLog)) {
     		try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                        String activity = rs.getString("DESCRIPTION");
                        activityText.append(count).append(". ").append(activity).append(".\n");
                        count++;
                }
            }
            activityLogs.setText(activityText.toString());
            
        } catch (SQLException e) {
			e.printStackTrace();
		}
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
    	exportPane.toBack();
    	displayLog();
    	  
    }
    
    @FXML
    void chooseFile(ActionEvent event) {
    	exportPane.setVisible(true);
    	exportPane.toFront();
    }
    
    @FXML
    void entryToCSV(ActionEvent event) {
     	CSVExporter.exportToCSV(connection, "ENTRY");
     	exportPane.setVisible(false);
     	exportPane.toBack();
     	displayLog();
    }
    
    @FXML
    void reportToCSV(ActionEvent event) {
    	CSVExporter.exportToCSV(connection, "REPORT");
    	exportPane.setVisible(false);
    	exportPane.toBack();
    	displayLog();
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
    	exportPane.toBack();
    	
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
    	exportPane.toBack();

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
    	exportPane.toBack();
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

        String getStoryIDQuery = "SELECT STORYID FROM USERSTORIES WHERE EMPLOYEEID = ?";
        String getStoryPointsQuery = "SELECT * FROM HISTORICALSTORYPOINTS WHERE STORYID = ?";

        StringBuilder infoText = new StringBuilder();
        int count = 1;
        try (PreparedStatement pstmtStoryID = connection.prepareStatement(getStoryIDQuery);
             PreparedStatement pstmtStoryPoints = connection.prepareStatement(getStoryPointsQuery)) {

            pstmtStoryID.setInt(1, employee.getID());

            // Execute the query to get STORYID
            try (ResultSet resultSetStoryID = pstmtStoryID.executeQuery()) {
                while (resultSetStoryID.next()) {
                    int storyID = resultSetStoryID.getInt("STORYID");

                    // Execute the query to get STORYPOINTS based on STORYID
                    pstmtStoryPoints.setInt(1, storyID);
                    try (ResultSet resultSetStoryPoints = pstmtStoryPoints.executeQuery()) {
                        while (resultSetStoryPoints.next()) {
                            // Process each row in the STORYPOINTS table
                            //int storyPoints = resultSetStoryPoints.getInt("STORYPOINTS");
                            // Do something with the storyPoints, e.g., print or use as needed
                            //System.out.println("StoryID: " + storyID + ", StoryPoints: " + storyPoints);
                        	String task = resultSetStoryPoints.getString("TASK");
                        	infoText.append(count).append(". ").append(task).append(".\n");
                        	count++;
                        }
                    }
                }
            }
            information.setText(infoText.toString());
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, log or propagate
        }
    }

    
    @FXML
    void estOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);
    	title.setText(estimationTime.getText());
    	
    	String getEst = "Select TASK from HISTORICALAVGCOMPLETIONTIME";
    	int count = 1;
    	StringBuilder infoText = new StringBuilder();
    	try(PreparedStatement pstmt = connection.prepareStatement(getEst)){
    		try(ResultSet result = pstmt.executeQuery()){
    			while(result.next()) {
    				String estimation = result.getString("TASK");
    				infoText.append(count).append(". ").append(estimation).append(".\n");
    			}
    		}
    		
    	information.setText(infoText.toString());
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void avgTOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);
    	title.setText(avgTime.getText());
    	
    	StringBuilder infoText = new StringBuilder();
    	String avqHistorical = "Select * from HISTORICALESTIMATIONACCURACY";
    	int count = 1;
    	try(PreparedStatement pstmt = connection.prepareStatement(avqHistorical)){
    		try(ResultSet result = pstmt.executeQuery()){
    			while(result.next()) {
    				String task = result.getString("TASK");
    				String duration = result.getString("DURATIONRANGE");
    				String activities = result.getString("ACTIVITIES");
    				infoText.append(count).append(". ").append(task).append(":\n - ").append(duration).append("\n - ").append(activities).append("\n");
    			}
    		}
    		
    		information.setText(infoText.toString());
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	    }
    }
    
    @FXML
    void projsOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);
    	title.setText(similarProj.getText());
    	StringBuilder infoText = new StringBuilder();
    	String avqHistorical = "Select PROJECTNAME from PROJECTS";
    	int count = 1;
    	try(PreparedStatement pstmt = connection.prepareStatement(avqHistorical)){
    		try(ResultSet result = pstmt.executeQuery()){
    			while(result.next()) {
    				String name = result.getString("PROJECTNAME");
    				infoText.append(count).append(". ").append(name).append("\n");
    			}
    		}
    		
    		information.setText(infoText.toString());
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	    }
    }
    
    @FXML
    void defectOpened(ActionEvent event) {
    	infoPane.toFront();
    	infoPane.setVisible(true);	
    	title.setText(defects.getText());
    	StringBuilder infoText = new StringBuilder();
    	String avqHistorical = "Select * from HISTORICALDEFECTS";
    	int count = 1;
    	try(PreparedStatement pstmt = connection.prepareStatement(avqHistorical)){
    		try(ResultSet result = pstmt.executeQuery()){
    			while(result.next()) {
    				String title = result.getString("TITLE");
    				String description = result.getString("DESCRIPTION");
    				infoText.append(count).append(". ").append(title).append("\n").append(description).append("\n");
    			}
    		}
    		
    		information.setText(infoText.toString());
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	    }
    }

    public void displayEntryDetails() {
    	
    	String entry = "SELECT * FROM ADMIN.ENTRY WHERE ID = ?";
    	
        try (PreparedStatement pstmt = connection.prepareStatement(entry)) {
            
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
    	String deffect = "SELECT * FROM REPORT WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deffect)) {

            pstmt.setInt(1, 1); // Assuming you're fetching the report with ID = 1

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	String dateTimeString = rs.getString("DATE_COLUMN");
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    String dateString = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                	
                    reportTitle.setText("Title: \n" + rs.getString("TITLE"));
                    reportDate.setText("Date: \n" + rs.getString("DATE_COLUMN"));
                    reportType.setText("Type: \n" + rs.getString("TYPE"));
                    reportTimeSpent.setText("Time Spent: \n" + rs.getString("TIME"));
                    reportDescription.setText("Description: \n" + rs.getString("DESCRIPTION"));
                	    	
                	
//                    // Setting text for each TextField with the data from the database
//                    reportTitle.setText("Title: EffortLogger Defect Check");
//                    reportDate.setText("Date: 2023-11-11");
//                    reportType.setText("Type: Defect");
//                    reportTimeSpent.setText("Time Spent: 05:10");
//                    reportDescription.setText("Description: This is Effortlogger defect check.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
        }
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
    
    @FXML
    void createEntry(ActionEvent event) {
    	loggerPane.setVisible(true);
    	type.setText("Create new entry");
    }
    
    @FXML
    void createReport(ActionEvent event) {
    	loggerPane.setVisible(true);
    	type.setText("Create new report");
    }
    
    private boolean[] validatedField = {false, false, false, false, false};
    @FXML 
    void createLog(ActionEvent event) {
    	boolean allValidated = false;
    	validatedField[0] = !logTitle.getText().isEmpty();
    	validatedField[1] = !logDate.getText().isEmpty();
    	validatedField[2] = !logType.getText().isEmpty();
    	validatedField[3] = !logTime.getText().isEmpty();
    	validatedField[4] = !logDescription.getText().isEmpty();
    	
    	allValidated = validatedField[0] && validatedField[1] && validatedField[3] && validatedField[4] && validatedField[2];
    	System.out.println(allValidated);
    	
    	if(!allValidated) {
    		if(!validatedField[0]) {
    			titleLabel.setTextFill(javafx.scene.paint.Color.RED);
    		} else {
    			titleLabel.setTextFill(javafx.scene.paint.Color.BLACK);
    		}
			if(!validatedField[1]) {
				dateLabelLog.setTextFill(javafx.scene.paint.Color.RED);
			}else {
				if(!isValidDate(logDate.getText())) {
					dateLabelLog.setTextFill(javafx.scene.paint.Color.RED);
					//dateLabelLog.setTextFill(javafx.scene.paint.Color.BLACK);
				}else {
					dateLabelLog.setTextFill(javafx.scene.paint.Color.BLACK);
					System.out.println(logDate.getText());
				}
    		}
			if(!validatedField[2]) {
			    typeLabel.setTextFill(javafx.scene.paint.Color.RED);
			}else {
				typeLabel.setTextFill(javafx.scene.paint.Color.BLACK);
    		}
			if(!validatedField[3]) {
    			timeLabelLog.setTextFill(javafx.scene.paint.Color.RED);
			}else {
				if(isValidTime(logTime.getText())) {
					timeLabelLog.setTextFill(javafx.scene.paint.Color.BLACK);
					System.out.println(logTime.getText());
				}else {
					timeLabelLog.setTextFill(javafx.scene.paint.Color.RED);
					//System.out.println(timeLabelLog.getText());
				}
    		}
			if(!validatedField[4]) {
    			descriptionLabel.setTextFill(javafx.scene.paint.Color.RED);
			}else {
				descriptionLabel.setTextFill(javafx.scene.paint.Color.BLACK);
    		}
    	}else {	
    		 	boolean isDateValid = isValidDate(logDate.getText());
    	        boolean isTimeValid = isValidTime(logTime.getText());

    	        if (!isDateValid) {
    	            dateLabelLog.setTextFill(javafx.scene.paint.Color.RED);
    	            allValidated = false;
    	        } else {
    	            dateLabelLog.setTextFill(javafx.scene.paint.Color.BLACK);
    	            System.out.println(logDate.getText());
    	        }

    	        if (!isTimeValid) {
    	        	allValidated = false;
    	            timeLabelLog.setTextFill(javafx.scene.paint.Color.RED);
    	        } else {
    	            timeLabelLog.setTextFill(javafx.scene.paint.Color.BLACK);
    	            System.out.println(logTime.getText());
    	        }
    		
    	        boolean executed = false;
	    	    if(allValidated) {
	    	    	String entryOrDefect = type.getText().equals("Create new report") ? "REPORT" : "ENTRY";
		    		System.out.println(entryOrDefect);
		    		String createLog = "insert into " + entryOrDefect + " (TYPE, TITLE, DESCRIPTION, DATE_COLUMN, TIME) VALUES (?, ?, ?, TO_DATE(?, 'MM/DD/YYYY'), ?)";
		    		try (PreparedStatement pstmt = connection.prepareStatement(createLog)) {
		                pstmt.setString(1, logType.getText());
		                pstmt.setString(2, logTitle.getText());
		                pstmt.setString(3, logDescription.getText());
		                pstmt.setString(4, logDate.getText()); 
		                pstmt.setString(5, logTime.getText());

		                // Execute the update
		                pstmt.executeUpdate();
		                executed = true;
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
	    	    
	    	    }
	    	    if(executed) {
	    	    	logTitle.clear();
	    	    	logType.clear();
	    	    	logDate.clear();
	    	    	logTime.clear();
	    	    	logDescription.clear();
	    	    	loggerPane.setVisible(false);
	    	    }
    	    }
    	
    }
    
    @FXML
    void closeLog(ActionEvent event) {
    	logTitle.clear();
    	logType.clear();
    	logDate.clear();
    	logTime.clear();
    	logDescription.clear();
    	loggerPane.setVisible(false);
   
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
    
    public static boolean isValidDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate.parse(dateString, formatter);
            return true; // Parsing successful, valid date
        } catch (Exception e) {
            return false; // Parsing failed, not a valid date
        }
    }

    public static boolean isValidTime(String timeString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(timeString, formatter);
            return true; // Parsing successful, valid time
        } catch (Exception e) {
            return false; // Parsing failed, not a valid time
        }
    }

 
}
