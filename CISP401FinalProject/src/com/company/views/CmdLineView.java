package com.company.views;

import java.util.Scanner;

public class CmdLineView {

    private int numCourses=0;
    private int numUniversities=0;
    private String [][] courseGrade = new String[100][2];
    private String [][] universityInfo = new String[100][2];
    private String[][] matchedColleges;

    public CmdLineView() {

        //this.courseGrade = courseGrade;
        this.numCourses = numCourses;
        this.numUniversities = numUniversities;
    }
    public int usrSelectionInput(){
        System.out.println("Enter 1 To Manage University Info or 2 To Match to Universities: ");
        int x = 1;
        int selectionVal = 0;
        while (x == 1){
            Scanner courseInput = new Scanner(System.in);
            String inputString = courseInput.nextLine();
            try{

                Integer.parseInt(inputString);
                x = 0;
                selectionVal = Integer.parseInt(inputString);
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid number. Please enter either 1 or 2...");
            }
        }
        return selectionVal;
    }
    public void usrStudentCourseInput(){
        int x = 1;
        while (x==1) {
            System.out.println("Enter Number of courses: ");
            Scanner courseInput = new Scanner(System.in);
            String inputString = courseInput.nextLine();
            try {
                Integer.parseInt(inputString);
                x = 0;


                int numCourses = Integer.parseInt(inputString);
                //System.out.print("Number - "+ numCourses);
                this.numCourses = numCourses;
                for (int i = 0; i < numCourses; i++) {
                    System.out.println("Enter Course Name: ");
                    inputString = courseInput.nextLine();
                    courseGrade[i][0] = inputString;

                    System.out.println("Enter Course Grade: ");
                    inputString = courseInput.nextLine();
                    courseGrade[i][1] = inputString;
                    if (!(courseGrade[i][1].equals("A") ) && !(courseGrade[i][1].equals("B")) && !(courseGrade[i][1].equals("C")) &&
                            !(courseGrade[i][1].equals("D")) && !(courseGrade[i][1].equals("F"))) {
                        System.out.println("Please enter a course grade: A, B, C, D or F...");
                        i--;
                    }
                    //System.out.println("Course: " + courseGrade[i][0] + "  Grade: " +courseGrade[i][1]);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Not a valid number. Please enter the number of courses...");
            }
        }
    }
    //Add University Info
    public void usrUniversityInfoInput(){
        System.out.println("Enter Number of Universities: ");
        Scanner univInput = new Scanner(System.in);
        String inputUnivString = univInput.nextLine();
        int numUniversities = Integer.parseInt(inputUnivString);

        this.numUniversities = numUniversities;
        for(int i=0; i <numUniversities; i++) {
            System.out.println("Enter University Name : " + i+1);
            inputUnivString = univInput.nextLine();
            universityInfo[i][0] = inputUnivString;

            System.out.println("Enter Required GPA: ");
            inputUnivString = univInput.nextLine();
            universityInfo[i][1] = inputUnivString;

        }
    }

    //courses are printed with an introduction
    public void printMatchedcollege(String collegeName, Double studentGPA, int j) {
        if (j==0){
            System.out.println("With a GPA of " + studentGPA + ", these are some colleges that match your profile:");
        }
        System.out.println(collegeName);
    }
    public String [][] getCourseGrade() {
        return this.courseGrade;
    }
    public int getNumCourses() {
        return this.numCourses;
    }
    public String [][] getUnivInfo() {
        return this.universityInfo;
    }
    public int getNumUniversities() {
        return this.numUniversities;
    }

}
