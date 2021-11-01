package com.company.views;

import java.util.Scanner;

public class CmdLineView {

    private int numCourses;
    private String [][] courseGrade;

    public CmdLineView(String [][] courseGrade, int numCourses) {

        this.courseGrade = courseGrade;
        this.numCourses = numCourses;
    }
    public void usrCourseInput(){
        System.out.println("Enter Number of courses: ");
        Scanner courseInput = new Scanner(System.in);
        String inputString = courseInput.nextLine();
        int numCourses = Integer.parseInt(inputString);

        for(int i=0; i <numCourses; i++) {
            System.out.println("Enter Course Name: ");
            inputString = courseInput.nextLine();
            courseGrade[i][0] = inputString;

            System.out.println("Enter Course Grade: ");
            inputString = courseInput.nextLine();
            courseGrade[i][1] = inputString;

            System.out.println("Course: " + courseGrade[i][0] + "  Grade: " +courseGrade[i][1]);

        }

    }
    public String [][] getCourseGrade() {
        return this.courseGrade;
    }
    public int getNumCourses() {
        return this.numCourses;
    }

}
