package com.company.controllers;

import com.company.models.CalculateGPA;
import com.company.models.University;
import com.company.views.CmdLineView;

import java.util.ArrayList;

public class Main {

    public static String [][] courseGrade = new String[100][2];
    public static String [][] univNameRRGrade = new String[100][2];
    private static int total = 0;
    private static float gpa;
    private static int numCourses = 0;

    public static void main(String[] args) {

        DBConnect db = new DBConnect("universityInfo.db");
        db.createNewDatabase();
        db.addTables();

        CmdLineView usrInput = new CmdLineView();

        int usrSelection = usrInput.usrSelectionInput();
        if ( usrSelection == 1) {
            // Manage university Info
            usrInput.usrUniversityInfoInput();
            int numUniversities = usrInput.getNumUniversities();
            univNameRRGrade = usrInput.getUnivInfo();
            for (int i = 0; i< numUniversities;i++) {
                db.addData(univNameRRGrade[i][0], Double.valueOf(univNameRRGrade[i][1]));
            }
            System.out.println("Completed adding University Info....");

        }
        else if ( usrSelection == 2){
            usrInput.usrStudentCourseInput();
            courseGrade = usrInput.getCourseGrade();
            numCourses = usrInput.getNumCourses();

            CalculateGPA calculateGPA = new CalculateGPA(courseGrade, numCourses);
            double studentGPA = calculateGPA.getTotalGPA();
            System.out.println("Your GPA is: " + studentGPA);

            ArrayList<University> theUniversities = db.getUnivMatchData(studentGPA);
            int j=0;
            for(University university : theUniversities){
                usrInput.printMatchedcollege(university.toString(), studentGPA, j);
                j++;
            }
            System.out.println("Good Luck with your applications!!! ");
        }
        else {
            System.out.println(" Invalid Entry.....");
        }

    }
}
