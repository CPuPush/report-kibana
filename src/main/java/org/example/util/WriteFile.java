package org.example.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public void writeReport(List<String> reports){
        String writeFile = "public/reportKibana.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile, false))){
            for(String report : reports){
                bw.write(report);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
