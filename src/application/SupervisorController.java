package application;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.controlsfx.control.ToggleSwitch;
// custom
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class SupervisorController implements Initializable {

    @FXML
    private PieChart CSAT_pie;

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
    private Pane avg_completion_pane;

    @FXML
    private Rectangle avg_completion_rect;

    @FXML
    private TableView<?> collab_chat_members_table;

    @FXML
    private TableView<?> collab_chat_members_table1;

    @FXML
    private Button collab_proj1_open_btn;

    @FXML
    private Button collab_proj2_open_btn;

    @FXML
    private Pane collab_proj_open_pane1;

    @FXML
    private Pane collab_proj_open_pane2;

    @FXML
    private TableView<?> collab_tasks_files_table;

    @FXML
    private TextArea collab_type_message_textarea;

    @FXML
    private TextArea collab_type_message_textarea1;

    @FXML
    private TableView<?> cust_calls_resolved_table;

    @FXML
    private Label cust_inbound_calls_total;

    @FXML
    private Label cust_inbound_calls_wait_time;

    @FXML
    private TableView<?> cust_queue_agents_table;

    @FXML
    private Label cust_queue_calls_waiting;

    @FXML
    private Label cycle_CODING;

    @FXML
    private Label cycle_DEPLOY;

    @FXML
    private Label cycle_PICKUP;

    @FXML
    private Label cycle_avg_time;

    @FXML
    private Label cycle_review;

    @FXML
    private ToggleSwitch darkModeButton;

    @FXML
    private Label dateLabel;

    @FXML
    private Button defectButton;

    @FXML
    private Pane defects_pane;

    @FXML
    private Rectangle defects_rect;

    @FXML
    private Button deploymentButton;

    @FXML
    private Button edit_access_perms_btn;

    @FXML
    private Button edit_access_perms_btn1;

    @FXML
    private ToggleSwitch emailNotifButton;

    @FXML
    private Pane est_acc_pane;

    @FXML
    private Rectangle est_acc_rect;

    @FXML
    private Button eventButton;

    @FXML
    private Button exitButton;

    @FXML
    private VBox homescreen1;

    @FXML
    private RadioButton mainCollabButton;

    @FXML
    private Pane mainCollabPane;

    @FXML
    private RadioButton mainCustSuppButton;

    @FXML
    private Pane mainCustSupportPane;

    @FXML
    private RadioButton mainExportButton;

    @FXML
    private Pane mainExportPane;

    @FXML
    private Pane mainHomePane;

    @FXML
    private RadioButton mainMenuButton;

    @FXML
    private RadioButton mainPrivacyButton;

    @FXML
    private Pane mainPrivacyPane;

    @FXML
    private RadioButton mainProjectButton;

    @FXML
    private Pane mainProjectPane;

    @FXML
    private RadioButton mainReportButton;

    @FXML
    private Pane mainReportPane;

    @FXML
    private RadioButton mainSettingsButton;

    @FXML
    private Pane mainSettingsPane;

    @FXML
    private RadioButton mainTeamButton;

    @FXML
    private Pane mainTeamPane;

    @FXML
    private ToggleGroup navMainTab;

    @FXML
    private ToggleSwitch notifSoundButton;

    @FXML
    private Button performanceButton;

    @FXML
    private Pane project1_open_pane;

    @FXML
    private Label project1_open_title;

    @FXML
    private Label project_1_title;

    @FXML
    private TextArea project_1_names;

    @FXML
    private Button project_1_open_btn;

    @FXML
    private Pane project_1_pane;

    @FXML
    private Button project_1_perc;

    @FXML
    private Rectangle project_1_rect;

    @FXML
    private Label project_2_title;

    @FXML
    private TextArea project_2_names;

    @FXML
    private Button project_2_open_btn;
    
    @FXML
    private Pane project_2_pane;

    @FXML
    private Button project_2_perc;

    @FXML
    private Rectangle project_2_rect;

    @FXML
    private Button project_add_mem;

    @FXML
    private Button project_add_mem1;

    @FXML
    private Button project_add_mem3;

    @FXML
    private Button project_add_stakeholder;

    @FXML
    private VBox project_vbox_list;

    @FXML
    private TextField reportDate;

    @FXML
    private TextField reportDate1;

    @FXML
    private TextField reportDescription;

    @FXML
    private TextField reportDescription1;

    @FXML
    private TextField reportTimeSpent;

    @FXML
    private TextField reportTimeSpent1;

    @FXML
    private TextField reportTitle;

    @FXML
    private TextField reportTitle1;

    @FXML
    private TextField reportType;

    @FXML
    private TextField reportType1;

    @FXML
    private Button reportUpdate;

    @FXML
    private Button reportUpdate1;

    @FXML
    private Label roleLabel;

    @FXML
    private Button securityButton;

    @FXML
    private Button shrinkButton;

    @FXML
    private Pane similar_proj_pane;

    @FXML
    private Rectangle similar_proj_rect;

    @FXML
    private TextArea stakeholder1_day;

    @FXML
    private TextArea stakeholder1_hour;

    @FXML
    private TextArea stakeholder1_month;

    @FXML
    private Label stakeholder1_name;

    @FXML
    private ToggleSwitch stakeholder1_toggleSwitch;

    @FXML
    private TextArea stakeholder1_week;

    @FXML
    private TextArea stakeholder1_year;

    @FXML
    private TextArea stakeholder2_day;

    @FXML
    private TextArea stakeholder2_hour;

    @FXML
    private TextArea stakeholder2_month;

    @FXML
    private Label stakeholder2_name;

    @FXML
    private ToggleSwitch stakeholder2_toggleSwitch;

    @FXML
    private TextArea stakeholder2_week;

    @FXML
    private TextArea stakeholder2_year;

    @FXML
    private Pane stakeholder_pane1;

    @FXML
    private Pane stakeholder_pane11;

    @FXML
    private Pane stories_pane;

    @FXML
    private Rectangle stories_rect;

    @FXML
    private Pane story_points_pane;

    @FXML
    private Rectangle story_points_rect;

    @FXML
    private HBox taskOverview1;

    @FXML
    private Label team_1;

    @FXML
    private Button team_1_btn;

    @FXML
    private TextArea team_1_names;

    @FXML
    private Pane team_1_open_pane;

    @FXML
    private Pane team_1_pane;

    @FXML
    private Label team_2;

    @FXML
    private Label team_21;

    @FXML
    private Button team_2_btn;

    @FXML
    private TextArea team_2_names;

    @FXML
    private Pane team_2_pane;

    @FXML
    private Button team_add_mem;

    @FXML
    private Button team_add_mem1;

    @FXML
    private Button team_add_mem11;

    @FXML
    private Label team_open_member_1;

    @FXML
    private Label team_open_member_2;

    @FXML
    private Label timeLabel;

    @FXML
    private TextArea tm1_curProjects;

    @FXML
    private TextArea tm1_dev;

    @FXML
    private TextArea tm1_roles;

    @FXML
    private TextArea tm1_workload;

    @FXML
    private TextArea tm2_curProjects;

    @FXML
    private TextArea tm2_dev;

    @FXML
    private TextArea tm2_roles;

    @FXML
    private TextArea tm2_workload;

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
    private ToggleButton username_2_1_button;

    @FXML
    private ImageView username_2_1_img;

    @FXML
    private ToggleButton username_2_2_button;

    @FXML
    private ToggleButton username_2_3_button;

    @FXML
    private ImageView username_2_3_img;
    
    @FXML
    private VBox team_1_vbox;
    
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
    private Pane loggerPane;
    
    @FXML
    private Pane exportPane;
    
    @FXML
    private Button type;
    
    @FXML
    private Button close;
    
    @FXML
    private Label activityLogs;

    private Stop[] stops;
    
    private LinearGradient lg;    

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
	
	public SupervisorController() {
		
	}

	public SupervisorController(Connection connection) {
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
    public void initialize(URL url, ResourceBundle resourceBundle){
    	
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
				
		username_1_1_button.setGraphic(new ImageView(grey_circle));
		username_1_2_button.setGraphic(new ImageView(grey_circle));
		username_1_3_button.setGraphic(new ImageView(grey_circle));
		
		username_2_1_button.setGraphic(new ImageView(grey_circle));
		username_2_2_button.setGraphic(new ImageView(grey_circle));
		username_2_3_button.setGraphic(new ImageView(grey_circle));
		
		// make linear gradient for project
		stops = new Stop[] {new Stop(0, Color.web("0xF6BFC6")), new Stop(1, Color.WHITE)};
        lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		
        // not used here
//		stories_rect.setFill(lg);
//		story_points_rect.setFill(lg);
//		est_acc_rect.setFill(lg);
//		avg_completion_rect.setFill(lg);
//		similar_proj_rect.setFill(lg);
//		defects_rect.setFill(lg);
//		
//		draggableMaker.makeDraggable(stories_pane);
//		draggableMaker.makeDraggable(story_points_pane);
//		draggableMaker.makeDraggable(est_acc_pane);
//		draggableMaker.makeDraggable(avg_completion_pane);
//		draggableMaker.makeDraggable(similar_proj_pane);
//		draggableMaker.makeDraggable(defects_pane);
        displayReportDetails();
        exportPane.setVisible(false);
        exportPane.toBack();
        
    }
    
    

    @FXML
    void collabOpenClicked1(ActionEvent event) {
    	if (!collab_proj_open_pane1.isVisible()) {
    		collab_proj_open_pane1.setVisible(true);
    	} else {
    		collab_proj_open_pane1.setVisible(false);
    	}
    }

    @FXML
    void collabOpenClicked2(ActionEvent event) {
    	if (!collab_proj_open_pane2.isVisible()) {
    		collab_proj_open_pane2.setVisible(true);
    	} else {
    		collab_proj_open_pane2.setVisible(false);
    	}
    }

    @FXML
    void editAccessPermission(ActionEvent event) {
    	// FIXME
    }
    
    @FXML
    void projectAddMember(ActionEvent event) {
    	// FIXME
    }

    @FXML
    void projectAddStakeholder(ActionEvent event) {
    	// FIXME
    }
    
    @FXML
    void projectOpenClicked(ActionEvent event) {
    	//project_vbox_list.setVisible(false);
    	project1_open_pane.setVisible(true);
    }
    
    @FXML
    void teamAddMember(ActionEvent event) {
    	// FIXME
    }

    @FXML
    void chooseFile(ActionEvent event) {
    	exportPane.setVisible(true);
    	exportPane.toFront();
    }
    
    @FXML
    void teamOpenClicked(ActionEvent event) {
    	team_1_open_pane.setVisible(true);
    	team_1_vbox.setVisible(false);
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
    void createReport(ActionEvent event) {
    	loggerPane.setVisible(true);
    	type.setText("Create new report");
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
    
  
    @FXML
    void mainCollabClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(true);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);

    }

    @FXML
    void mainCustSuppClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(true);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);

    }

    @FXML
    void mainExportClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(true);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    	exportPane.setVisible(false);
    	displayLog();

    }

    @FXML
    void mainHomeClicked(ActionEvent event) {
    	mainHomePane.setVisible(true);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    }

    @FXML
    void mainPrivacylicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(true);
    	mainSettingsPane.setVisible(false);

    }

    @FXML
    void mainProjectClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(true);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    	
    	if (project1_open_pane.isVisible()) {
    		project1_open_pane.setVisible(false);
    	}
    }
	
    @FXML
    void mainReportClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(true);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);

    }

    @FXML
    void mainSettingsClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(false);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(true);

    }

    @FXML
    void mainTeamClicked(ActionEvent event) {
    	mainHomePane.setVisible(false);
    	mainProjectPane.setVisible(false);
    	mainReportPane.setVisible(false);
    	mainTeamPane.setVisible(true);
    	mainCollabPane.setVisible(false);
    	mainExportPane.setVisible(false);
    	mainCustSupportPane.setVisible(false);
    	mainPrivacyPane.setVisible(false);
    	mainSettingsPane.setVisible(false);
    	
    	if (team_1_open_pane.isVisible()) {
    		team_1_open_pane.setVisible(false);
    		team_1_vbox.setVisible(true);
    	}

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
    	
		else if (event.getSource() == username_2_1_button) {
    		if (checkGray(username_2_1_button)) {
    			username_2_1_button.setGraphic(new ImageView(green_circle));
    		} else {
    			username_2_1_button.setGraphic(new ImageView(grey_circle));
    		}
		}
		    	
		else if (event.getSource() == username_2_2_button) {
    		if (checkGray(username_2_2_button)) {
    			username_2_2_button.setGraphic(new ImageView(green_circle));
    		} else {
    			username_2_2_button.setGraphic(new ImageView(grey_circle));
    		}
		}
		    	
		else if (event.getSource() == username_2_3_button) {
    		if (checkGray(username_2_3_button)) {
    			username_2_3_button.setGraphic(new ImageView(green_circle));
    		} else {
    			username_2_3_button.setGraphic(new ImageView(grey_circle));
    		}
		}
    } // void usernameToggleClicked(ActionEvent event)

    boolean checkGray(ToggleButton btn) {
    	if (((ImageView) btn.getGraphic()).getImage().equals(grey_circle)) {
    		//System.out.println("grey_circle match");
    		return true;
    		
    	}
    	return false;
    } //boolean checkGray(ToggleButton btn)
    
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

}