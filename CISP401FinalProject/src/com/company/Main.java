package com.company;

import java.util.Scanner;

public class Main {

    public static String [][] courseGrade = new String[100][2]; //0 is course name, 1 is course grade
    // convert the above to class which contains 2 variables course and grade
    private static int total = 0;
    private static float gpa;

    public static void main(String[] args) {

        // Convert the reading of the input into classes and methods
        // Enter Student grades associated with course taken
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


        // Convert the calculation of the GPA into class and methods
        // Calculating GPA
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

    gpa = total / numCourses;
    System.out.println("You're GPA is: " + gpa);

        //College matching - logic to be implemented
        // Based on the GPA, match the possible college matches
    }
}
