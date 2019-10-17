package bahar.model.entity;

public class Degree {

    private int degreeID;
    private String degree;

    public Degree() {
    }

    public Degree(int degreeID, String degree) {
        this.degreeID = degreeID;
        this.degree = degree;
    }

    public int getDegreeID() {
        return degreeID;
    }

    public Degree setDegreeID(int degreeID) {
        this.degreeID = degreeID;
        return this;
    }

    public String getDegree() {
        return degree;
    }

    public Degree setDegree(String degree) {
        this.degree = degree;
        return this;
    }
}
