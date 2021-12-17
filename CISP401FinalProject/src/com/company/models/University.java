package com.company.models;

public class University {

    private double requiredGPA;
    private String univName;

    public University(double requiredGPA, String univName) {
        this.requiredGPA = requiredGPA;
        this.univName = univName;
    }

    public double getRequiredGPA() {
        return requiredGPA;
    }

    public void setRequiredGPA(double requiredGPA) {
        this.requiredGPA = requiredGPA;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    @Override
    public String toString(){
        return univName  + " with a required GPA of " + requiredGPA + ".";
    }

}
