package com.company.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetUniversitiesInfo {
    private BufferedReader in;
    private String[] universityInfo;

    public GetUniversitiesInfo() {

        try {
            Path thePath = Paths.get("src/" + "UniversitiesInfo.txt");

            in = new BufferedReader(new FileReader(String.valueOf(thePath)));
            List<String> lines = new ArrayList<>();
            String line = null;
            try{
                line = in.readLine();
                while(line != null){
                    lines.add(line);
                    line = in.readLine();
                }
                in.close();
                universityInfo = lines.toArray(new String[lines.size()]);

            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String[] getTheUniversities() {
        return universityInfo;
    }

    public void setTheUniversities(String[] universityInfo) {
        this.universityInfo = universityInfo;
    }

}
