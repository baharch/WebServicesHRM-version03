package bahar.model.entity;

public class Degrees extends Educations {
    private int degreeID;
    private String degree;

    public Degrees() {
    }

    public Degrees(int degreeID, String degree) {
        this.degreeID = degreeID;
        this.degree = degree;
    }

    public int getDegreeID() {
        return degreeID;
    }

    public Degrees setDegreeID(int degreeID) {
        this.degreeID = degreeID;
        return this;
    }

    public String getDegree() {
        return degree;
    }

    public Degrees setDegree(String degree) {
        this.degree = degree;
        return this;
    }
}
