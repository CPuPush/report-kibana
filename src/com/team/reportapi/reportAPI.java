package com.team.reportapi;

import java.io.*;
import java.util.*;

public class reportAPI {
    public static void main(String[] args) {
        String csvFile1 = "D:\\Project\\2022\\SOA Gov\\report\\table.csv";

        try {
            Set<String> set1 = new HashSet<>(readFile(csvFile1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> readFile(String csvFile) throws IOException {
        Set<String> set = new HashSet<>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        while ((line = br.readLine()) != null) {
            set.add(line);
        }

        br.close();
        return set;
    }
}
