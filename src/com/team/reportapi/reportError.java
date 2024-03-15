package com.team.reportapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class reportError {
    public static void main(String[] args) {
        String csvFile1 = "raw\\1400.csv";
        Set<String> set = new HashSet<>();
        String line;
        String cvsSplitBy = ",";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFile1));

            while ((line = br.readLine()) != null) {
                set.add(line);
                String[] column = line.split(cvsSplitBy);

                // cetak nilai semua kolom
                if (!column[4].equals("0")) {
                    System.out.println(column[0]+'/'+column[1]+column[2]+" | Success Count: " +" | Error Count: " + column[3]+" | Response Code: " + column[4]);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
