package com.company.controllers;

public class MatchCollege {

    private String collegeMatched;
    double studentGPA;

    public MatchCollege(double studentGPA) {
        this.studentGPA = studentGPA;
        this.collegeMatched = " ";
    }
}