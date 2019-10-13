package bahar.model.entity;

public class ExperienceType extends Experiences {
    private int exTypeID;
    private String exType;

    public ExperienceType() {
    }

    public ExperienceType(int exTypeID, String exType) {
        this.exTypeID = exTypeID;
        this.exType = exType;
    }

    public int getExTypeID() {
        return exTypeID;
    }

    public ExperienceType setExTypeID(int exTypeID) {
        this.exTypeID = exTypeID;
        return this;
    }

    public String getExType() {
        return exType;
    }

    public ExperienceType setExType(String exType) {
        this.exType = exType;
        return this;
    }
}
