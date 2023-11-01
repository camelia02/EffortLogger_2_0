package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {

    @FXML
    private ComboBox<String> categoryBox;

    @FXML
    private ComboBox<String> categoryEBox;

    @FXML
    private ComboBox<String> currDefBox;

    @FXML
    private ComboBox<String> cycleBox;

    @FXML
    private ComboBox<String> cycleEBox;

    @FXML
    private ComboBox<String> deliverableEBox;

    @FXML
    private ComboBox<String> deliverablesBox;

    @FXML
    private ComboBox<String> effortLogBox;

    @FXML
    private ComboBox<String> fixBox;

    @FXML
    private AnchorPane initializeConsole;

    @FXML
    private ComboBox<String> projectBox;

    @FXML
    private ComboBox<String> projectDBox;

    @FXML
    private ComboBox<String> projectEBox;
    
    @FXML
    private Label messageLabel;
    
    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;
    
    
    @FXML
    private Tab defect;

    @FXML
    private Tab definitions;
    
    @FXML
    private Tab editor;
    

    @FXML
    private Tab logConsole;

    @FXML
    private Tab logs;

    @FXML
    private Tab manager;
    
    @FXML
    private TabPane tabView;
    
    private String start;
    private String end;
    private Effort newEffort;
    private String project;
    private String cycle;
    private String effort;
    private String deliverable;
    
    public ObservableList<String> projects = FXCollections.observableArrayList("Business Project", "Development Project");
	public ObservableList<String> lifeCycles = FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting");
	public ObservableList<String> effortCategories = FXCollections.observableArrayList("Plans", "Deliverable", "Interuptions", "Defects", "Others");
	public ObservableList<String> deliverables = FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan");
    
    @FXML
    void initialize(int rank) {
		projectBox.setItems(projects);
		projectDBox.setItems(projects);
		projectEBox.setItems(projects);
		
		categoryBox.setItems(effortCategories);
		categoryEBox.setItems(effortCategories);
		
		cycleBox.setItems(lifeCycles);
		cycleEBox.setItems(lifeCycles);
		
		deliverablesBox.setItems(deliverables);
		deliverableEBox.setItems(deliverables);
		
		if(rank==1) {
			
		}
		
//		 logConsole.setOnSelectionChanged(event -> {
//		        if (logConsole.isSelected()) {
//		            System.out.println("Tab is Selected");
//		        }
//		    });
    }

    @FXML
    void clearDefectClicked(ActionEvent event) {

    }

    @FXML
    void clearEffortButton(ActionEvent event) {

    }
    
    @FXML
    void categorySelected(ActionEvent event) {
    	this.effort = categoryBox.getValue();
    	System.out.println("CATEGORY SELECTED: " + this.effort);
    }

    @FXML
    void closeClicked(ActionEvent event) {

    }

    @FXML
    void cycleSelected(ActionEvent event) {
    	this.cycle = cycleBox.getValue();
    	System.out.println("CYCLE SELECTED: " + this.cycle);
    }
    
    @FXML
    void defectNameEntered(ActionEvent event) {

    }

    @FXML
    void defectSelected(ActionEvent event) {

    }

    @FXML
    void deleteDefectClicked(ActionEvent event) {

    }

    @FXML
    void deleteEntryClicked(ActionEvent event) {

    }

    @FXML
    void deliverableESelected(ActionEvent event) {

    }

    @FXML
    void deliverableSelected(ActionEvent event) {
    	this.deliverable = deliverablesBox.getValue();
    	System.out.println("DELIVERABLE SELECTED: " + this.deliverable);
    }

    @FXML
    void effortSelected(ActionEvent event) {
    	
    }

    @FXML
    void fixSelected(ActionEvent event) {

    }

    @FXML
    void newDefectClicked(ActionEvent event) {

    }

    @FXML
    void projectSelected(ActionEvent event) {
    	this.project = projectBox.getValue();
    	System.out.println("CATEGORY SELECTED: " + this.project);
    }

    @FXML
    void reopenClicked(ActionEvent event) {

    }

    @FXML
    void splitEntryClicked(ActionEvent event) {

    }

    @FXML
    void startClicked(ActionEvent event) {
	    messageLabel.setText("Clock Started");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date currentDate = new Date();
	    start = dateFormat.format(currentDate);
	    startButton.setDisable(true);
    }

    @FXML
    void stopClicked(ActionEvent event) throws ParseException {
    	messageLabel.setText("Clock Stopped");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date currentDate = new Date();
	    end = dateFormat.format(currentDate);
	    
		if (this.project != null && this.cycle != null && this.effort != null && this.deliverable != null) {
            newEffort = new Effort(start, start, end, project, cycle, effort, deliverable);
            System.out.println(newEffort.toString());
            stopButton.setDisable(true);
        }	    
    }
    


    @FXML
    void symptomsEntered(ActionEvent event) {

    }

    @FXML
    void updateDefectClicked(ActionEvent event) {

    }

    @FXML
    void updateEntryClicked(ActionEvent event) {

    }

}
