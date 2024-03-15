package com.team.reportapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class compareFile {
    public static void main(String[] args) {
        String csvFile1 = "raw\\jam12siang.csv";
//        String csvFile2 = "D:\\Project\\2022\\SOA Gov\\report\\table1.csv";
        String set3 = "";


        try {
            Set<String> set1 = new HashSet<>(readFile(csvFile1));
//            Set<String> set2 = new HashSet<>(readFile(csvFile2));

//            // mencari baris yang ada di file1 tetapi tidak ada di file2
//            set1.removeAll(set2);
//            System.out.println("\nBaris di file1 yang tidak ada di file2:");
//            set1.forEach(System.out::println);
//
//            // mencari baris yang ada di file2 tetapi tidak ada di file1
//            set2.removeAll(readFile(csvFile1)); // membaca ulang file1
//            System.out.println("\nBaris di file2 yang tidak ada di file1:\n");
//            set2.forEach(System.out::println);

            // ...

//            System.out.println(set1);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> readFile(String csvFile) throws IOException {
        Set<String> set = new HashSet<>();
        String line;
        String cvsSplitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        while ((line = br.readLine()) != null) {
            set.add(line);
            String[] column = line.split(cvsSplitBy);

            // cetak nilai semua kolom
            if (column[4]!="0") {
                System.out.println(column[0]+'/'+column[1]+column[2]+" | Success Count: " +" | Error Count: " + column[3]+" | Response Code: " + column[4]);
            }
        }

        br.close();
        return set;
    }
}
