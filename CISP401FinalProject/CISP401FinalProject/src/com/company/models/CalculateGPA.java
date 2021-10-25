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
        System.out.println("in TotalGPA");
        int total = 0;
        System.out.println("course grade lenghth = " +courseGrade.length);
        for (int j = 0; j < numCourses; j++){
            System.out.println("in For loop");
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
        System.out.println("in TotalGPA for loop");
        totalGPA =  total / numCourses;
        System.out.println("totalGPA=" + totalGPA);
        return totalGPA;
    }

    public void setTotalGPA(double totalGPA) {
        this.totalGPA = totalGPA;
    }
}
