package bahar.model.entity;

public class Employees {
    private long employeeID;
    private String name;
    private String family;
    private String email;
    private int nationalCode;

    public Employees() {
    }

    public Employees(long employeeID, String name, String family, String email, int nationalCode) {
        this.employeeID = employeeID;
        this.name = name;
        this.family = family;
        this.email = email;
        this.nationalCode = nationalCode;
    }


    public long getEmployeeID() {
        return employeeID;
    }

    public Employees setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employees setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Employees setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employees setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public Employees setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }
}
