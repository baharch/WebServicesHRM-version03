package bahar.model.entity;

public class Experiences extends Employees {
    private long employeeID;
    private long experienceID;
    private String exType;
    private String title;
    private String institute;
    private String exDate;


    public Experiences() {
    }

    public Experiences(long employeeID, long experienceID, String expType, String title, String institute, String exDate) {
        this.employeeID = employeeID;
        this.experienceID = experienceID;
        this.exType = exType;
        this.title = title;
        this.institute = institute;
        this.exDate = exDate;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public Experiences setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public long getExperienceID() {
        return experienceID;
    }

    public Experiences setExperienceID(long experienceID) {
        this.experienceID = experienceID;
        return this;
    }

    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    public String getTitle() {
        return title;
    }

    public Experiences setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getInstitute() {
        return institute;
    }

    public Experiences setInstitute(String institute) {
        this.institute = institute;
        return this;
    }

    public String getExDate() {
        return exDate;
    }

    public Experiences setExDate(String exDate) {
        this.exDate = exDate;
        return this;
    }
}
