package com.company.controllers;

import com.company.models.MatchCollege;
import com.company.views.CmdLineView;

//import java.util.Scanner;

public class Main {

    public static String [][] courseGrade = new String[100][2]; //0 is course name, 1 is course grade
    // convert the above to class which contains 2 variables course and grade
    private static int total = 0;
    private static float gpa;
    private static int numCourses = 0;

    public static void main(String[] args) {

        // Converted the reading of the input into classes and methods
        // Added CmdLineView class
        // Enter Student grades associated with course taken
        /*System.out.println("Enter Number of courses: ");
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

        }*/

        CmdLineView usrInput = new CmdLineView(courseGrade);
        usrInput.usrCourseInput();
        courseGrade = usrInput.getCourseGrade();
        numCourses = usrInput.getNumCourses();

        System.out.println("Number of Courses - " + numCourses);


        // Convert the calculation of the GPA into class and methods
        // Calculating GPA
        System.out.println("Before GPA class");
        CalculateGPA calculateGPA = new CalculateGPA(courseGrade, numCourses);
        System.out.println("After GPA");
        double studentGPA = calculateGPA.getTotalGPA();
        System.out.println("StudentGPA");


    System.out.println("You're GPA is: " + studentGPA);

        //College matching - logic to be implemented
        // Based on the GPA, match the possible college matches
        // Read from File
        MatchCollege matchedCollegeName = new MatchCollege(studentGPA);


        System.out.println("Potential College - " + matchedCollegeName);

    }
}
