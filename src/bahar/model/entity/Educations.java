package bahar.model.entity;

public class Educations extends Employees {
    private long employeeID;
    private long educationID;
    private String field;
    private int degreeID;
    private String university;

    public Educations() {
    }

    public Educations(long employeeID, long educationID, String field, int degreeID, String university) {
        this.employeeID = employeeID;
        this.educationID = educationID;
        this.field = field;
        this.degreeID = degreeID;
        this.university = university;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public Educations setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public long getEducationID() {
        return educationID;
    }

    public Educations setEducationID(long educationID) {
        this.educationID = educationID;
        return this;
    }

    public String getField() {
        return field;
    }

    public Educations setField(String field) {
        this.field = field;
        return this;
    }

    public int getDegreeID() {
        return degreeID;
    }

    public Educations setDegreeID(int degreeID) {
        this.degreeID = degreeID;
        return this;
    }

    public String getUniversity() {
        return university;
    }

    public Educations setUniversity(String university) {
        this.university = university;
        return this;
    }
}
