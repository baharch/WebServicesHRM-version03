package bahar.model.entity;

public class Addresses extends Employees {
    private long employeeID;
    private long addressID;
    private String city;
    private String street;
    private int houseNo;
    private int postalCode;

    public Addresses() {
    }

    public Addresses(long employeeID, long addressID, String city, String street, int houseNo, int postalCode) {
        this.employeeID = employeeID;
        this.addressID = addressID;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
        this.postalCode = postalCode;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public Addresses setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public long getAddressID() {
        return addressID;
    }

    public Addresses setAddressID(long addressID) {
        this.addressID = addressID;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Addresses setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Addresses setStreet(String street) {
        this.street = street;
        return this;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public Addresses setHouseNo(int houseNo) {
        this.houseNo = houseNo;
        return this;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public Addresses setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
