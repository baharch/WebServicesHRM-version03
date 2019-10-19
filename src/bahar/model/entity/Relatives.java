package bahar.model.entity;

public class Relatives extends Employees {
    private long employeeID;
    private long relativeID;
    private String name;
    private String family;
    private String relation;

    public Relatives() {
    }

    public Relatives(long employeeID, long relativeID, String name, String family, String relation) {
        this.employeeID = employeeID;
        this.relativeID = relativeID;
        this.name = name;
        this.family = family;
        this.relation = relation;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public Relatives setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public long getRelativeID() {
        return relativeID;
    }

    public Relatives setRelativeID(long relativeID) {
        this.relativeID = relativeID;
        return this;
    }

    public String getName() {
        return name;
    }

    public Relatives setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Relatives setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getRelation() {
        return relation;
    }

    public Relatives setRelation(String relation) {
        this.relation = relation;
        return this;
    }
}
