package bahar.model.entity;

public class JobEmployee {
    private long jobEmployeeID;
    private long jobID;
    private long employeeID;

    public JobEmployee() {
    }

    public JobEmployee(long jobEmployeeID, long jobID, long employeeID) {
        this.jobEmployeeID = jobEmployeeID;
        this.jobID = jobID;
        this.employeeID = employeeID;
    }

    public long getJobEmployeeID() {
        return jobEmployeeID;
    }

    public JobEmployee setJobEmployeeID(long jobEmployeeID) {
        this.jobEmployeeID = jobEmployeeID;
        return this;
    }

    public long getJobID() {
        return jobID;
    }

    public JobEmployee setJobID(long jobID) {
        this.jobID = jobID;
        return this;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public JobEmployee setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
        return this;
    }
}
