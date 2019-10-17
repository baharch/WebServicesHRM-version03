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

    public Jobs setJobID(long jobID) {
        this.jobID = jobID;
        return  this;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public Jobs setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Jobs setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Jobs setDescription(String description) {
        this.description = description;
        return this;
    }
}
