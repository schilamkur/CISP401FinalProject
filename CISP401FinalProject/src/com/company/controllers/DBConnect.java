package com.company.controllers;

import com.company.models.University;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    private String dbName;
    private String url;

    public DBConnect(String dbName) {
        this.dbName = dbName;
        this.url = "jdbc:sqlite:C:\\Users\\schil\\Documents\\sqlite\\db\\" + dbName;

    }

    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTables(){

        String sql = "CREATE TABLE IF NOT EXISTS universities (\n"
                + "	university_name text NOT NULL,\n"
                + "	required_gpa double NOT NULL\n"
                + ");";

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addData(String univName, double requiredGPA){

        String sql = "INSERT INTO universities(university_name, required_gpa) VALUES ('" + univName + "', '" + requiredGPA + "');";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("University -- " + univName  + " added successfully");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ArrayList<University> getUnivMatchData(double gpa){
        String sql = "SELECT required_gpa, university_name FROM universities WHERE required_gpa <= " + gpa;
        ArrayList<University> universityArrayList = new ArrayList<University>();

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            ResultSet matchedUniversities = statement.executeQuery(sql);
            while(matchedUniversities.next())
            {
                double req_gpa = matchedUniversities.getDouble("required_gpa");
                String university_name = matchedUniversities.getString("university_name");
                University university = new University(req_gpa, university_name);

                universityArrayList.add(university);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return universityArrayList;
    }


}
