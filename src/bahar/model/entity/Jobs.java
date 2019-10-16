package bahar.model.entity;

public class Jobs {
    private long jobID;
    private long employeeID;
    private String title;
    private String description;

    public Jobs() {
    }

    public Jobs(long jobID,long employeeID, String title, String description) {
        this.jobID = jobID;
        this.employeeID=employeeID;
        this.title = title;
        this.description = description;
    }

    public long getJobID() {
        return jobID;
    }

    public void setJobID(long jobID) {
        this.jobID = jobID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
