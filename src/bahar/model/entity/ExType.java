package bahar.model.entity;

public class ExType {
    private int id;
    private String exType;

    public ExType() {
    }

    public ExType(int id, String exType) {
        this.id = id;
        this.exType = exType;
    }

    public int getId() {
        return id;
    }

    public ExType setId(int id) {
        this.id = id;
        return this;
    }

    public String getExType() {
        return exType;
    }

    public ExType setExType(String exType) {
        this.exType = exType;
        return  this;
    }
}
