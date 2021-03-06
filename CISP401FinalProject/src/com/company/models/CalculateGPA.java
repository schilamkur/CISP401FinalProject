package com.company.models;

public class CalculateGPA {

    private double totalGPA;
    private int numCourses;
    private String [][] courseGrade;

    public CalculateGPA(String [][] courseGrade, int numCourses) {

        this.courseGrade = courseGrade;
        this.numCourses = numCourses;
    }

    public double getTotalGPA() {
        int total = 0;
        for (int j = 0; j < numCourses; j++){
            if (courseGrade[j][1].equals("A")){
                total = total + 4;
            }
            else if (courseGrade[j][1].equals("B")){
                total = total + 3;
            }
            else if (courseGrade[j][1].equals("C")){
                total = total + 2;
            }
            else if (courseGrade[j][1].equals("D")) {
                total = total + 1;
            }
            else {
                total = total + 0;
            }
        }
        totalGPA =  (float)total / numCourses;
        return totalGPA;
    }

    public void setTotalGPA(double totalGPA) {
        this.totalGPA = totalGPA;
    }

}
