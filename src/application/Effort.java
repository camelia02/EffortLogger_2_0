package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;


public class Effort {
	private LocalDate date;
    private LocalTime startTime;
    private LocalTime stopTime;
    private String projectName;
    private String lifeCycleStep;
    private String effortCategory;
    private String deliverable;

    public Effort(String Sdate, String SstartTime, String SstopTime, String projectName,
                  String lifeCycleStep, String effortCategory, String deliverable, LocalDate date) throws ParseException {
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date parsedDate = dateFormat.parse(Sdate);
        
        // Convert java.util.Date to LocalDate and LocalTime
        date = parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        startTime = parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        // Similarly parse the stopTimeString and create a LocalTime object
        java.util.Date parsedDate2 = dateFormat.parse(SstopTime);
        stopTime = parsedDate2.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    	
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.projectName = projectName;
        this.lifeCycleStep = lifeCycleStep;
        this.effortCategory = effortCategory;
        this.deliverable = deliverable;
    }

    // Getters and Setters
    public LocalDate getDate() {
        return dat9e;
    }

    public void setDate(LocalDate date5) {
        this.date = date5;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalTime stopTime) {
        this.stopTime = stopTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLifeCycleStep() {
        return lifeCycleStep;
    }

    public void setLifeCycleStep(String lifeCycleStep) {
        this.lifeCycleStep = lifeCycleStep;
    }

    public String getEffortCategory() {
        return effortCategory;
    }

    public void setEffortCategory(String effortCategory) {
        this.effortCategory = effortCategory;
    }

    public String getDeliverables() {
        return deliverable;
    }

    public void setDeliverables(String deliverable) {
        this.deliverable = deliverable;
    }

    @Override
    public String toString() {
        return "Effort{" +
                "date=" + date +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                ", projectName='" + projectName + '\'' +
                ", lifeCycleStep='" + lifeCycleStep + '\'' +
                ", effortCategory='" + effortCategory + '\'' +
                ", deliverables='" + deliverable + '\'' +
                '}';
    }

}
