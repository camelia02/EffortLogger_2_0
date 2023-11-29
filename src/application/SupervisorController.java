package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

import java.sql.Connection;

import org.controlsfx.control.ToggleSwitch;
// custom
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class SupervisorController {

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


    private Stop[] stops;
    
    private LinearGradient lg;    

    private Image green_circle;
    
    private Image grey_circle;
    
    private Connection connection;
    private Employee employee;

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
	        System.err.println("Employee not set in MainSceneController");
	    }
	}
    
    @FXML
    void initialize() {
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
    void teamOpenClicked(ActionEvent event) {
    	team_1_open_pane.setVisible(true);
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
    

}